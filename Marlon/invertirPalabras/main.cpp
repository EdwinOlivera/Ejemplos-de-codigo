#include <iostream>
#include <string.h>
using namespace std;

void alreves(char *cadena);
int main()
{
    char cadena[500];
    cin.getline(cadena,500);

    alreves(cadena);

    return 0;
}
void alreves(char *cadena)
{


    char* apC = NULL;

    int largoCadena = 0, indiceEspacioEnBlanco = 0, cantidadCaracteres = 0, ultimoIndicieEspacio=0;
    apC = &cadena[0];


    strlen(apC);

    int maxCaracteres = 0;

    maxCaracteres = strlen(apC)-1;
    while(*(apC+largoCadena)==' ')
    {
        *(apC+largoCadena)='\0';
        largoCadena++;
    }
    largoCadena=0;

    while(maxCaracteres > largoCadena)
    {
        if(*(apC+largoCadena)==' ')
        {
            for(int i =indiceEspacioEnBlanco-1; i>=ultimoIndicieEspacio; i--)
            {
                cout<<*(apC+i);
            }
            cout<<" ";
            ultimoIndicieEspacio=indiceEspacioEnBlanco;
        }
        cantidadCaracteres++;
        indiceEspacioEnBlanco++;
        largoCadena++;
    }

    while(ultimoIndicieEspacio <=maxCaracteres )
    {
        std::cout<<apC[maxCaracteres];
        maxCaracteres--;
    }
}

