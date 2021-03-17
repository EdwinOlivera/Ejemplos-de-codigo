#include <iostream>
#include <iomanip>
using namespace std;
bool determinarPrimo(int numero);
int main()
{
    int cantPrimos = 0, numFila = 0, numColumna=0, numero = 0;
    int arregloPrimos[10][10];
    do
    {
        if(determinarPrimo(numero))
        {
            cantPrimos++;
            numFila++;
            if(numFila==10)
            {
                numFila = 0;
                numColumna++;
            }
            arregloPrimos[numFila][numColumna]=numero;
        }
        numero++;
    }
    while(cantPrimos<100);

    cout<<"Tabla de los numeros primos: "<<endl;

    for(int i =0; i<10; i++)
    {

        for(int j = 0; j<10; j++)
        {
            cout<<setw(5)<<arregloPrimos[i][j];
        }
        cout<<endl;

    }
    return 0;
}

bool determinarPrimo(int numero)
{

    if (numero == 0 || numero == 1 || numero == 4)
        return false;
    for (int x = 2; x < numero / 2; x++)
    {
        if (numero % x == 0)
            return false;
    }

    return true;
}
