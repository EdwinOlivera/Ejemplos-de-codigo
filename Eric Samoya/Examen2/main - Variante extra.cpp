#include <iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;
void GenerarMatrizAleatorea(int [][10], int, int  );
void sumarColumnas(int [][10],int [], int, int  );
void MostrarArreglo(int [][10], int [], int, int  );
int main()
{
    int MatrizGenerada[10][10];
    int NumFilasMatris = 0, NumColumnasMatriz = 0;

        cout<<"Ingrese el No. de filas: ";
        cin>>NumFilasMatris;



        cout<<"Ingrese el No. de columnas: ";
        cin>>NumColumnasMatriz;

    if((NumColumnasMatriz<=10 && NumColumnasMatriz>= 3) && (NumFilasMatris<=10 && NumFilasMatris>= 3) ){



    int sumaColumna[NumColumnasMatriz];
    GenerarMatrizAleatorea(MatrizGenerada, NumFilasMatris, NumColumnasMatriz );

    sumarColumnas(MatrizGenerada,sumaColumna, NumFilasMatris, NumColumnasMatriz );


    MostrarArreglo(MatrizGenerada,sumaColumna, NumFilasMatris, NumColumnasMatriz );
    }else{
    cout<<"Error! El menor numero de filas y columnaspermitido es de 3 y el mayor de 10"<<endl;
    }
    return 0;
}
void GenerarMatrizAleatorea(int MatrizGenerada[][10], int NumFilasMatris, int NumColumnasMatriz )
{
    srand(time(NULL));
    int numeroAleatorio=-3+rand()%(13);
    for(int i = 0; i< NumFilasMatris; i++)
    {
        for(int j = 0; j< NumColumnasMatriz; j++)
        {
            numeroAleatorio=-3+rand()%(13);
            MatrizGenerada[i][j]= numeroAleatorio;
        }
    }
}
void sumarColumnas(int MatrizGenerada[][10], int sumaColumna[],int NumFilasMatris, int NumColumnasMatriz )
{


    for(int fila = 0; fila< NumFilasMatris; fila++)
    {
        sumaColumna[fila] = 0;
        for(int columna = 0; columna< NumColumnasMatriz; columna++)
        {
            sumaColumna[fila] += MatrizGenerada[fila][columna];
        }

    }
}
void MostrarArreglo(int MatrizGenerada[][10],int sumaColumna[], int NumFilasMatris, int NumColumnasMatriz )
{
    cout<<endl;
    for(int fila = 0; fila< NumFilasMatris; fila++)
    {
        for(int columna = 0; columna< NumColumnasMatriz; columna++)
        {
            cout<<" "<<MatrizGenerada[fila][columna];
        }
        cout<<endl;
    }

    cout<<endl;
    cout<<"Suma de cada fila: "<<endl;
    for(int numFila= 0; numFila< NumFilasMatris; numFila++)
    {
        cout<<" "<<sumaColumna[numFila];
    }
    cout<<endl;
}
