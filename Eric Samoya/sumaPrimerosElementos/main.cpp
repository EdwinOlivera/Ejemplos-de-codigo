#include <iostream>

using namespace std;

int main()
{
    int num=1, numAcumulado = 1, suma=0;
    int arreglo[100];
    do
    {
        cout<<"Escriba el tamano del arreglo ";
        cin>>num;

    }
    while(num <0 || num>=100);
    for(int i=0; i<num; i++)
    {
        suma +=numAcumulado;
        arreglo[i]=numAcumulado;
        numAcumulado= (numAcumulado *2)+1;
    }
    cout<<"Suma= "<<suma<<endl;
    for(int i = 0; i<num; i++)
    {
        cout<<arreglo[i]<<endl;
    }
    return 0;
}
