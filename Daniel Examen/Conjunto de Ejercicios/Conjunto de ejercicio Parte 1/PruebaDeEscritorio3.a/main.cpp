#include <iostream>
#include <cmath>
using namespace std;
float R(float);
float F(float);
float S(float);
float C(float, float);
float Misterio(float, float);
int main()
{
    float suma = 0, n, num, den;
    cin>>n;
    for(float i = 1; i< n; i++)
    {
        num = R(i);
        den = F(i);
        suma = suma + S(i)*C(num, den);
    }
    cout<<suma<<endl;
    return 0;
}
float F(float m)
{
    if(m==1)
    {
        return m;
    }
    else
    {
        return m*F(m-1);
    }
}
float C(float m, float n)
{
    return m/n;
}
float R(float m)
{
    return 2.236;
}
float S(float m)
{
    return (-1)*exp(m+1);
}
float Misterio(float a, float b)
{
    cout<<"El valor de a "<<a<<endl;
    cout<<"El valor de b "<<b<<endl;
    cout<<"El valor de la funcion "<<Misterio(a,b)<<endl;
    if(b==1)
    {
        return a;
    }
    else
    {
        return a + Misterio(a, b-1);
    }
}
