#include <Servo.h>
#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x70, 0x85, 0xC2, 0x7E, 0xF7, 0x13 }; //endereço mac físico
byte ip[] = { 192, 168, 100, 91 }; // ip na lan
byte gateway[] = { 192, 168, 100, 1 }; // acesso a internet via roteador
byte subnet[] = { 255, 255, 255, 0 }; //mascara subnet
EthernetServer server(80); //porta do server

String readString;
int pos = 180;
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
  
  servo_9.write(pos);
}

void moverServo() {
//  for (counter = 0; counter <= 1; ++counter) {

    for (pos = 180; pos >= 90; pos -= 1) {
      servo_9.write(pos);
      delay(15); // esperar 1,5 segundos
    }
    
    delay(5000); // esperar 4 segundos
    
    for (pos = 90; pos <= 180; pos += 1) {
      servo_9.write(pos);
      delay(15);
    }
 // }
}

void loop() {
  // Create a client connection
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
          Serial.println(readString); //print to serial monitor for debuging

          client.println("HTTP/1.1 200 OK"); //send new page
          client.println("Content-Type: text/html");
          client.println();
          client.println("<HTML>");
          client.println("<HEAD>");
          client.println("https://sanytamara.github.io/css-styles/style.css'");
          client.println("https://sanytamara.github.io/css-styles/bootstrap.css");
          client.println("<TITLE>Despejador de Cloro</TITLE>");
          client.println("</HEAD>");
          client.println("<BODY>");
          client.println("<div class=\"container-fluid\">");
          client.println("<div class=\"row\">");
          client.println("<div class='col-md-3'></div>");
          client.println("<div class='col-md-6'>");
          client.println("<div class='page-header'><center><h1>DESPEJADOR DE CLORO</h1></center></div>");
          client.println("</br>");
          client.println("<center><h2> Deseja despejar o cloro?</h2></center>");
          client.println("<br></br>");
          client.println("<div class='row'>");
          client.println("<div class='col-md-5'><img alt='Bootstrap Image Preview' src='https://thumbs.gfycat.com/ForthrightPositiveEasternglasslizard-max-1mb.gif'></div>");
          client.println("<div class='col-md-2'></div>");
          client.println("<div class='col-md-5'><br><form method=get name=MANUAL><input type=hidden name=action value=1 />");
          client.println("<button type='submit' class='btn btn-block btn-outline-primary'>DESPEJAR</button> </br></div>");
          client.println("</div>");

          client.println("</div><div class='col-md-3'></div>");
          client.println("</div></div>");
          client.println("");
          client.println("<center><br><p>Alunos: Sany Tamara, Matheus Felippe, Robert A. Medeiros</p></br></center>");
          client.println("</BODY>");
          client.println("</HTML>");

          delay(1);
          //stopping client
          client.stop();

          if (readString.indexOf("?action=1") > 0) {
            moverServo();
          }
          //clearing string for next read
          readString = "";

        }
      }
    }
  }
}
