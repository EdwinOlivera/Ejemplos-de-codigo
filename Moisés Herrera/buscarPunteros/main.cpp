
#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void generarAleatoriamenteArreglo(int *, int );
void mostrarArregloGenerado(int *, int );
void buscarPosiciones(int *, int, int elemento );

int main()
{
    srand(time(NULL));


    int elemento = 0;
    int dimension = 0;


    cout<<"Ingrese la dimension del arreglo: ";
    cin>>dimension;
    int arregloDeNumeros[dimension];

    int* apunArreglo = NULL;
    apunArreglo = &arregloDeNumeros[0];

    generarAleatoriamenteArreglo(apunArreglo, dimension);
    cout<<"Ingrese el elemento que desea Buscar:";
    cin>>elemento;
    cout<<"El arreglo generado es: \n";
    mostrarArregloGenerado(apunArreglo, dimension);
    buscarPosiciones(apunArreglo, dimension, elemento);
    return 0;
}




void generarAleatoriamenteArreglo(int *apuntador, int dimension)
{

    int numeroAIngresar=1+rand()%(49), posicionDelNumero=0;
    do
    {
        apuntador[posicionDelNumero] = numeroAIngresar;
        posicionDelNumero++;
        numeroAIngresar=1+rand()%(49);
    }
    while(posicionDelNumero<dimension);
}
void mostrarArregloGenerado(int *apuntador, int dimension)
{

    int posicionDelNumero=0;
    do
    {
        cout<<apuntador[posicionDelNumero]<<' ';
        posicionDelNumero++;
    }
    while(posicionDelNumero<dimension);
    cout<<endl;
}

void buscarPosiciones(int *apuntador, int dimension, int elemento)
{
    int posicionElemento=0, numeroMaximoEncontrado = 0, posMayor;
    bool numeroEncontrado = false;
    do
    {
        if(elemento == apuntador[posicionElemento] )
        {

            cout<<"El elemento "<<elemento<<" esta en la posicion "<<(posicionElemento + 1)<<" en la direccion"<<&apuntador[posicionElemento]<<endl;
            numeroEncontrado = true;

        }
        posicionElemento++;
    }
    while(posicionElemento<dimension);
    if(numeroEncontrado == false)
    {
        cout<<"No se encontro el elemento en el arreglo."<<endl;
    }
}



