#include<iostream>
#include <windows.h>
using namespace std;
//Declaraciones de las funciones a utilizar
bool comprobarPalabra(int, char*, char*);
int imprimirPalabraRojo(int, char*, char*);

int main(int argc, char** argv){

    system("color 01");//Esto coloca el texto en azul

    int CARACTERESPERMITIDOS= 100;
    //Los apuntadores
    char *apuntCadenaIngresada;
    char *apuntCadenaABuscar;

    //Variables para ingresar las cadenas
    char cadenaIngresada[CARACTERESPERMITIDOS];
    char cadenaABuscar[CARACTERESPERMITIDOS];

    //Contadores de operaciones
    int contadorDeCaracteres = 0;
    int cantidadPintadas = 0;

    cout<<"Ingrese un parrafo: ";
    cin.getline(cadenaIngresada,CARACTERESPERMITIDOS);

    apuntCadenaIngresada = &cadenaIngresada[0];//Aqui se apunta al inicio de la cadena ingresada

    cout<<"Ingrese la palabra a buscar: ";
    cin.getline(cadenaABuscar,CARACTERESPERMITIDOS);

    apuntCadenaABuscar = &cadenaABuscar[0];//Aqui se apunta al inicio de la cadena a Buscar


    cout<<endl<<endl;
//Ciclo while principal
    while(cadenaIngresada[contadorDeCaracteres] != '\0')
    {

        if(tolower( apuntCadenaIngresada[contadorDeCaracteres]) == tolower(apuntCadenaABuscar[0]) )
        {

            if(comprobarPalabra(contadorDeCaracteres, apuntCadenaIngresada, apuntCadenaABuscar))
            {

                contadorDeCaracteres = imprimirPalabraRojo(contadorDeCaracteres, apuntCadenaIngresada, apuntCadenaABuscar);
                cantidadPintadas++;
            }
            else
            {
                cout<<apuntCadenaIngresada[contadorDeCaracteres];
                contadorDeCaracteres++;
            }

        }
        else
        {
            cout<<apuntCadenaIngresada[contadorDeCaracteres];

            contadorDeCaracteres++;
        }


    }

    cout<<endl<<endl;
    return 0;
    cout<<"Se pinto "<<cantidadPintadas<<" veces la cadena '"<<cadenaABuscar<<"' en el parrafo."<<endl;
}

bool comprobarPalabra(int contadorDeCaracteres, char* apuntCadenaIngresada, char*apuntCadenaABuscar)
{
    bool cadenaIdenticas = true;
    int contadorInterno = 0 ;
    while(apuntCadenaABuscar[contadorInterno] != '\0')
    {

        if(tolower(apuntCadenaIngresada[contadorDeCaracteres])  != tolower(apuntCadenaABuscar[contadorInterno]) )
        {
            cadenaIdenticas = false;
        }
        contadorDeCaracteres++;
        contadorInterno++;
    }
    return cadenaIdenticas;
}

int imprimirPalabraRojo(int contadorDeCaracteres, char* apuntCadenaIngresada, char*apuntCadenaABuscar)
{
    int contadorInterno = 0 ;
    while(apuntCadenaABuscar[contadorInterno] != '\0')
    {

        if(tolower(apuntCadenaIngresada[contadorDeCaracteres])  == tolower(apuntCadenaABuscar[contadorInterno]) )
        {
            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),FOREGROUND_RED);
            cout<<apuntCadenaIngresada[contadorDeCaracteres];
            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),1);

        }
        contadorDeCaracteres++;
        contadorInterno++;
    }

    return contadorDeCaracteres;
}

