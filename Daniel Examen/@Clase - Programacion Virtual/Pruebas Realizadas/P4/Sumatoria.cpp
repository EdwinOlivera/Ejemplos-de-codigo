#include<iostream>
#include <random>
#include <math.h>
#include <iomanip>
#include <cstdlib>

using namespace std;

int Aleatorio( );
long double sumatoria(double, int );
unsigned long long factorial(int );

int main()
{
    double x=0;
    int opc=0;
    int valor=0;
    std::cout << "1. Aleatorio" << std::endl
              << "2. Determinista" << std::endl;
    while( opc < 1 || opc > 2 )
    {
        std::cin>>opc;
    }
    if( opc == 1)
    {
        valor=Aleatorio();
    }
    else
    {
        std::cin>>valor;
    }
    std::cin>>x;
    std::cout<<std::setprecision(16)<<sumatoria(x,valor);
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
    for(int i = 0; i<=v; i++)
    {
        suma += (pow(x-i,2)+(2*i))/factorial(i);
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
