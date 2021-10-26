#include <iostream>
#include <string.h>
using namespace std;
bool validar(char *clave);
void cifrar(char *cadena, char *clave);
int main()
{

    string palabrClave = "";
    char cadenaACifrar[99], cadenaIngresada[99];
    cout<<"Ingrese una palabra clave: "<<endl;
    cin.getline(cadenaIngresada, 99);
    palabrClave = cadenaIngresada;

    while(palabrClave.length()>10)
    {
        cout<<"ERROR 1: La clave no debe contener mas de 10 caracteres"<<endl;
        cin.getline(cadenaIngresada, 99);
        palabrClave = cadenaIngresada;
    }
    while(!validar(&palabrClave[0]))
    {
        cout<<"ERROR 2: La clave no debe contener caracteres repetidos"<<endl;
        cin.getline(cadenaIngresada, 99);
        palabrClave = cadenaIngresada;
    }
    cout<<"Ingrese la cadena a cifrar: "<<endl;
    cin.getline(cadenaACifrar, 99);
    cifrar(cadenaACifrar, &palabrClave[0]);
    cout<<"La cadena cifrada con la clave ["<<palabrClave<<"] es: "<<endl;
    cout<<cadenaACifrar<<endl;

    return 0;
}
bool validar(char *clave)
{
    bool validacion = true;

    int contadorDeLetras  = 0;
    int letraActual = 0;
    char letrasMayusculas []="ABCDEFGHIJKLMNOPQRSTUVWXYZ", letrasMinusculas []="abcdefghijklmnoprstuvwxyz";

    for(int i=0; i<26; i++)
    {

        while(clave[letraActual] != '\0')
        {

            if(letrasMayusculas[i] == clave[letraActual])
            {
                contadorDeLetras++;
            }

            letraActual++;

        }
        if(contadorDeLetras>1)
        {
            validacion = false;
            break;
        }
        contadorDeLetras = 0;
        letraActual = 0;

    }

    for(int i=0; i<26; i++)
    {

        while(clave[letraActual] != '\0')
        {

            if(letrasMinusculas[i] == clave[letraActual])
            {
                contadorDeLetras++;
            }

            letraActual++;

        }
        if(contadorDeLetras>1)
        {
            validacion = false;
            break;
        }
        contadorDeLetras = 0;
        letraActual = 0;

    }


    return validacion;
}

void cifrar(char *cadena, char *clave)
{
    char numerosClaves[]="0123456789";

    int letraActualClave = 0, letraActualCadena = 0;

    while(cadena[letraActualCadena] != '\0')
    {

        while(clave[letraActualClave] != '\0')
        {

            if( cadena[letraActualCadena] == clave[letraActualClave])
            {

                cadena[letraActualCadena] = numerosClaves[letraActualClave];
            }
            letraActualClave++;

        }
        letraActualClave= 0;
        letraActualCadena++;

    }


}
