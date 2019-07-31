#include <iostream>

using namespace std;

int main()
{
    int NumeroDeAnios = 1;
    int PoblacionA=0, PoblacionB=0; //Poblaciones establecidas
    string NombreCiudadA="\"La Ciudad A\"", NombreCiudadB="\"La Ciudad B\"",Opcion ="n"; //Los nombres de las ciudades
    float PorceCrecimA, PorceCrecimB, ActualCreciA, ActualCreciB; //Variables para el crecimiento de la poblacion

    cout<<"Calculo de poblacion de ciudades\n"<<endl;
    cout<<"Acontinuacion se le va a pedir que ingrese los datos necesarios para calcular las poblaciones en años\n"<<endl;
    cout<<"desea ponerle nombre a las CIUDADES?\n S = SI\n Cualquier otra letra = NO\n"<<endl;
    //cin>>Opcion;
    Opcion = tolower(Opcion[0]);//Hace que cualquier letra se haga pequeña (minuscula)
    if(Opcion == "s")
    {
        cout<<"Se pedira los nombres de las ciudades\n";
        cout<<"Ingrese el nombre de la ciudad A\n";
        cin>>NombreCiudadA;
        cout<<"\nIngrese el nombre de la ciudad B\n";
        cin>>NombreCiudadB;
    }
    cout<<"Acontinuacion se pedira la poblaciones de las ciudases(Poblaciones inicales)"<<endl;
    cout<<"NOTA IMPORTANTE: Escriba el numero entero, y ese sera el porcentaje de Tasa\n";
    cout<<"\nIngrese la poblacion de: "<< NombreCiudadA<<endl;
    cin>>PoblacionA;

    do
    {
        cout<<"\nIngrese la poblacion de: "<< NombreCiudadB<<endl;
        cin>>PoblacionB;

        if(PoblacionB<=PoblacionA)
        {
            PoblacionB=0;
            cout<<"Ha ingresado una poblacion menor o igual a la de-> "<<NombreCiudadA<<"\nIngrese de nuevo la poblacion de-> "<<NombreCiudadB<<endl;
        }
    }
    while(PoblacionB<=PoblacionA);

    cout<<"Acontinuacion se pedira la Tasa de crecimiento poblacional de las ciudades(Porcentaje anual)"<<endl;
    cout<<"\n*****NOTA IMPORTANTE: Ingrese la cantidad en numeros enteros, y eso sera el porcentaje de crecimiento*****\n";
    cout<<"\nIngrese la Tasa de crecimiento poblacional de: "<< NombreCiudadA<<endl;
    cin>>PorceCrecimA;
    PorceCrecimA = PorceCrecimA/100;
    do
    {
        cout<<"\nIngrese la Tasa de crecimiento poblacional de: "<< NombreCiudadB<<endl;
        cin>>PorceCrecimB;
        PorceCrecimB = PorceCrecimB/100;
        if(PorceCrecimB>=PorceCrecimA)
        {
            PorceCrecimB=PorceCrecimA+1;
            cout<<"Ha ingresado una Tasa de crecimiento poblacional mayor o igual a la de-> "<<NombreCiudadA<<"\nIngrese de nuevo la Tasa de crecimiento poblacional de-> "<<NombreCiudadB<<endl;
        }
    }
    while(PorceCrecimB>=PorceCrecimA);

    cout<<"Cuantos años quiere evaluar el crecimiento de las poblaciones?"<<endl;
    cin>>NumeroDeAnios;
    for(int i=0; i<NumeroDeAnios; i++){
        //Haciendo el crecimiento de la poblacion anualmente
        ActualCreciA = PoblacionA * PorceCrecimA;
        PoblacionA += ActualCreciA;
        ActualCreciB = PoblacionB * PorceCrecimB;
        PoblacionB += ActualCreciB;

        if(PoblacionA==PoblacionB){
            cout<<"\nLas ciudades alcanzaron igual poblacion en el año "<<i+1<<endl;
            cout<<"\n"<<NombreCiudadA<<", Tiene una poblacion de->"<< PoblacionA<<"\n Con una tasa de crecimiento de-> "<<PorceCrecimA<<" anualmente\n";
            cout<<"\n"<<NombreCiudadB<<", Tiene una poblacion de->"<< PoblacionB<<"\n Con una tasa de crecimiento de-> "<<PorceCrecimB<<" anualmente\n";
        }
        if(i==NumeroDeAnios-1 && (PoblacionA < PoblacionB)){
            cout<<"\nEn este periodo de tiempo, la ciudad "<<NombreCiudadA<<" no logra alcanzar en poblacion a la ciudad "<<NombreCiudadB<<endl;
        }
    }

    cout<<"\nal final del periodo de avaluacion, las ciudades quedaron la siguiente cantidad poblacional"<<endl;
    cout<<NombreCiudadA<<", tiene una poblacion de->"<< PoblacionA<<"\n Con una tasa de crecimiento de-> "<<PorceCrecimA<<" anualmente\n";
    cout<<NombreCiudadB<<", tiene una poblacion de->"<< PoblacionB<<"\n Con una tasa de crecimiento de-> "<<PorceCrecimB<<" anualmente\n";
    cout << "\nFin del programa" << endl;
    return 0;
}
