#include <iostream>

using namespace std;
void numerosMenoresDeCadaColumna(int cantidadFilas, int cantidadColumnas, int arregloPrincipal[][50]);
void numerosMayoresDeCadaFila(int cantidadFilas, int cantidadColumnas, int arregloPrincipal[][50]);
int main()
{
    int cantidadFilas =0, cantidadColumnas=0;
    do
    {
        cout<<"Ingresa la cantidad de Filas: ";
        cin>>cantidadFilas;

    }
    while(cantidadFilas <=0 );

    do
    {
        cout<<"Ingresa la cantidad de Columnas: ";
        cin>>cantidadColumnas;

    }
    while(cantidadColumnas <=1 ||cantidadColumnas >= 50);

    int arregloPrincipal[cantidadFilas][50];

    cout<<"Ingresar los numeros de cada casilla de la matriz "<<endl;
    for(int i =0; i<cantidadFilas; i++)
    {
        for(int j = 0; j<cantidadColumnas; j++)
        {
            cout<<"Ingresar el elemento ["<<(i)<<"]["<<(j)<<"] = ";
            cin>> arregloPrincipal[i][j];
        }
    }

    numerosMayoresDeCadaFila(cantidadFilas, cantidadColumnas, arregloPrincipal);
    numerosMenoresDeCadaColumna(cantidadFilas, cantidadColumnas, arregloPrincipal);
    return 0;
}

void numerosMenoresDeCadaColumna(int cantidadFilas, int cantidadColumnas, int arregloPrincipal[][50])
{
    int numeroMenor = 0;
    int indiceColumna= 0;
    cout<<"Los menores de cada Columna"<<endl;
    for(int j = 0; j<cantidadColumnas; j++)
    {
        numeroMenor = arregloPrincipal[0][j];
        indiceColumna = j;

        {
            for(int i =0; i<cantidadFilas; i++)
                if(numeroMenor>arregloPrincipal[i][j])
                {
                    numeroMenor = arregloPrincipal[i][j];
                    numeroMenor = numeroMenor;
                    indiceColumna = j;
                }

        }
        cout<<"El numero menor de la columna: "<<indiceColumna<<", es: "<<numeroMenor<<endl;

    }
}

void numerosMayoresDeCadaFila(int cantidadFilas, int cantidadColumnas, int arregloPrincipal[][50])
{
    int numeroMayor = 0;
    numeroMayor = arregloPrincipal[0][0];
    int indiceFila= 0;

    cout<<"Los numeros Mayores de cada fila"<<endl;
    for(int i =0; i<cantidadFilas; i++)
    {
        numeroMayor = arregloPrincipal[i][0];
        indiceFila= i;
        for(int j = 0; j<cantidadColumnas; j++)
        {
            if( numeroMayor<arregloPrincipal[i][j])
            {
                numeroMayor = arregloPrincipal[i][j];
                numeroMayor = numeroMayor;
            }
        }

        cout<<"El numero Mayor de la Fila: "<<indiceFila<<", es: "<<numeroMayor<<endl;
    }
}
