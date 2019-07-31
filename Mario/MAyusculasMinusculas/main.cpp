#include <iostream>
#include <ctype.h>

using namespace std;

int main()
{
  char Cambio[50];
   int i;
char cadena[] = "Ejemplo";
   string TextoMayusculo = "HOLA ";
   string TextoMinuscula = "adios";
   for(i = 0; Cambio[i]; i++)
      Cambio[i] = tolower(cadena[i]); //<--convierte a minusculas

 cout<< Cambio<<endl;

    for(i = 0; Cambio[i]; i++)
      Cambio[i] = toupper(cadena[i]); //<--convierte a Mayusculas

 cout<< Cambio<<endl;
 for(i = 0; Cambio[i]; i++)
      Cambio[i] = tolower(TextoMayusculo[i]); //<---- Convierte Otra cualquier palabra en minuscula
 cout<< Cambio<<endl;

 for(i = 0; Cambio[i]; i++)
      Cambio[i] = toupper(TextoMinuscula[i]); //<---- Convierte Otra cualquier palabra en MAYUSCULA
 cout<< Cambio<<endl;

    return 0;
}
