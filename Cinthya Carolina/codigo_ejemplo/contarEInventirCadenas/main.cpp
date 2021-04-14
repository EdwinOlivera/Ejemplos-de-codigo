#include <iostream>
#include <string.h>
using namespace std;
int longitud(char cadena[]);
void invertir(char cadena[]);

int main()
{
    char cadena[21];
    std::cin.getline(cadena,21);

    std::cout<<longitud(cadena)<<std::endl;
    invertir(cadena);
    return 0;
}

int longitud(char cadena[])
{
    char* apC = NULL;

    apC = &cadena[0];


    int longitudaCadena = 0, caracter= 0;
    while(apC[caracter] != '\0' )
    {
        longitudaCadena++;
        caracter++;
    }
    return longitudaCadena;

}

void invertir(char cadena[])
{
    char* apC = NULL;

    apC = &cadena[0];


    int maxCaracteres = 0;
    maxCaracteres = longitud(cadena) -1;

    while(maxCaracteres >=0 )
    {
        std::cout<<apC[maxCaracteres];
        maxCaracteres--;
    }

}
