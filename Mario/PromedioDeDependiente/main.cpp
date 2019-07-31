#include <iostream>

using namespace std;

int main()
{
    //Creacion de las variables
    float TotalA=0, TotalB=0, TotalC=0, PromeA=0, PromeB=0, PromeC=0, CantArt=0, ValorArt=0, VentasA=0, VentasB=0, VentasC=0;
    int NumeroDeVenta, turnoDependiente=1;
//Procesos del Programa
    do
    {
        switch(turnoDependiente)
        {
        case 1:
            cout<<"Se registrara las ventas del Dependiente A"<<endl;
            cout<<"Cuantos articulos Vendio?"<<endl;
            cin>>NumeroDeVenta;

            for(int i=0; i<NumeroDeVenta; i++)
            {
                cout<<"Cantidad vendidas del Articulo #"<<(i+1)<<"?"<<endl;
                cin>>CantArt;
                VentasA += CantArt;
                cout<<"Cual es el valor del Articulo actual?"<<endl;
                cin>>ValorArt;
                TotalA += (ValorArt*CantArt);
            }
                PromeA = (TotalA/VentasA);
            break;

        case 2:
            cout<<"Se registrara las ventas del Dependiente B"<<endl;
            cout<<"Cuantos articulos Vendio?"<<endl;
            cin>>NumeroDeVenta;

            for(int i=0; i<NumeroDeVenta; i++)
            {
                cout<<"Cantidad vendidas del Articulo #"<<(i+1)<<"?"<<endl;
                cin>>CantArt;
                VentasB += CantArt;
                cout<<"Cual es el valor del Articulo actual?"<<endl;
                cin>>ValorArt;
                TotalB += (ValorArt*CantArt);
            }
                PromeB = (TotalB/VentasB);
            break;
        case 3:
            cout<<"Se registrara las ventas del Dependiente C"<<endl;
            cout<<"Cuantos articulos Vendio?"<<endl;
            cin>>NumeroDeVenta;
            for(int i=0; i<NumeroDeVenta; i++)
            {
                cout<<"Cantidad vendidas del Articulo # "<<(i+1)<<"?"<<endl;
                cin>>CantArt;
                VentasC += CantArt;
                cout<<"Cual es el valor del Articulo actual?"<<endl;
                cin>>ValorArt;
                TotalC += (ValorArt*CantArt);

            }
                PromeC = (TotalC/VentasC);
            break;
        }
        turnoDependiente++;
    }
    while(turnoDependiente<=3);
    cout<<"Fin de la facturacion. Dependiente F: 000000000"<<endl;

    cout<<"Total vendido por A: "<<TotalA<<"El promedio vendido de A es: "<<PromeA<<endl;
    cout<<"Total vendido por B: "<<TotalB<<"El promedio vendido de B es: "<<PromeB<<endl;
    cout<<"Total vendido por C: "<<TotalC<<"El promedio vendido de C es: "<<PromeC<<endl;
    return 0;
}
