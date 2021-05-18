#include <iostream>
#include <math.h>

using namespace std;

bool primo(int n);
int numeroMersenne(int n);

int main()
{
    int n ;
    cout<<"----------- MM314 - Progrmacion 1 -----------"<<endl;
    cout<<"Favor, ingrese el n-esimo valor n: ";
    cin>>n;
    int numerM = numeroMersenne(n);
    cout<<"Mn= "<<numerM<<endl;
    if(primo(numerM))
    {
        cout<<"R= 1"<<endl;

    }
    else
    {
        cout<<"R= 0"<<endl;
    }
    return 0;
}

int numeroMersenne(int n)
{
    int numeroEncontrado = 2;
    numeroEncontrado  = pow(2,n) - 1;

    return numeroEncontrado;
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
