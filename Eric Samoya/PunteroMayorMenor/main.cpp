#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void llenarArregloAleatoreamente(int *, int );
void imprimirTodo(int *, int );
void imprimirMaximo(int *, int );
void imprimirMinimo(int *, int );

int main()
{

    int dimensionDelArreglo;
    int *apuntadorArreglo;

    cout<<"Ingrese la dimension del arreglo ";
    cin>>dimensionDelArreglo;
    int arregloNumero[dimensionDelArreglo];
    apuntadorArreglo  = &arregloNumero[0];
    llenarArregloAleatoreamente(apuntadorArreglo, dimensionDelArreglo);

    imprimirTodo(apuntadorArreglo, dimensionDelArreglo);
    imprimirMinimo(apuntadorArreglo, dimensionDelArreglo);
    imprimirMaximo(apuntadorArreglo, dimensionDelArreglo);
    return 0;
}
void llenarArregloAleatoreamente(int *apuntadorArreglo, int dimensionDelArreglo)
{
    srand(time(NULL));
    int numeroAIngresar=1+rand()%(199), posicionNum=0;
    do
    {
        apuntadorArreglo[posicionNum] = numeroAIngresar;
        posicionNum++;
        numeroAIngresar=1+rand()%(199);
    }
    while(posicionNum<dimensionDelArreglo);
}
void imprimirTodo(int *apuntadorArreglo, int dimensionDelArreglo)
{
    int posicionNum=0;
    do
    {
        cout<<apuntadorArreglo[posicionNum]<<' ';
        posicionNum++;
    }
    while(posicionNum<dimensionDelArreglo);
    cout<<endl;
}

void imprimirMaximo(int *apuntadorArreglo, int dimensionDelArreglo)
{
    int posicionNum=0, numMax = 0, posMayor;
    do
    {
        if(apuntadorArreglo[posicionNum] > numMax)
        {
            numMax = apuntadorArreglo[posicionNum];
            posMayor =posicionNum;
        }
        posicionNum++;
    }
    while(posicionNum<dimensionDelArreglo);
    cout<<"\nEl mayor elemento es: "<<numMax<<" en la posicion "<<posMayor<<" y esta en la direccion "<<&apuntadorArreglo[posMayor]<<endl;
}

void imprimirMinimo(int *apuntadorArreglo, int dimensionDelArreglo)
{
   int posicionNum=0, numMin = 200, posMenor;
    do
    {
        if(apuntadorArreglo[posicionNum] < numMin)
        {
            numMin = apuntadorArreglo[posicionNum];
            posMenor =posicionNum;
        }
        posicionNum++;
    }
    while(posicionNum<dimensionDelArreglo);
    cout<<"\nEl menor elemento es: "<<numMin<<" en la posicion "<<posMenor<<" y esta en la direccion "<<&apuntadorArreglo[posMenor]<<endl;
}

