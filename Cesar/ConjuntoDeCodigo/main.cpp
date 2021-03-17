#include <iostream>

using namespace std;
int factorial(int numero);
float coeficiente(int m, int n);
int main()
{
    int  n, x, y;

    cout<<"n= ";
    cin>>n;
    cout<<"x= ";
    cin>>x;
    cout<<"y= ";
    cin>>y;
    float resultado = 0;
    for(int i = 0; i<=n; i++){
resultado +=  coeficiente(n,  i);
    }
cout<<"El resultado es: "<<resultado<<endl;
    return 0;
}
float coeficiente(int m, int n)
{
    float resultado = 0;

    resultado = factorial(m);
    resultado = resultado/(factorial(n) * factorial((m-n)));

    return resultado;
}
int factorial(int numero)
{
    if(numero < 0)
        return 0;
    else if(numero > 1)
        return numero*factorial(numero-1);
    return 1;
}
