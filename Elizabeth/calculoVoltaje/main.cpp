#include <iostream>

using namespace std;



float voltaje();

int main()
{
float promedioCalculado = voltaje();

    if(promedioCalculado>220)
    {
        cout<<"ALTO VOLTAJE"<<endl;
    }
    else
    {
        cout<<"VOLTAJE CORRECTO"<<endl;
    }
    return 0;
}

float voltaje()
{
    float SumaDeVoltajes = 0;
    float PromedioDeVoltaje = 0;

    float voltajeIngesado = 0;
    cout<<"Ingrese los cinco voltajes\n";
    for(int i = 1; i<=5; i++)
    {
        cin>>voltajeIngesado;
        SumaDeVoltajes += voltajeIngesado;
    }
    PromedioDeVoltaje = SumaDeVoltajes/5; 
    return PromedioDeVoltaje;
}
