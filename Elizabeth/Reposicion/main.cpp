#include <iostream>
#include <cmath>
bool primo(int n);
bool Cuadrado(int n, int &c);
void Separacion(int n, int &p, int& c);
using namespace std;
int main()
{
    int numeroIngresado=10, numeroPrimo = 0, numeroC=0;
    do
    {

        cin>>numeroIngresado;

    }
    while(numeroIngresado<0);
    for(int i=0; i<=numeroIngresado+1; i++)
    {

        for(int j = 0; j<=i; j++)
        {
            if(primo(j))
            {
                numeroPrimo = j;
                numeroC++;
                Separacion(i, numeroPrimo,  numeroC );

            }

        }

        numeroC = 0;

    }


    return 0;
}

bool primo(int n)
{
    bool prim = true;

    if (n == 0 || n == 1 || n == 4)
        prim =  false;
    for (int x = 2; x < n/ 2; x++)
    {
        if (n % x == 0)
            prim =  false;
    }

    return prim;
}

void Separacion(int n, int &p, int &c)
{
    int potencia = pow(c,2);
    int multiplicacion = potencia *2;
    if(n == (p + multiplicacion ))
    {
        cout<<n <<" -> ("<<p<<","<<c<<")"<<endl;
    }
    else
    {
        p = 0;
        c = 0;
    }



}
