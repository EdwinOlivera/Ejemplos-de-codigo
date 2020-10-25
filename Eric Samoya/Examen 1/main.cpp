#include<iostream>
#include <math.h>
using namespace std;

float poblacion(int t);
int main()
{
    int Tie=0, yearA, yearB;

    cin>> yearA;
    cin >>yearB;
    if(yearA<2000 ||yearB<yearA )
    {
        cout<<"Datos invalidos"<<endl;
    }
    else
    {
        do
        {
            cout<<"Year:"<<yearA<<" - Poblacion(en miles de millones): "<<poblacion(Tie)<<endl;
            yearA++;
            Tie++;
        }
        while(yearA<=yearB);
    }

    return 0;

}
float poblacion(int t)
{
    double euler = 2.71828182845904523536;
    return 6*pow(euler,0.02*t );

}

