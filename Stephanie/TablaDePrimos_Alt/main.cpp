#include <iostream>
#include <iomanip>
using namespace std;
bool comprobarNumero(int numero);
int main()
{
    int cantidadDePrimos = 0, numFila = 0, numColumna = 0, numero = 0;
    int arregloPrimos[10][10];
    bool esPrimo;
    do
    {

        if(comprobarNumero(numero))
        {

            if(numColumna == 10)
            {
                numColumna = 0;
                numFila++;
            }
            arregloPrimos[numFila][numColumna] = numero;
            cantidadDePrimos++;
            numColumna++;
        }
        numero++;
    }
    while(cantidadDePrimos<100);

    cout<<"Tabla de los numeros primos encontrados: "<<endl;

    cout<<endl;
    for(int i =0; i<10; i++)
    {
        cout<<"["<<i<<"]";
        for(int j = 0; j<10; j++)
        {

            cout<<setw(6)<<arregloPrimos[i][j];
        }
        cout<<endl;
    }
    return 0;
}

bool comprobarNumero(int numeroAComprobar)
{

    if (numeroAComprobar == 0 || numeroAComprobar == 1 || numeroAComprobar == 4)
        return false;
    for (int i = 2; i < numeroAComprobar / 2; i++)
    {
        if (numeroAComprobar % i == 0)
            return false;
    }

    return true;
}
