#include <iostream>

using namespace std;

void potencia(int );
int main()
{
    int Numero = 0;

    cout<<"Ingrese el numero del cual quiera su potencia"<<endl;
    cin>>Numero;

    potencia(Numero);
    return 0;
}

void potencia(int numeroSeleccionado)
{

    int Potencia = 2, NumeroGuardado = 0;
    NumeroGuardado = numeroSeleccionado;

    for(int i = 0; i < Potencia; i ++)
    {
        numeroSeleccionado *= NumeroGuardado;
    }

    cout<<"La potencia del numero "<<NumeroGuardado<<" es: "<<numeroSeleccionado<<endl;
}
