#include <iostream>

using namespace std;

int main()
{
    int NumeroABuscar, numeroEncotrado, posicion=-1;
    int ArregloDeNumero[]= {1,2,3,5,4,89,6,1,3};

    cout<<"Ingrese el numero que desea buscar"<<endl;
    cin>>NumeroABuscar;

    for(int i=0; i < 9; i++)
    {
        if(NumeroABuscar == ArregloDeNumero[i])
        {
            numeroEncotrado = ArregloDeNumero[i];
            posicion = i+1;
            cout<<"El numero "<< NumeroABuscar<<" si se encuntra en el arreglo"<<endl;
            cout<<"Y esta en la posicion "<< posicion<<endl;
            break;
        }
    }
    if(posicion==-1){
        cout<<"No se encuentra el numero en el arreglo"<<endl;
    }
    return 0;
}
