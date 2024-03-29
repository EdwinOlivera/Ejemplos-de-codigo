#include <iostream>

using namespace std;

int main()
{
    int clientN, Base1, Costo1, Base2, Costo2, NumeroDeAutos;
    float BaseTotal, CostoTotal, BaseParcial, CostoParcial, acuCosto, acuBase  ;
    int ClientesAutos[100][1];
    float AutosAlquilados[100][100];
    float temporal;

    cout <<"Ingrese a cuantos clientes se les desea cobarar "<<endl;
    do
    {
        cin>>clientN;
        if(clientN<=0 || clientN>100 )
        {
            cout<<"Ha ingresado: "<<clientN<<"; y es una cantidad no valida. Ingrese de nuevo la cantidad de clientes"<<endl;
        }
    }
    while(clientN<=0 || clientN>100);
    cout<<"Ingresara los costo que tendran los clientes en las siguientes  areas"<<endl;

    cout<<"Costo por alquiler de auto (B1)"<<endl;
    do
    {
        cin>>Base1;
        if(Base1<=0)
        {
            cout<<"Ha ingresado como costo B1: "<<Base1<<"; y es una cantidad no validad. Ingrese de nuevo el costo B1"<<endl;
        }
    }
    while(Base1<=0);

    cout<<"Costo por kilometraje por cada auto (C1)"<<endl;
    do
    {
        cin>>Costo1;
        if(Costo1<=0)
        {
            cout<<"Ha ingresado como costo C1: "<<Costo1<<"; y es una cantidad no validad. Ingrese de nuevo el costo C1"<<endl;
        }

    }
    while(Costo1<=0);

    cout<<"En caso que el kilometraje sea mayor a 100km, se cobrara las siguientes tarifas"<<endl;
    cout<<"Costo por alquiler de auto (B2)"<<endl;
    do
    {
        cin>>Base2;
        if(Base2<=0)
        {
            cout<<"Ha ingresado como costo B2: "<<Base2<<"; y es una cantidad no validad. Ingrese de nuevo el costo B1"<<endl;
        }
        if(Base2<=Base1)
        {
            cout<<"Ha ingresado una cantidad igual o menor a B1, la cual es: "<<Base2<<"; y la cantidad de B1 es: "<<Base1<<". Ingrese de nuevo la cantidad de B2"<<endl;
        }
    }
    while(Base2<=0 || Base2<=Base1);

    cout<<"Costo por kilometraje recorrido por autor (C2)"<<endl;
    do
    {
        cin>>Costo2;
        if(Costo2<=0)
        {
            cout<<"Ha ingresado como costo C2: "<<Costo2<<"; y es una cantidad no validad. Ingrese de nuevo el costo C2"<<endl;
        }
        if(Costo2<=Costo1)
        {
            cout<<"Ha ingresado una cantidad igual o menor a C1, la cual es: "<<Costo2<<"; y la cantidad de C1 es: "<<Costo1<<". Ingrese de nuevo la cantidad de C2"<<endl;
        }
    }
    while(Costo2<=0 || Costo2<=Costo1);


    for(int i=0; i< clientN; i++)
    {
        cout<<"Datos del cliente numero: " <<i+1<<endl;
        cout<<"¿Cuantos autos alquilo este cliente?"<<endl;
        cin>>NumeroDeAutos;
        ClientesAutos[i][0] = NumeroDeAutos;
        for(int j=0; j<NumeroDeAutos; j++)
        {
            cout<<"Ingrese los datos del auto numero: "<<j+1<<endl;
            cout<<"Ingrese el kilometraje de este auto"<<endl;
            do
            {
                cin>>temporal;
                if(temporal<0)
                {
                    cout<<"No tiene sentido la cantidad ingresada. Ingrese un numero positivo"<<endl;
                }
            }
            while(temporal<0);

            AutosAlquilados[i][j]=temporal;
        }
    }

    cout<<"se mostrara la cantidad que debe pagar cada cliente, con su inoformacion"<<endl;

    for(int m=0; m<clientN; m++)
    {
        cout<<"Se mostrara la informacion cliente numero: "<<m+1<<endl;
        cout<<"El numero de autos que alquilo este cliente son: "<<ClientesAutos[m][0]<<endl;
        for(int n=0; n<ClientesAutos[m][0]; m++)
        {
            if(AutosAlquilados[m][n]>100)
            {
                cout<<"El kilometraje es mayor a 100, por lo tanto se usara el C2 y B2, en este auto"<<endl;
                acuCosto = Costo2 *AutosAlquilados[m][n];
                acuBase = Base2;
            }
            else
            {
                acuCosto= Costo1 * AutosAlquilados[m][n];
                acuBase = Base1;
            }
            CostoParcial = acuCosto;
            BaseParcial = acuBase;
            cout<<"Lo facturado por el auto numero: "<<n+1<<endl;
            cout<<"Costo por el kilometraje, es:"<<endl;
            cout<<CostoParcial;
            cout<<"Costo por el alquiler del auto, es:"<<endl;
            cout<<BaseParcial;
            BaseTotal+= BaseParcial;
            CostoTotal += CostoParcial;
        }
        cout<<"Los totales a pagar por este cliente es:"<<endl;
        cout<<"Total a pagar por el alquiler de "<<ClientesAutos[m][0]<<" auto(s) es de = "<<BaseTotal<<endl;

        cout<<"Total a pagar porla sumatoria de los kilometrajes de lo(s) auto(s) es de = "<<CostoTotal<<endl;
    }
    cout << "Hello world!" << endl;
    return 0;
}
