#include <iostream>
#include <cstring>
#include <string.h>
using namespace std;

void contenido(char [], char []);

int main()
{
    char PalabraABuscar[500], PalabraTotal[500];
    cout<<"Ingrese la palabra/parrafo/oracion (cadena) en la cual hara la busqueda"<<endl;
    cin.getline(PalabraTotal,500);
    cout<<"Ingrese la Palabra que desea buscar"<<endl;
    cin.getline(PalabraABuscar,500);

    contenido(PalabraTotal, PalabraABuscar);

    return 0;
}
void contenido(char PalabraTotal[], char PalabraABuscar[])
{

    int NumeroDeLetras=0;
    int Encontrado=0;
    char PalabraTotalchar[500], PalabraABuscarchar[500];
    NumeroDeLetras = strlen(PalabraABuscar); //Con esto almacenamos la cantidad (en numero) la cantidad de letras que tiene la cadena

    //En estos ciclos for se intercambia las cadenas de un String a un Char, para poder realizar la comprobacion
    for(int i=0; i<NumeroDeLetras; i++)
    {
        PalabraABuscarchar[i]= PalabraABuscar[i];
    }
    NumeroDeLetras = strlen(PalabraTotal);

    for(int i=0; i<NumeroDeLetras; i++)
    {
        PalabraTotalchar[i]= PalabraTotal[i];
    }

    Encontrado = strcmp(PalabraABuscarchar, PalabraTotalchar);
    if(Encontrado==1){
        cout<<"Si se ha encontrado la palaba en la cadena principal"<<endl;
    }else{
    cout<<"No se encuentra la palabra dentro de la candea"<<endl;
    }
}
