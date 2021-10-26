#include <iostream>
#include <string.h>
using namespace std;
void codificar(char *cadena, int clave);
int main()
{
cout<<strcmp("Maria","maria");
    int clave = 1;
    char cadenaIngresada[26];
    cout<<"Ingrese una cadena:"<<endl;
    cin.get(cadenaIngresada, 26);
    cout<<"Ingrese una clave:"<<endl;
    cin>>clave;
    if(clave>26 || clave< 0)
    {
        clave =1;
    }
    if(clave<26 && clave>0)
    {
        codificar(cadenaIngresada,clave);
    }

    cout << "La cadena cifrada es: " << endl;
    cout<<cadenaIngresada<<endl;
    return 0;
}

void codificar(char *cadena, int clave)
{
    int letraActual = 0;
    int cantidadAvanzar = 1;
    char letrasMayusculas []="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char letraACambiar[]="";
    //cadena[1] ='g';
    while(cadena[letraActual] != '\0')
    {
        for(int i=0; i<26; i++)
        {
            if(letrasMayusculas[i] == cadena[letraActual])
            {
                if(i+clave >=25)
                {
                    cantidadAvanzar  = (i+clave);
                    cantidadAvanzar  = cantidadAvanzar - 25;

                }
                else
                {

                    cantidadAvanzar = i+clave;
                }
                letraACambiar[0] = letrasMayusculas[cantidadAvanzar];
                cadena[letraActual] = letraACambiar[0];

                break;
            }
        }
        letraActual++;

    }

}
