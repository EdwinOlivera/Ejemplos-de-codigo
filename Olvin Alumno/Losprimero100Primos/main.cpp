#include <iostream>

using namespace std;

int main()
{
    int NumeroPrimo[10][10];
    int NumeroActual=0, comprobarNumero, columna=0, fila=0, NumerosEncontrados=0;

    cout<<"Se esta realizando la busqueda de los primero 100 numeros primos"<<endl;
    do
    {
        do
        {
            do
            {

                columna += 1;
                NumeroActual +=1;
                comprobarNumero = NumeroActual % 2;
                cout<<"|";
                cout<<NumeroActual<<", ";
                if(comprobarNumero !=0)
                {
                    NumeroPrimo[fila][columna]=NumeroActual;
                    cout<<"Numero primo almacenado ";
                    NumerosEncontrados +=1;
                    cout<<NumerosEncontrados<<"**";
                    cout<<"Se ha encontrado un numero impar"<<endl;
                }

            }
            while(columna< 9);
            columna = 0;
            fila += 1;
            NumeroActual +=1;
            cout<<"|";
            cout<<NumeroActual<<", "<<endl;
        }
        while(fila<10);
    }
    while(NumerosEncontrados!=100);
    cout<<"Imprimir los numeros guardados"<<endl;
    NumeroActual=0;
    for(int i=0; i<10; i++){
        cout<<"|| ";
     for(int j=0; j<10; j++){
            cout<<NumeroPrimo[i][j];

    }
    }

    cout << "Hello world!" << endl;
    return 0;
}
