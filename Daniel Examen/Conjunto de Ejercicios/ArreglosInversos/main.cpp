#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;

int main()
{
    srand(time(NULL));
    int ArregloPrincipal[100], tamanioArreglo = 0, arregloInverso[100], RecorridoInverso = 0;
    cout<<"Ingrese el tamanio del Arreglo -> ";
    cin>>tamanioArreglo;
    RecorridoInverso  = tamanioArreglo;

    for(int i = 0; i<tamanioArreglo; i++){
        ArregloPrincipal[i] =  rand()%10;
    }

    for(int i = 0; i<tamanioArreglo; i++){
        arregloInverso[i] = ArregloPrincipal[RecorridoInverso-1];
        RecorridoInverso--;
    }

    cout<<"\nLos arreglos creados son "<<endl;

    cout<<"Arreglo en orden original [ ";
    for(int i = 0; i < tamanioArreglo; i++){
        cout<<ArregloPrincipal[i]<<" ";
    }
        cout<<"]";

            cout<<"\nArreglo en orden Inverso  [ ";
    for(int i = 0; i < tamanioArreglo; i++){
        cout<<arregloInverso[i]<<" ";
    }
        cout<<"]\n";
    return 0;
}
