#include <iostream>

using namespace std;
int DeterminarMayorElemento(int [], int);
int FrecuenciaMayor(int [], int, int);
void PosicionesDeFrecuencia(int [], int [], int, int);

int main()
{
    int ArregloPrincipal[100], Posiciones[100], frecuenciaMayorElemento = 0, MayorElemento = 0;
    int dimencionArreglo = 0;

    cout<<"Ingrese la dimencion N del arreglo"<<endl;
    cin>>dimencionArreglo;
    cout<<endl;
    for(int elementoActual = 0; elementoActual<dimencionArreglo; elementoActual++)
    {
        cout<<"Ingrese el elemento "<<(elementoActual+1)<<" del arreglo"<<endl;
        cout<<"-->";
        cin>>ArregloPrincipal[elementoActual];
    }


    MayorElemento = DeterminarMayorElemento(ArregloPrincipal,dimencionArreglo);
    cout<<"\nEl elemento mayor es: "<<MayorElemento<<endl;

    frecuenciaMayorElemento = FrecuenciaMayor(ArregloPrincipal,dimencionArreglo, MayorElemento);
    cout<<"\nCantidad de veces que aparece el mayor elemento es: "<<frecuenciaMayorElemento<<endl;

    PosicionesDeFrecuencia(ArregloPrincipal, Posiciones, dimencionArreglo, MayorElemento);

    cout<<"\nLas posiciones en las que se encuentra el elemento mayor son: "<<endl;
    for(int i = 0; i<frecuenciaMayorElemento; i++)
    {
        cout<<"Posicion "<<Posiciones[i]<<endl;
    }
    return 0;
}

void PosicionesDeFrecuencia(int ArregloPrincipal[],int PosicionesElemento[], int Dimencion, int mayorElemento)
{
    int PosicionEncontrado = 0;
    for(int i =0; i< Dimencion; i++)
    {
        if(ArregloPrincipal[i] == mayorElemento)
        {
            PosicionesElemento[PosicionEncontrado]= i+1;
            PosicionEncontrado++;
        }
    }

}
int FrecuenciaMayor(int ArregloPrincipal[], int Dimencion, int mayorElemento)
{

    int Cantidad = 0;

    for(int i = 0; i<Dimencion; i++)
    {
        if(ArregloPrincipal[i] == mayorElemento)
        {
            Cantidad++;
        }
    }

    return Cantidad;
}


int DeterminarMayorElemento(int ArregloPrincipal[], int Dimencion)
{
    int numeroSeleccionado = 0, NumeroAEvaluar = 0;
    numeroSeleccionado = ArregloPrincipal[0];
    for(int i = 0; i<Dimencion; i++)
    {
        if(ArregloPrincipal[i] >= numeroSeleccionado)
        {
            numeroSeleccionado =  ArregloPrincipal[i];
        }
    }

    return numeroSeleccionado;
}
