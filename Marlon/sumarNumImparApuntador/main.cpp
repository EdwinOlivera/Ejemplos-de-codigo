#include <iostream>

using namespace std;
void imprimirArreglo(int *apArregloNumero, int numDimension);
void llenarArreglo(int *apArregloNumero, int numDimension);
void sumarArreglo(int *apArregloNumero, int numDimension);
int main()
{
    int numIngresado, numDimension;
    int *apArregloNumero;
    cout<<"Ingrese la dimension del arreglo ";
    cin>>numDimension;

    int arregloNumero[numDimension];

    apArregloNumero  = &arregloNumero[0];
    llenarArreglo(apArregloNumero, numDimension);

    cout<<"El arreglo es: \n";
    imprimirArreglo(apArregloNumero, numDimension);
    sumarArreglo(apArregloNumero, numDimension);
    return 0;
}
void llenarArreglo(int *apArregloNumero, int numDimension)
{
    int numeroAIngresar=0, posicionNum=0;
    do
    {
        numeroAIngresar++;
        if(numeroAIngresar%2 !=0)
        {
            apArregloNumero[posicionNum] = numeroAIngresar;
            posicionNum++;
        }
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
}

void sumarArreglo(int *apArregloNumero, int numDimension)
{
    int posicionNum=0, suma = 0;
    do
    {
        suma += apArregloNumero[posicionNum];
        posicionNum++;
    }
    while(posicionNum<numDimension);
    cout<<"\nLa suma es "<<suma<<endl;
}
