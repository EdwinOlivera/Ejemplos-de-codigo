#include <iostream>
using namespace std;

void mostrarArrelgo(int numerosDeLaSucesion[], int dimensionDelArreglo);
int crearSucesion( int dimensionDelArreglo, int numerosDeLaSucesion[]);
int main()
{
    int dimensionDelArreglo = 0, numerosDeLaSucesion [100];

    do
    {
        cout<<"Escriba el tamano del arreglo ";
        cin>>dimensionDelArreglo;

    }
    while(dimensionDelArreglo>=100 || dimensionDelArreglo<=0);
    
    cout<<"Suma = "<<crearSucesion(numerosDeLaSucesion, dimensionDelArreglo)<<endl;
    
    mostrarArrelgo(numerosDeLaSucesion, dimensionDelArreglo);
    
    return 0;
}
void mostrarArrelgo(int numerosDeLaSucesion[], int dimensionDelArreglo)
{

    for(int i=0; i<dimensionDelArreglo; i++)
    {
        cout<<numerosDeLaSucesion[i]<<endl;

    }

}

int crearSucesion( int dimensionDelArreglo, int numerosDeLaSucesion[])
{ 
   
    numerosDeLaSucesion[0]=1;
    int suma = numerosDeLaSucesion[0];
    for(int i=1; i<dimensionDelArreglo; i++)
    {
        numerosDeLaSucesion[i] = numerosDeLaSucesion[i-1]*2+(1);
        suma +=numerosDeLaSucesion[i];
    }

    return suma;

}

