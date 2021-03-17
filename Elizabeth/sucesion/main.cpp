#include <iostream>
using namespace std;
int generarArreglo(int [], int);
void imprimirArreglo(int [], int);
int main()
{
    int numeroIngresado = 0, arregloSucesion [100];

    do
    {
        cout<<"Escriba el tamano del arreglo ";
        cin>>numeroIngresado;

    }
    while(numeroIngresado>=100 || numeroIngresado<=0);
    int sumaRealizada =  generarArreglo(arregloSucesion, numeroIngresado);
    cout<<"Suma = "<<sumaRealizada<<endl;
    imprimirArreglo(arregloSucesion, numeroIngresado);
    return 0;
}
int generarArreglo(int sucesion[], int dimension)
{
    int numeroBase = 1, suma=0;
    sucesion[0]=numeroBase;
    suma += sucesion[0];
    for(int i=1; i<dimension; i++)
    {

        sucesion[i] = sucesion[i-1]*2+(1);
        suma +=sucesion[i];
    }

    return suma;

}
void imprimirArreglo(int sucesion[], int dimension)
{

    for(int i=0; i<dimension; i++)
    {
        cout<<sucesion[i]<<endl;

    }

}
