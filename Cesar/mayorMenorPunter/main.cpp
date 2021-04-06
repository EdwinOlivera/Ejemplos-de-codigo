
#include <iostream>
#include <time.h>
#include <stdlib.h>

using namespace std;
void generarArreglo(int *, int );
void mostrarArreglo(int *, int );
void mostrarMinimo(int *, int );
void mostrarMaximo(int *, int );

int main()
{
        srand(time(NULL));
    int dimension = 0;
        cout<<"Ingrese la dimension del arreglo: ";
        cin>>dimension;
    int arregloDeNumeros[dimension];

    int* apunArreglo = NULL;
    apunArreglo = &arregloDeNumeros[0];
    generarArreglo(apunArreglo, dimension);
    mostrarArreglo(apunArreglo, dimension);
    mostrarMaximo(apunArreglo, dimension);
    mostrarMinimo(apunArreglo, dimension);
    return 0;
}




void generarArreglo(int *apuntador, int dimension)
{

    int numeroAIngresar=1+rand()%(199), posicionDelNumero=0;
    do
    {
        apuntador[posicionDelNumero] = numeroAIngresar;
        posicionDelNumero++;
        numeroAIngresar=1+rand()%(199);
    }
    while(posicionDelNumero<dimension);
}
void mostrarArreglo(int *apuntador, int dimension)
{
    int posicionDelNumero=0;
    do
    {
        cout<<apuntador[posicionDelNumero]<<' ';
        posicionDelNumero++;
    }
    while(posicionDelNumero<dimension);

}

void mostrarMaximo(int *apuntador, int dimension)
{
    int posicionDelNumeroMaximo=0, numeroMaximoEncontrado = 0, posMayor;
    do
    {
        if(numeroMaximoEncontrado < apuntador[posicionDelNumeroMaximo] )
        {
            numeroMaximoEncontrado = apuntador[posicionDelNumeroMaximo];
            posMayor = posicionDelNumeroMaximo;
        }
        posicionDelNumeroMaximo++;
    }
    while(posicionDelNumeroMaximo<dimension);
    cout<<"\nEl mayor elemento es: "<<numeroMaximoEncontrado<<" en la posicion "<<(posMayor + 1)<<" y esta en la direccion "<<&apuntador[posMayor]<<endl;
}

void mostrarMinimo(int *apuntador, int dimension)
{
    int posicionDelNumero=0, numMin = 200, posicionNumeroMenor=0;
    do
    {
        if(numMin > apuntador[posicionDelNumero] )
        {
            numMin = apuntador[posicionDelNumero];
            posicionNumeroMenor =posicionDelNumero;
        }
        posicionDelNumero++;
    }
    while(posicionDelNumero<dimension);
    cout<<"El menor elemento es: "<<numMin<<" en la posicion "<<(posicionNumeroMenor+1)<<" y esta en la direccion "<<&apuntador[posicionNumeroMenor]<<endl;
}

