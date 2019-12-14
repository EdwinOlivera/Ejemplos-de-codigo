#include <iostream>

using namespace std;

int main()
{
    int NumeroPrimo[10][10];
    int NumeroActual=0, comprobarNumero, columna=0, fila=0, NumerosEncontrados=0, In=0, Jn=0;

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
                if(comprobarNumero !=0)
                {
                    NumeroPrimo[Jn][In] = NumeroActual;
                    cout<<"Numero primo encontrado **"<<endl;
                    NumerosEncontrados +=1;

                    In +=1;
                    if(In >= 10)
                    {
                        Jn +=1;
                        In =0;
                    }
                }

            }
            while(columna< 9);
            columna = 0;
            fila += 1;
            NumeroActual +=1;

        }
        while(fila<10);
    }
    while(NumerosEncontrados!=100);
    cout<<"\nSe va a Imprimir los PRIMEROS 100 numeros PRIMOS guardados"<<endl;

    for(int i=0; i<10; i++)
    {

        for(int j=0; j<10; j++)
        {
            cout<<" | ";
            cout<<NumeroPrimo[i][j];

        }
        cout<<"| "<<endl;
    }

    cout << "Hello world!" << endl;
    return 0;
}
