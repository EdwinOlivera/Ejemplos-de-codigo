#include <iostream>

using namespace std;
void llenarMatriz(float [][100], int);
bool EncontrarNegativo(float [][100], int);
bool ComprobarSuma(float [][100], int, float);
int main()
{
    float MatrizPrincipal[100][100], sumaHorizontal = 1;
    bool elementoNegativo = false, sumatoriaDiferente = false;
    int dimenciones = 1;

    cout<<"Ingrese la dimencion de la matriz cuadrada"<<endl;
    cin>>dimenciones;
    llenarMatriz(MatrizPrincipal, dimenciones);
    elementoNegativo =  EncontrarNegativo(MatrizPrincipal, dimenciones);


    if(elementoNegativo)
    {
        cout<<"La matriz tiene un elemento negativo, por lo tanto no es una matriz de Probabilidades"<<endl;
    }
    else
    {
        sumatoriaDiferente = ComprobarSuma(MatrizPrincipal, dimenciones, sumaHorizontal);


        if(sumatoriaDiferente)
        {
            cout<<"La matriz no es una matriz de probabilidades. Uno de los renglones no suma 1"<<endl;
        }
        else
        {
            cout<<"La matriz si es una matriz de probabilidades"<<endl;
        }
    }



    return 0;
}

bool ComprobarSuma(float MatrizOriginal[][100], int dimencionesMatriz, float sumaHorizontal){
bool sumaFallida = false;
        for(int i = 0; i<dimencionesMatriz; i++)
        {
            for(int j =0; j<dimencionesMatriz; j++)
            {
                sumaHorizontal += MatrizOriginal[i][j];
            }
            if(sumaHorizontal !=1)
            {
                sumaFallida=true;
                break;
            }
        }
return sumaFallida;

}


bool EncontrarNegativo(float MatrizOriginal[][100], int dimencionesMatriz)
{
    bool NegativoEncontrado =  false;
        for(int i = 0; i<dimencionesMatriz; i++)
    {
        for(int j =0; j<dimencionesMatriz; j++)
        {
            if(MatrizOriginal[i][j] <0)
            {
                NegativoEncontrado=true;
                break;
            }
        }
        if(NegativoEncontrado)
        {
            break;
        }
    }
    return NegativoEncontrado;
}

void llenarMatriz(float MatrizOriginal[][100], int dimecionesMatriz)
{

    for(int i = 0; i<dimecionesMatriz; i++)
    {
        for(int j =0; j<dimecionesMatriz; j++)
        {
            cout<<"Ingrese el elemento ["<<(i+1)<<"],["<<(j+1)<<"] de la matriz"<<endl;
            cin>>MatrizOriginal[i][j];
        }
    }

}
