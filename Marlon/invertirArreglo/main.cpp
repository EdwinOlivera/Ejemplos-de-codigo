#include <iostream>

using namespace std;
void Leer_Arreglo(double [], int);
void Imprime_Arreglo(double [], int);
void Invertir_Arreglo(double [], int);
int main()
{
    int dimensionDelArreglo=2;

    do
    {
        cout<<"Ingrese el tamanio del arreglo: "<<endl;
        cin>>dimensionDelArreglo;

    }
    while(dimensionDelArreglo>20 || dimensionDelArreglo<2);

    double arregloNormal[dimensionDelArreglo], arregloInverso[dimensionDelArreglo];


    Leer_Arreglo(arregloNormal, dimensionDelArreglo);
    cout<<"El arreglo inicial es:"<<endl;
    Imprime_Arreglo(arregloNormal,dimensionDelArreglo);
cout<<endl;
    Invertir_Arreglo(arregloNormal,dimensionDelArreglo);
    cout<<"\nEl arreglo invertido es:"<<endl;
    Imprime_Arreglo(arregloNormal,dimensionDelArreglo);
    return 0;
}
void Leer_Arreglo(double arregloNormal[], int dimensionDelArreglo)
{

    cout<<"Ingrese los elementos del arreglo"<<endl;
    for(int i = 0; i<dimensionDelArreglo; i++)
    {
        cin>>arregloNormal[i];
    }
}

void Imprime_Arreglo(double arregloNormal[], int dimensionDelArreglo)
{

    for(int i = 0; i<dimensionDelArreglo; i++)
    {
        cout<<arregloNormal[i]<<" ";
    }
}
void Invertir_Arreglo(double arregloNormal[], int dimensionDelArreglo)
{
    double arregloInverso[dimensionDelArreglo];

    for(int i = 0; i<dimensionDelArreglo; i++)
    {
        arregloInverso[i] = arregloNormal[i];
    }

    for(int i = 0; i<dimensionDelArreglo; i++)
    {
        arregloNormal[i] = arregloInverso[dimensionDelArreglo-1-i];
    }
}
