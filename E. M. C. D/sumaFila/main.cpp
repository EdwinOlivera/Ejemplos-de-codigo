#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void GenerarMatrizAleatorea(int [][10], int, int  );
void sumarFilas(int [][10],int [], int, int  );
void MostrarArreglosMatriz(int [][10], int [], int, int  );
int main()
{
    int matrizElemento[10][10];
    int numfilasMatriz = 0, numcolumnasmatriz = 0;

        cout<<"Ingrese el No. de filas: ";
        cin>>numfilasMatriz;



        cout<<"Ingrese el No. de columnas: ";
        cin>>numcolumnasmatriz;

    if((numcolumnasmatriz<=10 && numcolumnasmatriz>= 3) && (numfilasMatriz<=10 && numfilasMatriz>= 3) ){



    int sumaFilas[numfilasMatriz];
    GenerarMatrizAleatorea(matrizElemento, numfilasMatriz, numcolumnasmatriz );

    sumarFilas(matrizElemento,sumaFilas, numfilasMatriz, numcolumnasmatriz );


    MostrarArreglosMatriz(matrizElemento,sumaFilas, numfilasMatriz, numcolumnasmatriz );
    }else{
    cout<<"Error! El menor numero de filas y columnaspermitido es de 3 y el mayor de 10"<<endl;
    }
    return 0;
}
void GenerarMatrizAleatorea(int matrizElemento[][10], int numfilasMatriz, int numcolumnasmatriz )
{
    srand(time(NULL));
    int numeroAleatorio=-3+rand()%(13);
    for(int i = 0; i< numfilasMatriz; i++)
    {
        for(int j = 0; j< numcolumnasmatriz; j++)
        {
            numeroAleatorio=-3+rand()%(13);
            matrizElemento[i][j]= numeroAleatorio;
        }
    }
}
void sumarFilas(int matrizElemento[][10], int sumaFilas[],int numfilasMatriz, int numcolumnasmatriz )
{


    for(int fila = 0; fila< numfilasMatriz; fila++)
    {
        sumaFilas[fila] = 0;
        for(int columna = 0; columna< numcolumnasmatriz; columna++)
        {
            sumaFilas[fila] += matrizElemento[fila][columna];
        }

    }
}
void MostrarArreglosMatriz(int matrizElemento[][10],int sumaFilas[], int numfilasMatriz, int numcolumnasmatriz )
{
    cout<<endl;
    for(int fila = 0; fila< numfilasMatriz; fila++)
    {
        for(int columna = 0; columna< numcolumnasmatriz; columna++)
        {
            cout<<" "<<matrizElemento[fila][columna];
        }
        cout<<endl;
    }

    cout<<endl;
    cout<<"Suma de cada fila: "<<endl;
    for(int numFila= 0; numFila< numfilasMatriz; numFila++)
    {
        cout<<" "<<sumaFilas[numFila];
    }
    cout<<endl;
}
