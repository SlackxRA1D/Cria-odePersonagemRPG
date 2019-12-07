#include <Servo.h>
#include <SPI.h>
#include <Ethernet.h>

byte mac[] = { 0x1C, 0x6F, 0x65, 0xF6, 0xFD, 0x1C }; //endereço mac físico
byte ip[] = { 10, 10, 111, 44 }; // ip na lan
byte gateway[] = { 10, 10, 111, 254 }; // acesso a internet via roteador
byte subnet[] = { 255, 255, 255, 0 }; //mascara subnet
EthernetServer server(80); //porta do server

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
      delay(15); // esperar 1,5 segundos
    }
    delay(4000); // esperar 4 segundos
    for (pos = 180; pos >= 90; pos -= 1) {
      servo_9.write(pos);
      delay(15); // esperar 1,5 segundos
    }
  }
}

void loop() {
  EthernetClient client = server.available();
  if (client) {
    Serial.println("new client");
    // uma solicitação http termina com uma linha em branco
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();

        if (readString.length() < 100) {

          //armazenar caracteres em sequência
          readString += c;
          //Serial.print(c);
        }

        if (readString.indexOf("?action=1") > 0) //checks for on
          {
           moverServo();
          }

        Serial.write(c);
        if (c == '\n' && currentLineIsBlank) {
          //envie um cabeçalho de resposta http padrão
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");
          client.println();
          client.println("<!DOCTYPE HTML>");
          client.println("<html>");
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
          //começando uma nova linha
          currentLineIsBlank = true;
        }
        else if (c != '\r') {
          // personagem na linha atual
          currentLineIsBlank = false;
        }
      }
    }
    // tempo ao navegador para receber os dados
    delay(1);
    // fecha a conexão:
    client.stop();
    Serial.println("client disonnected");
    Serial.println(readString);

  }
}
