#include <Servo.h>
#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x90, 0xA2, 0xDA, 0x0F, 0x09, 0xA7 }; //physical mac address
byte ip[] = { 192, 168, 0, 99 }; // ip in lan
byte gateway[] = { 192, 168, 0, 1 }; // internet access via router
byte subnet[] = { 255, 255, 255, 0 }; //subnet mask
EthernetServer server(80); //server port

String readString;
int pos = 0;
Servo servo_9;
int counter;

boolean status = false;

void setup()
{
  servo_9.attach(9);

  //start Ethernet
  Ethernet.begin(mac, ip, gateway, subnet);
  server.begin();

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
  status = !status;
}

void loop()
{
  //Aguarda conexao do browser
  EthernetClient client = server.available();

  if (client) {
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();

        //read char by char HTTP request
        if (readString.length() < 100) {

          //store characters to string
          readString += c;
          //Serial.print(c);
        }
        //if HTTP request has ended
        if (c == '\n') {

          ///////////////
          Serial.println(readString); //print to serial monitor for debuging

          client.println("HTTP/1.1 200 OK"); //send new page
          client.println("Content-Type: text/html");
          client.println();

          client.println("<HTML>");
          client.println("<HEAD>");
          client.println("<meta http-equiv=\"refresh\" content=\"5\";>");
          client.println("<TITLE>Despejar Cloro</TITLE>");
          client.println("</HEAD>");
          client.println("<BODY style=background-color:#2e405c>");

          client.println("<center><H1><p style =\"font - family: fantasy; font - weight: 100\"><font color=\"white\">Deseja despejar o cloro?</H1></center>");

          client.println("<BR> </BR >");
          client.println("<center><form method=get name=MANUAL><input type=hidden name=action value=1 /><input type=submit value=DESPEJAR></form></center>");


          client.println("</BODY>");
          client.println("</HTML>");


          delay(1);
          //stopping client
          client.stop();

          ///////////////////// control arduino pin
          if (readString.indexOf("action=1") > 0) //checks for on
          {
            status= !status;
          }
          //clearing string for next read
          readString = "";
        }

        if (status = true){
          moverServo();
        }
      }
    }
  }
}
