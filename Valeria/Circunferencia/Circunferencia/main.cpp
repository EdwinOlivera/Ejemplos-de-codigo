#include <iostream>
#include<cmath>
using namespace std;

int main()
{

    double numeroIngresadoX, numeroIngresadoY, RadioIngresado, numeroX, numeroY, hipotenusaPrimera, hipotenusaSegunda,  numeroRestadosX, numeroRestadosY;
    int CantidadDeCalculosHechos = 0, CantidadAciertos = 0;
    double porcentajeAcierto;
    cout<<"Ingrese el par (X, Y)"<<endl;
    cout<<"X -> ";
    cin>>numeroIngresadoX;
    cout<<"Y -> ";
    cin>>numeroIngresadoY;
    cout<<"Los valores ingresado son ->  ("<<numeroIngresadoX<<", "<<numeroIngresadoY<<")"<<endl;

    while(RadioIngresado != 0 )
    {
        cout<<"Ingresa un nuevo Par ordenado de (X, Y) y su respectivo Radio (r)"<<endl;
        cout<<"X -> ";
        cin>>numeroX;
        cout<<"Y -> ";
        cin>>numeroY;
        cout<<"Ingrese el Radio en donde estara centrado"<<endl;
        cout<<"r -> ";
        cin>> RadioIngresado;


        CantidadDeCalculosHechos = CantidadDeCalculosHechos + 1;
        hipotenusaPrimera = RadioIngresado * RadioIngresado;
        numeroRestadosX = numeroIngresadoX - numeroX;
        numeroRestadosY = numeroIngresadoY - numeroY;
        hipotenusaSegunda = sqrt((numeroRestadosX * numeroRestadosX) + (numeroRestadosY * numeroRestadosY));

        if( hipotenusaSegunda < hipotenusaPrimera)
        {
            hipotenusaPrimera = hipotenusaPrimera + 1;
        }
    }
    porcentajeAcierto = hipotenusaPrimera / CantidadDeCalculosHechos;
    if(porcentajeAcierto >= 0.6)
    {
        cout<<"SI esta contenido en la mayoria de los circulos proporcionados";
    }
    else
    {
        cout<<"NO esta contenido en la mayoria de los circulos proporcionados";
    }

    return 0;
}
