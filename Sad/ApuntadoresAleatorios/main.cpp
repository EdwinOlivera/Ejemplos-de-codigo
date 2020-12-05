#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void llenarArreglo(int *apArregloNumero, int numDimension);
void imprimirArreglo(int *apArregloNumero, int numDimension);
void imprimirMultiCinco(int *apArregloNumero, int numDimension);

int main()
{

    int numDimension;

    int *apArregloNumero;

    cout<<"Ingrese la dimension del arreglo ";
    cin>>numDimension;
    int arregloNumero[numDimension];
    apArregloNumero  = &arregloNumero[0];
    llenarArreglo(apArregloNumero, numDimension);

    imprimirArreglo(apArregloNumero, numDimension);
    imprimirMultiCinco(apArregloNumero, numDimension);
    return 0;
}
void llenarArreglo(int *apArregloNumero, int numDimension)
{
    srand(time(NULL));
    int numeroAIngresar=10+rand()%(105), posicionNum=0;
    do
    {
        apArregloNumero[posicionNum] = numeroAIngresar;
        posicionNum++;
        numeroAIngresar=10+rand()%(105);
    }
    while(posicionNum<numDimension);
}
void imprimirArreglo(int *apArregloNumero, int numDimension)
{
    int posicionNum=0;
    do
    {
        cout<<apArregloNumero[posicionNum]<<' ';
        posicionNum++;
    }
    while(posicionNum<numDimension);
    cout<<endl;
}

void imprimirMultiCinco(int *apArregloNumero, int numDimension)
{
    int posicionNum=0;
    do
    {
        if(apArregloNumero[posicionNum] % 5 ==0){
        cout<<"Elemento: "<<apArregloNumero[posicionNum]<<" Posicion: "<<posicionNum<<" Direccion: "<<&apArregloNumero[posicionNum]<<endl;
        }
        posicionNum++;
    }
    while(posicionNum<numDimension);
}

