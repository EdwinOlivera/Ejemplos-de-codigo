#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void GeneraArreglo(int [10][10], int , int  );
void MenorColumna(int [10][10],int [], int , int  );
void MostrarArreglos(int [10][10], int [], int , int);
int main()
{
    int matrizPrincipal[10][10];
    int FILAS = 0, COLUMNAS = 0;
    do
    {
        cout<<"Ingrese el numero de fila de la matriz"<<endl;
        cin>>FILAS;
    }
    while(FILAS< 3|| FILAS>10 );

    do
    {
        cout<<"Ingrese el numero de columnas de la matriz"<<endl;
        cin>>COLUMNAS;
    }
    while(COLUMNAS< 3|| COLUMNAS>10);
    int arreglonumerosmenoros[COLUMNAS];
    srand(time(NULL));

    GeneraArreglo(matrizPrincipal, FILAS, COLUMNAS );

    MenorColumna(matrizPrincipal,arreglonumerosmenoros, FILAS, COLUMNAS );

    cout<<"La matriz generada es: "<<endl;
    MostrarArreglos(matrizPrincipal,arreglonumerosmenoros, FILAS, COLUMNAS );
    return 0;
}
void GeneraArreglo(int matrizPrincipal[10][10], int FILAS, int COLUMNAS )
{
    int numeroAleatorio=15+rand()%(30);
    for(int i = 0; i< FILAS; i++)
    {
        for(int j = 0; j< COLUMNAS; j++)
        {
            numeroAleatorio=15+rand()%(15);
            matrizPrincipal[i][j]= numeroAleatorio;
        }
    }
}
void MostrarArreglos(int matrizPrincipal[10][10],int arreglonumerosmenoros[], int FILAS, int COLUMNAS )
{
    for(int filaMatriz = 0; filaMatriz< FILAS; filaMatriz++)
    {
        for(int columnaMatriz = 0; columnaMatriz< COLUMNAS; columnaMatriz++)
        {
            cout<<" "<<matrizPrincipal[filaMatriz][columnaMatriz];
        }
        cout<<endl;
    }

    cout<<endl;
    cout<<"El vector de los valores menores de la columna de la matriz es: "<<endl;
    for(int numColumna = 0; numColumna< COLUMNAS; numColumna++)
    {
        cout<<" "<<arreglonumerosmenoros[numColumna];
    }
    cout<<endl;
}

void MenorColumna(int matrizPrincipal[10][10], int arreglonumerosmenoros[],int FILAS, int COLUMNAS )
{

    int  numeroMenor=0;
    for(int i = 0; i< COLUMNAS; i++)
    {
        numeroMenor = matrizPrincipal[i][0];
        for(int j = 0; j< FILAS ; j++)
        {
            if(numeroMenor >matrizPrincipal[j][i])
            {
                arreglonumerosmenoros[i] =  matrizPrincipal[j][i];
                numeroMenor = matrizPrincipal[j][i];
            }
        }
    }
}
