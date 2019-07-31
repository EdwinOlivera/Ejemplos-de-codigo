#include <iostream>
#include<time.h>
#include<stdlib.h>
using namespace std;

int main()
{
    int OrdenDematriz=5;
    int Numero[OrdenDematriz][OrdenDematriz];
    srand(time(NULL));

    cout<<"\nMatriz que genera numeros aleatorios entre 0 a 9"<<endl;
    for(int i=0; i <OrdenDematriz; i++)
    {

        for(int j=0; j<OrdenDematriz; j++)
        {
            Numero[i][j]= 1+rand()%10-1;
            cout<<"| "<<Numero[i][j];
        }
        cout<<"| "<<endl;
    }

    cout<<"\nMatriz que genera numeros aleatorios entre 10 a 100"<<endl;
    for(int i=0; i <OrdenDematriz; i++)
    {

        for(int j=0; j<OrdenDematriz; j++)
        {
            Numero[i][j]= 10+rand()%101-1;
            cout<<"| "<<Numero[i][j];
        }
        cout<<"| "<<endl;
    }

    return 0;
}
