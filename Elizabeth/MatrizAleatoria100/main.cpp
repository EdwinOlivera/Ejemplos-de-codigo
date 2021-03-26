#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;
int main()
{
    int numero= 0, arregloAletatorio[1000], arregloNumero[11][2];
    srand((int)time(0));
    for(int i=0; i<1000; i++)
    {
        numero = ((rand()%11));
        arregloAletatorio[i]= numero;
    }
    for(int i=0; i<11; i++)
    {
        arregloNumero[i][0]= i;
        arregloNumero[i][1]= 0;
    }
    for(int i=0; i<11; i++)
    {
        arregloNumero[i][0];
        for(int j=0; j<1000; j++)
        {
            if(arregloAletatorio[j] == arregloNumero[i][0])
            {
                arregloNumero[i][1]++;
            }
        }
    }
cout<<"\t\t\tTabla de frecuencia"<<endl;
cout<<"--------------------------------------------------------------"<<endl;
cout<<"\t\tNumero";
cout<<"\t|\tNumero de apariciones"<<endl;
cout<<"--------------------------------------------------------------"<<endl;
for(int i=0; i<11; i++){

    cout<<"\t\t"<<i;
    cout<<"\t|\t"<<arregloNumero[i][1]<<endl;
}
    return 0;
}
