#include <iostream>
#include <cstring> //Se agrega esta biblioteca para hacer uso de las funciones de comparacion
#include <string.h>
using namespace std;

void contenido(string, string);

int main()
{
    string PalabraABuscar, PalabraTotal;//Esta son las variables que usaran para guardar las cadenas originalmente
    cout<<"Ingrese la palabra (cadena) en la cual hara la busqueda"<<endl;
    cin>>PalabraTotal;
    cout<<"Ingrese la Palabra (cadena) que desea buscar"<<endl;
    cin>>PalabraABuscar;

    contenido(PalabraTotal, PalabraABuscar);//aqui se hace el llamdo a la funcion

    return 0;
}
void contenido(string PalabraTotal, string PalabraABuscar)
{
    //Estas son variables que se declara dentro de la funcion(solo existen dentro de la funcion)
    int NumeroDeLetras=0;
    int Encontrado=0;
    char PalabraTotalchar[100], PalabraABuscarchar[100];
    NumeroDeLetras = PalabraABuscar.length(); //Con esto almacenamos la cantidad (en numero) la cantidad de letras que tiene la cadena

    //En estos ciclos for se intercambia las cadenas de un String a un Char, para poder realizar la comprobacion
    for(int i=0; i<NumeroDeLetras; i++)
    {
        PalabraABuscarchar[i]= PalabraABuscar[i];
    }
    NumeroDeLetras = PalabraTotal.length();

    for(int i=0; i<NumeroDeLetras; i++)
    {
        PalabraTotalchar[i]= PalabraTotal[i];
    }

    Encontrado = strcmp(PalabraABuscarchar, PalabraTotalchar); //medianta un metodo de la biblioteca cstring se compara los char
    if(Encontrado==1){//cuando Es positiva la comprobacion, devuelve 1 y si es falsa retorna -1
        cout<<"Si se ha encontrado la sub cadena en la cadena principal"<<endl;//Este mensaje unicamente aparecera si la comprobacion regreso 1 (tuvo exito)
    }
}
