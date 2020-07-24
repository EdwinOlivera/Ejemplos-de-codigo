#include<iostream>
#include <random>
#include <math.h>
#include <iomanip>
#include <cstdlib>

using namespace std;

int Aleatorio();
long double sumatoria(double, int );
unsigned long long factorial(int );

int main()
{
    double x=0;
    int opc=0;
    int valor=0;
    cout << "1. Aleatorio"<<endl
         << "2. Determinista"<<endl;
    while( opc < 1 || opc > 2 )
    {
        cin>>opc;
    }
    if( opc == 1)
    {
        valor=Aleatorio();
    }
    else
    {
        cin>>valor;
    }

    cin>>x;
    cout<<setprecision(16)<<sumatoria(x,valor);
    return 0;
}

int Aleatorio(void)
{
    srand(time(NULL));
    return 5+rand()%11;
}

long double sumatoria(double x, int v)
{

    long double suma = 0;
    for(int i = 0; i<v; i++)
    {
         suma += (pow(x,i)/factorial(i));
    }
    return suma;

}

unsigned long long factorial(int n)
{
    if(n < 0)
        return 0;
    else if(n > 1)
        return n*factorial(n-1);
    return 1;
}
