#include <iostream>
#include<time.h>
#include<stdlib.h>
#include <iomanip>

using namespace std;
#define dimensionMatriz  10
#define limiteSuperiorNumero  100
void determinarNumeroMenor(float numeroReales[dimensionMatriz][dimensionMatriz]);
int main()
{
    srand(time(NULL));
    float numeroReales[dimensionMatriz][dimensionMatriz];


    for(int i=0; i<dimensionMatriz; i++)
    {
        for(int j=0; j<dimensionMatriz; j++)
        {
            numeroReales[i][j] = 30+rand()%limiteSuperiorNumero ;
        }
    }
    cout<<"La tabla creada es: "<<endl;
    for(int i=0; i<dimensionMatriz; i++)
    {

        for(int j=0; j<dimensionMatriz; j++)
        {
            cout<< setw(10)<<numeroReales[i][j];
        }
        cout<<endl;
    }


    determinarNumeroMenor(numeroReales);


    return 0;
}
void determinarNumeroMenor(float numeroReales[dimensionMatriz][dimensionMatriz])
{

    float numeroMenor = numeroReales[0][0];
    int indiceColumna = 0, indiceFila = 0;

    for(int i=0; i<dimensionMatriz; i++)
    {
        for(int j=0; j<dimensionMatriz; j++)
        {
            if(numeroMenor>numeroReales[i][j])
            {
                indiceFila = i+1;
                indiceColumna = j+1;
                numeroMenor = numeroReales[i][j];
            }
        }
    }

    cout<<"El menor es: "<<numeroMenor<<endl;
    cout<<"Se encuentra en la posicion: "<<endl;
    cout<<"Fila: "<<indiceFila<<endl;
    cout<<"Columna: "<<indiceColumna<<endl;


}
