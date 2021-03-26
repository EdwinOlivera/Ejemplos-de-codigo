#include <iostream>

using namespace std;
void menoresPorColumna(int numeroDeFilas, int numeroDeColumnas, int arregloPrincipal[][100]);
void mayoresPorFila(int numeroDeFilas, int numeroDeColumnas, int arregloPrincipal[][100]);
int main()
{
    int numeroDeFilas =0, numeroDeColumnas=0, numTmp = 0;
    do
    {
        cout<<"Ingresa la cantidad de Filas: "<<endl;
        cin>>numeroDeFilas;

    }
    while(numeroDeFilas <=0 );

    do
    {
        cout<<"Ingresa la cantidad de Columnas: "<<endl;
        cin>>numeroDeColumnas;

    }
    while(numeroDeColumnas <=1 ||numeroDeColumnas >= 100);

    int arregloPrincipal[numeroDeFilas][100];
    for(int i =0; i<numeroDeFilas; i++)
    {
        for(int j = 0; j<numeroDeColumnas; j++)
        {
            cout<<"Ingresar el elemento ["<<(i)<<"]["<<(j)<<"] = ";
            cin>> arregloPrincipal[i][j];
        }
    }

    mayoresPorFila(numeroDeFilas, numeroDeColumnas, arregloPrincipal);
    menoresPorColumna(numeroDeFilas, numeroDeColumnas, arregloPrincipal);
    return 0;
}

void menoresPorColumna(int numeroDeFilas, int numeroDeColumnas, int arregloPrincipal[][100])
{
    int elementoMenorColumna = 0;
    cout<<"Los menores de cada Columna"<<endl;
    for(int j = 0; j<numeroDeColumnas; j++)
    {
        elementoMenorColumna = arregloPrincipal[0][j];

        {
            for(int i =0; i<numeroDeFilas; i++)
                if(elementoMenorColumna>arregloPrincipal[i][j])
                {
                    elementoMenorColumna = arregloPrincipal[i][j];
                    elementoMenorColumna = elementoMenorColumna;
                }

        }
        cout<<elementoMenorColumna<<endl;
    }
}


void mayoresPorFila(int numeroDeFilas, int numeroDeColumnas, int arregloPrincipal[][100])
{
    int elementoMayorFila = 0;
     elementoMayorFila = arregloPrincipal[0][0];
    cout<<"Los numeros Mayores de cada fila"<<endl;
    for(int i =0; i<numeroDeFilas; i++)
    {
        elementoMayorFila = arregloPrincipal[i][0];
        for(int j = 0; j<numeroDeColumnas; j++)
        {
            if( elementoMayorFila<arregloPrincipal[i][j])
            {
                elementoMayorFila = arregloPrincipal[i][j];
                elementoMayorFila = elementoMayorFila;
            }
        }
        cout<<elementoMayorFila<<endl;
    }
}
