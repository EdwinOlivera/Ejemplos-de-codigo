#include <iostream>
#include <cmath>
using namespace std;
int Factorial_n(int n);
float   Exponencial_x(float x, int n);
int main()
{
    int n, x;
    cout<<"Ingrese X"<<endl;
    cin>>x;
    cout<<"Ingrese el grado del polinomio"<<endl;
    cin>>n;

    cout<<abs( exp(x) - Exponencial_x(x,n))<<endl;

    return 0;
}

float   Exponencial_x(float x, int n)
{
    float  suma = 0;
    for(int i = 0; i <= n; i++)
    {
        suma += pow(x,i)/Factorial_n(i);

    }
return suma;
}
int Factorial_n(int n)
{
    if(n < 0)
        return 0;
    else if(n > 1)
        return n*Factorial_n(n-1);
    return 1;
}
