#include <iostream>
#include<time.h>
#include<stdlib.h>
#include <iomanip>

#include <vector> // Clase Vector

using namespace std;
#define dimensionMatriz  10
#define limiteSuperiorNumero  100
void determinarNumeroMenor(vector< vector<float> > );
int main()
{
    srand(time(NULL));
    float numeroReales[dimensionMatriz][dimensionMatriz];
    vector<float> vectorDeNumeros;

    vector< vector<float> > vectorDeNumerosMultiple(dimensionMatriz,vector<float>(dimensionMatriz));

    for(int i=0; i<dimensionMatriz; i++)
    {
        for(int j=0; j<dimensionMatriz; j++)
        {
            vectorDeNumerosMultiple[i][j] = 30+rand()%limiteSuperiorNumero ;
        }
    }


    cout<<"La tabla creada es: "<<endl;
    for(int i=0; i<dimensionMatriz; i++)
    {

        for(int j=0; j<dimensionMatriz; j++)
        {
            cout<< setw(10)<<vectorDeNumerosMultiple[i][j];
        }
        cout<<endl;
    }
    determinarNumeroMenor(vectorDeNumerosMultiple);

    return 0;
}
void determinarNumeroMenor(vector< vector<float> > numeroReales)
{

    float numeroMenor = numeroReales[0][0];
    int indiceColumna = 0, indiceFila = 0;

    int numeroFila = dimensionMatriz-1, numeroColumna = dimensionMatriz-1;

    do
    {
        if(numeroMenor>=numeroReales[numeroFila][numeroColumna])
        {

            numeroMenor = numeroReales[numeroFila][numeroColumna];

            indiceColumna = numeroColumna;
            indiceFila = numeroFila;
            indiceColumna ++;
            indiceFila ++;
        }

        numeroFila--;
        if(numeroFila < 0 && numeroColumna >=0 )
        {
            numeroColumna--;
            numeroFila = dimensionMatriz-1;
        }
    }
    while(numeroColumna >= 0);

    cout<<"El menor es: "<<numeroMenor<<endl;
    cout<<"Se encuentra en la posicion: "<<endl;
    cout<<"Fila: "<<indiceFila<<endl;
    cout<<"Columna: "<<indiceColumna<<endl;


}
