#include <iostream>

using namespace std;

int main(){
 int numero, dividendo, resto, divisor = 2;
 string binario = "";
 cout << "Ingrese el numero decimal a convertir a sistema binario" << endl;
 cin >> numero;
 dividendo = numero;
 while(dividendo >= divisor){ //Mientras el dividendo sea mayor o igual que el divisor, es decir, mayor o igual que 2.
 resto = dividendo % 2;
  if(resto == 1)
   binario = "1" + binario; //Si el resto es igual a 1 concatenamos 1 a la variable string llamada binario
  else
   binario = "0" + binario; // Sino concatemanos 0
  //Es importante este orden de concatenación (primero el bit y luego el valor de la variable) esto para que nuestro número
  //en sistema binario esté ordenado correctamente.
   dividendo = dividendo/divisor; // Actualizamos el valor del dividendo dividiendolo entre 2.
 }
  if(dividendo == 1)
   binario = "1" + binario; // Por último sí el valor final del dividendo es 1 concatenamos 1 sino concatenamos 0.
  else
   binario = "0" + binario;
  cout << "En sistema binario " << numero<< " se escribe " << binario << endl;
 return 0;
}
