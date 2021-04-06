
#include <iostream>
using namespace std;

void generarArreglo(int *apuntador, int dimension );
void mostrarArreglo(int *apuntador, int dimension );
int sumarArreglo(int *apuntador, int dimension );

int main()
{

    int dimension = 0;
    cout<<"Ingrese la dimension del arreglo: ";
    cin>>dimension;
    int arrNum[dimension];

    int* apArr = NULL;
    apArr = &arrNum[0];
    generarArreglo(apArr, dimension);

    mostrarArreglo(apArr, dimension);

    cout<<"\nLa suma es "<<sumarArreglo(apArr, dimension)<<endl;
    return 0;
}




void generarArreglo(int *apuntador, int dimension)
{

    int numeroAIngresar=1, posicionDelNumero=0;
    do
    {
        apuntador[posicionDelNumero] = numeroAIngresar;
        posicionDelNumero++;
        numeroAIngresar+=2;
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

int sumarArreglo(int *apuntador, int dimension)
{
    int posicionDelNumero=0;
    int suma = 0;
    do
    {
            suma += apuntador[posicionDelNumero];
        posicionDelNumero++;
    }
    while(posicionDelNumero<dimension);

return suma;
}


