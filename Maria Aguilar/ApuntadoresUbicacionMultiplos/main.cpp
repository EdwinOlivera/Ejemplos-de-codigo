#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void agregarNumerosAleatorios(int *, int);
void imprimirArreglo(int *, int);
void imprimirLosMultiplos(int *, int);

int main()
{
    int *apuntadorArreglo, dimensionArreglo;
    
    cout<<"Ingrese la dimension del arreglo ";
    cin>>dimensionArreglo;
    int arregloNumero[dimensionArreglo];
    apuntadorArreglo  = &arregloNumero[0];
    agregarNumerosAleatorios(apuntadorArreglo, dimensionArreglo);
    imprimirArreglo(apuntadorArreglo, dimensionArreglo);

    imprimirLosMultiplos(apuntadorArreglo, dimensionArreglo);
    return 0;
}
void agregarNumerosAleatorios(int *apuntadorArreglo, int dimensionArreglo)
{
    srand(time(NULL));
    int numeroAIngresar=10+rand()%(105), posicionNum=0;
    do
    {
        apuntadorArreglo[posicionNum] = numeroAIngresar;
        posicionNum++;
        numeroAIngresar=10+rand()%(105);
    }
    while(posicionNum<dimensionArreglo);
}
void imprimirArreglo(int *apuntadorArreglo, int dimensionArreglo)
{
    int posicionNumArreglo=0;
    do
    {
        cout<<apuntadorArreglo[posicionNumArreglo]<<' ';
        posicionNumArreglo++;
    }
    while(posicionNumArreglo<dimensionArreglo);
    cout<<endl;
}

void imprimirLosMultiplos(int *apuntadorArreglo, int dimensionArreglo)
{
    int posicion=0;
    do
    {
        if(apuntadorArreglo[posicion] % 5 ==0){
        cout<<"Elemento: "<<apuntadorArreglo[posicion]<<" Posicion: "<<posicion<<" Direccion: "<<&apuntadorArreglo[posicion]<<endl;
        }
        posicion++;
    }
    while(posicion<dimensionArreglo);
}

