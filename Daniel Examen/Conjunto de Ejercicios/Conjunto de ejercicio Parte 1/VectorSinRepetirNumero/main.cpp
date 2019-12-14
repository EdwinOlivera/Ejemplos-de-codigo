#include <iostream>

using namespace std;

int main()
{
    int VectorPrincipal[20], numeroIngresado = 0, elementoActual = 0;

    for(int i = 0; i<20; i++)
    {
        cout<<"ingrese el elemento ["<<(i+1)<<"] al vector"<<endl;

        do
        {
            cout<<"ingrese un numero entre 50 y 100 (ambos incluido)"<<endl;
            cin>>numeroIngresado;

            if(numeroIngresado <50 || numeroIngresado>100)
            {
                cout<<"Ha ingresado un valor fuera de Rango, intente de nuevo"<<endl;
            }
            VectorPrincipal[i] = numeroIngresado;
            for(int j =0; j<i; j++)
            {
                if(VectorPrincipal[j] == numeroIngresado)
                {
                    cout<<"Ha ingresado un valor repetido al vector. Intente de nuevo"<<endl;
                    numeroIngresado = 0;
                }
            }

        }
        while(numeroIngresado<50 || numeroIngresado>100);

    }

    cout<<"El vector creado es "<<endl;
    cout<<"[ ";
    for(int x = 0; x<20; x++)
    {
        cout<<VectorPrincipal[x]<<" ";
    }
    cout<<" ]"<<endl;
    return 0;
}
