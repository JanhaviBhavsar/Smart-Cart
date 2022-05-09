
#include <ESP8266WiFi.h>

WiFiServer server(8090);
IPAddress ip(192, 168, 0, 117);
IPAddress gateway(192, 168, 0, 1);
IPAddress subnet(255, 255, 255, 0);

void setup() {
  Serial.begin(115200);
  WiFi.config(ip, gateway, subnet);
  WiFi.begin("TP-LINK", "55555555");
  while (WiFi.status() != WL_CONNECTED) {
    delay(100);
  }
  server.begin();
  Serial.println("Connected");
}

void loop() {
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
  while(client.readString()){
    String str= client.readString();
    client.print(str);
  }
  
  delay(100);
  client.flush();
}
