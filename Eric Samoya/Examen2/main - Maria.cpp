#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void GenerarMatrizAleatorea(int [][10], int , int  );
void VectorMenorMatriz(int [][10],int [], int , int  );
void MostrarArreglosMatriz(int [][10], int [], int , int  );
int main()
{
    int matrizElemento[10][10];
    int numfilasMatriz = 0, numcolumnasmatriz = 0;
    do
    {
        cout<<"Ingrese el numero de fila de la matriz"<<endl;
        cin>>numfilasMatriz;
    }
    while(numfilasMatriz>10 || numfilasMatriz< 3);

    do
    {
        cout<<"Ingrese el numero de columnas de la matriz"<<endl;
        cin>>numcolumnasmatriz;
    }
    while(numcolumnasmatriz>10 || numcolumnasmatriz< 3);
    int arreglonumerosmenoros[numcolumnasmatriz];
    GenerarMatrizAleatorea(matrizElemento, numfilasMatriz, numcolumnasmatriz );

    VectorMenorMatriz(matrizElemento,arreglonumerosmenoros, numfilasMatriz, numcolumnasmatriz );

    cout<<"La matriz generada es: "<<endl;
    MostrarArreglosMatriz(matrizElemento,arreglonumerosmenoros, numfilasMatriz, numcolumnasmatriz );
    return 0;
}
void GenerarMatrizAleatorea(int matrizElemento[][10], int numfilasMatriz, int numcolumnasmatriz )
{
    srand(time(NULL));
    int numeroAleatorio=15+rand()%(30);
    for(int i = 0; i< numfilasMatriz; i++)
    {
        for(int j = 0; j< numcolumnasmatriz; j++)
        {
            numeroAleatorio=15+rand()%(15);
            matrizElemento[i][j]= numeroAleatorio;
        }
    }
}
void VectorMenorMatriz(int matrizElemento[][10], int arreglonumerosmenoros[],int numfilasMatriz, int numcolumnasmatriz )
{

    int  elMorDeLaColumna=0;
    for(int i = 0; i< numcolumnasmatriz; i++)
    {
        elMorDeLaColumna = matrizElemento[i][0];
        for(int j = 0; j< numfilasMatriz ; j++)
        {
            if(elMorDeLaColumna >matrizElemento[j][i])
            {
                arreglonumerosmenoros[i] =  matrizElemento[j][i];
                elMorDeLaColumna = matrizElemento[j][i];
            }
        }
    }
}
void MostrarArreglosMatriz(int matrizElemento[][10],int arreglonumerosmenoros[], int numfilasMatriz, int numcolumnasmatriz )
{
    for(int fila = 0; fila< numfilasMatriz; fila++)
    {
        for(int columna = 0; columna< numcolumnasmatriz; columna++)
        {
            cout<<" "<<matrizElemento[fila][columna];
        }
        cout<<endl;
    }

    cout<<endl;
    cout<<"El vector de los valores menores de la columna de la matriz es: "<<endl;
    for(int numColumna = 0; numColumna< numcolumnasmatriz; numColumna++)
    {
        cout<<" "<<arreglonumerosmenoros[numColumna];
    }
    cout<<endl;
}
