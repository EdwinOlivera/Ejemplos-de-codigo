#include <iostream>

using namespace std;

int main()
{
    int filas =0, columna=0, mayorFila = 0, menorColumna = 0, numTmp = 0;
    do
    {
        cout<<"Ingresa la cantidad de Filas: "<<endl;
        cin>>filas;

    }
    while(filas <=0 );

    do
    {
        cout<<"Ingresa la cantidad de Columnas: "<<endl;
        cin>>columna;

    }
    while(columna <=0 );

    int arregloPrincipal[filas][columna];
    for(int i =0; i<filas; i++)
    {
        for(int j = 0; j<columna; j++)
        {
            cout<<"Ingresar el elemento ["<<(i)<<"]["<<(j)<<"] = ";
            cin>> arregloPrincipal[i][j];
        }
    }
    numTmp = arregloPrincipal[0][0];
    cout<<"Los numeros Mayores de cada fila"<<endl;
    for(int i =0; i<filas; i++)
    {
        numTmp = arregloPrincipal[i][0];
        for(int j = 0; j<columna; j++)
        {
            if(numTmp<arregloPrincipal[i][j])
            {
                mayorFila = arregloPrincipal[i][j];
                numTmp = mayorFila;
            }
            else
            {
                mayorFila= numTmp;
            }

        }
        cout<<mayorFila<<endl;
    }



    cout<<"Los menores de cada Columna"<<endl;
    for(int j = 0; j<columna; j++)
    {
        numTmp = arregloPrincipal[0][j];

        {
            for(int i =0; i<filas; i++)
                if(numTmp>arregloPrincipal[i][j])
                {
                    menorColumna = arregloPrincipal[i][j];
                    numTmp = menorColumna;
                }
                else
                {
                    menorColumna = numTmp;
                }

        }

        cout<<menorColumna<<endl;
    }

    return 0;
}
