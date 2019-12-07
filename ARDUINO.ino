#include <Servo.h>
#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x1C, 0x6F, 0x65, 0xF6, 0xFD, 0x1C }; //physical mac address
byte ip[] = { 10, 10, 111, 44 }; // ip in lan
byte gateway[] = { 10, 10, 111, 254 }; // internet access via router
byte subnet[] = { 255, 255, 255, 0 }; //subnet mask
EthernetServer server(80); //server port

String readString;
int pos = 0;
Servo servo_9;
int counter;

void setup()
{
  Serial.begin(9600);
  servo_9.attach(9);

  //start Ethernet
  while (!Serial) {
    ;
  }
  Serial.println("Ethernet WebServer Example");

  Ethernet.begin(mac, ip);
  server.begin();

  if (Ethernet.hardwareStatus() == EthernetNoHardware) {
    Serial.println("EthernetShield was not found. Sorry, can't run without hardware.");
    while (true) {
      delay(1);
    }
  }
}

void moverServo() {
  for (counter = 0; counter <= 1; ++counter) {
    for (pos = 90; pos <= 180; pos += 1) {
      servo_9.write(pos);
      delay(15); // Wait for 15 millisecond(s)
    }
    delay(4000); // Wait for 4000 millisecond(s)
    for (pos = 180; pos >= 90; pos -= 1) {
      servo_9.write(pos);
      delay(15); // Wait for 15 millisecond(s)
    }
  }
}

void loop() {
  EthernetClient client = server.available();
  if (client) {
    Serial.println("new client");
    // an http request ends with a blank line
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();

        if (readString.length() < 100) {

          //store characters to string
          readString += c;
          //Serial.print(c);
        }

        if (readString.indexOf("?action=1") > 0) //checks for on
          {
           moverServo();
          }

        Serial.write(c);
        // if you've gotten to the end of the line (received a newline
        // character) and the line is blank, the http request has ended,
        // so you can send a reply
        if (c == '\n' && currentLineIsBlank) {
          // send a standard http response header
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");
          client.println();
          client.println("<!DOCTYPE HTML>");
          client.println("<html>");
          // add a meta refresh tag, so the browser pulls again every 5 seconds:
          client.println("<HEAD>");
          client.println("<TITLE>Despejar Cloro</TITLE>");
          client.println("</HEAD>");
          client.println("<BODY>");
          client.println("<H1>Deseja despejar o cloro?</H1>");
          client.println("<form method=get name=MANUAL><input type=hidden name=action value=1 /><input type=submit value=DESPEJAR></form>");
          client.println("</BODY>");
          client.println("</HTML>");
          client.println("");
          client.println("");
          break;
        }
        if (c == '\n') {
          // you're starting a new line
          currentLineIsBlank = true;
        }
        else if (c != '\r') {
          // you've gotten a character on the current line
          currentLineIsBlank = false;
        }
      }
    }
    // give the web browser time to receive the data
    delay(1);
    // close the connection:
    client.stop();
    Serial.println("client disonnected");
    Serial.println(readString);

  }
}
