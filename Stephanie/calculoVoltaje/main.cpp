#include <iostream>

using namespace std;
float CalcularPromedioVoltaje();
int main()
{

    if(CalcularPromedioVoltaje()<220)
    {
        cout<<"VOLTAJE CORRECTO"<<endl;
    }
    else
    {
        cout<<"ALTO VOLTAJE"<<endl;
    }
    return 0;
}

float CalcularPromedioVoltaje()
{
    float promedio = 0, voltaje, suma;

    cout<<"Ingrlese los Cinco voltajes"<<endl;
    int i = 0;
    for(int i = 0; i<5; i++)
    {
        cin>>voltaje;
        suma += voltaje;
    }
     promedio =suma/5;
    return promedio;
}
