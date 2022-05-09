#include<ESP8266WiFi.h>
#include<WiFiClient.h>
#include<ESP8266WebServer.h>
#include <SoftwareSerial.h>

SoftwareSerial espSerial(5, 6);
int p1=0,p2=0,p3=0,p4=0;
int c1=0,c2=0,c3=0,c4=0;

double total = 0;
int count_prod = 0;
pinMode(7,OUTPUT);
  pinMode(8,OUTPUT);
  
void setup(){
Serial.begin(115200);
espSerial.begin(115200);

delay(2000);
}
void loop()
{
Serial.begin(9600);

delay(1000);
if (Serial.available())
  {
    count = 0;
    while (Serial.available() && count < 12)
    {
      input[count] = Serial.read();
      count++;
      delay(5);
    }
    if (count == 12)
    {
      if ((strncmp(input, "0B00291F5B66", 12) == 0) && (a == 1))
      {
       
        Serial.print("TATA Salt Added       ");
        
        Serial.print("Price(Rs):35.00      ");
        p1++;
        digitalWrite(7,HIGH);
        digitalWrite(8,HIGH);
        delay(2000);
        total = total + 35.00;
        count_prod++;
        digitalWrite(7,LOW);
        digitalWrite(8,LOW);
        
      }
     
      }
      else if ((strncmp(input, "0B002920D0D2", 12) == 0) && (a == 1))
      {
        
        Serial.print("Soap Added          ");
      
        Serial.print("Price(Rs):38.00         ");
        total = total + 38.00;
        digitalWrite(7,HIGH);
        digitalWrite(8,HIGH);
        delay(2000);
        p2++;
        count_prod++;
        digitalWrite(7,LOW);
        digitalWrite(8,LOW);
      }
     
      else if ((strncmp(input, "0B002948A8C2", 12) == 0) && (a == 1))
      {
        
        Serial.print("Rice(1KG) Added       ");
      
        Serial.print("Price(Rs):55.00      ");
        total = total + 55.00;
        digitalWrite(7,HIGH);
         digitalWrite(8,HIGH);
        delay(2000);
        count_prod++;
        p3++;
     
        digitalWrite(7,LOW);
        digitalWrite(8,LOW);
      }
      
     
   
    
        Serial.print("Total Prod:");
        
        Serial.print(count_prod);
      
        Serial.print("Price:");
        
        Serial.print(total);
        
       
        delay(2000);
        Serial.print("   Thank you        ");
      
        Serial.print("  for Shopping        ");
        
      }
    }
    c1=p1*35.00;
    c2=p2*38.00;
    c3=p3*55.00;
    c4=p4*45.00;
  }
}
