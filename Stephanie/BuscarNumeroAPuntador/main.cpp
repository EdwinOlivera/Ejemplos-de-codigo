
#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void arregloGeneradoAletatoriamente(int *, int );

void posicionesElemento(int *, int elemento, int  );

void crearAleatoriamenteArreglo(int *, int );

int main()
{
    srand(time(0));


    int elemento = 0;
    int dimensionArregloNumeros = 0;


    cout<<"Ingrese la dimension del arreglo: ";
    cin>>dimensionArregloNumeros;
    int arregloDeNumeros[dimensionArregloNumeros];

    int* apunArreglo = NULL;
    apunArreglo = &arregloDeNumeros[0];

    crearAleatoriamenteArreglo(apunArreglo, dimensionArregloNumeros);
    cout<<"Ingrese el elemento que desea Buscar:";
    cin>>elemento;
    cout<<"El arreglo generado es: \n";
    arregloGeneradoAletatoriamente(apunArreglo, dimensionArregloNumeros);
    posicionesElemento(apunArreglo, elemento, dimensionArregloNumeros);
    return 0;
}




void crearAleatoriamenteArreglo(int *apuntador, int dimension)
{

    int numeroAIngresar=0, x=0;
    do
    {
        numeroAIngresar=1+rand()%(49);

        apuntador[x] = numeroAIngresar;
        x++;
    }
    while(x<dimension);
}
void arregloGeneradoAletatoriamente(int *apuntador, int dimensionMaximaArrelgo)
{

    int x=0;
    do
    {
        cout<<apuntador[x]<<' ';
        x++;
    }
    while(x<dimensionMaximaArrelgo);
    cout<<endl;
}

void posicionesElemento(int *apuntador,  int elemento, int dimensionMaximaArrelgo)
{
    int posicionElemento=0, posMayor;
    int posicionesEncotradas =0;
    do
    {
        if(elemento == apuntador[posicionElemento] )
        {

            cout<<"El elemento "<<elemento<<" esta en la posicion "<<(posicionElemento + 1)<<" en la direccion "<<&apuntador[posicionElemento]<<endl;
            posicionesEncotradas++;

        }
        posicionElemento++;
    }
    while(posicionElemento<dimensionMaximaArrelgo);
    if(posicionesEncotradas ==0)
    {
        cout<<"No se encontro el elemento >>"<<elemento<<"<< en el arreglo generado."<<endl;
    }
}



