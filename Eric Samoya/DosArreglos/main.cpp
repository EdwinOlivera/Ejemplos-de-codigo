#include <iostream>

using namespace std;
void DistribucionNumero(int [20], int [20], int);
int main()
{
    int numPares[20], numImpares[20], numIngresado;
    do
    {
        cout<<"Ingrese un numero (n>=0)"<<endl;
        cin>>numIngresado;

        if(numIngresado<0)
        {
            cout<<"Ha ingresado un numero no valido"<<endl;
        }
    }
    while(numIngresado<0);
    DistribucionNumero(numPares,numImpares,numIngresado);
    return 0;
}
void DistribucionNumero(int numPares[20], int numImpares[20], int numIngresado)
{
    int numTmp = 0, recorArregloPares = 0, recorArregloImpares = 0;
    while(numIngresado > 0)
    {
        numTmp= numIngresado %10;
        if(numTmp%2==0)
        {
            numPares[recorArregloPares] = numTmp;
            recorArregloPares++;
        }
        else
        {
            numImpares[recorArregloImpares] = numTmp;
            recorArregloImpares++;
        }

        numIngresado  = numIngresado /10;
    }
    cout<<"\nLos digitos pares son: "<<endl;
    for(int  i =0; i<recorArregloPares; i++)
    {
        cout<<numPares[i]<<endl;
    }

    cout<<"\nLos digitos impares son: "<<endl;
    for(int  i =0; i<recorArregloImpares; i++)
    {
        cout<<numImpares[i]<<endl;
    }
}

