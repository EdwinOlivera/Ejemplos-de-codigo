#include<iostream>
#include<ctime>
using namespace std;
void LlenarArreglo(int *prt, int dim);
void ImprimirArreglo(int *prt, int dim);
void Suma(int *ptrA, int *ptrB, int dim);

int main()
{
    srand(time(0));
    int dim = 0;
    cout<<"Ingrese la dimension de los arreglos: ";
    cin>>dim;
    int primerArreglo[dim];
    int segundoArreglo[dim];

    int* ptPrimerArreglo = NULL;
    ptPrimerArreglo = &primerArreglo[0];

    int* ptSegundoArreglo = NULL;
    ptSegundoArreglo = &segundoArreglo[0];

    LlenarArreglo(ptPrimerArreglo, dim);
    LlenarArreglo(segundoArreglo, dim);

    cout<<"El primer arreglo es\n";

    ImprimirArreglo(ptPrimerArreglo, dim);
    cout<<"El segundo arreglo es\n";

    ImprimirArreglo(ptSegundoArreglo, dim);
    cout<<"La suma de los dos arreglos es\n";

    Suma(ptPrimerArreglo, ptSegundoArreglo,  dim);

    return 0;
}




void LlenarArreglo(int *prt, int dimension)
{

    int numeroAIngresar=0, x=0;
    do
    {
        numeroAIngresar=1+rand()%(29);

        prt[x] = numeroAIngresar;
        x++;
    }
    while(x<dimension);
}
void ImprimirArreglo(int *prt, int dim)
{

    int x=0;
    do
    {
        cout<<prt[x]<<' ';
        x++;
    }
    while(x<dim);
    cout<<endl;
}

void Suma(int *ptrA, int *ptrB, int dim)
{
    int x=0;
    do
    {
        cout<<(ptrA[x] + ptrB[x])<<' ';
        x++;
    }
    while(x<dim);

}




