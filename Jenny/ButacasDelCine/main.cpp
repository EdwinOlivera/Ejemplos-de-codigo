#include <iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;
void RellenarConCeros(int [][15], int [], int []);
int CalcularGanacia(int);
void CantidadEnCadaFila(int [][15], int []);
void EdadesAsistidas(int [][15],int []);
int DeterminarEdadesMasFrecuentes(int []);
int DeterminarEdadesMenosFrecuentes(int []);
void OrganizarEdadesFrecuentes(int arregloDeLasEdades[], int EdadOrg[70]);
int main()
{
    //Valor de boletos niños = 60 (3-12), mayores de 12 (13 - 59) = 100, mayores de Edad 59 (60 -...) = 70
    int SalaDeCine[25][15], Ganancia = 0;
    int CantidadFila[25], ArregloDeEdades[70], EdadesOrganizadas[70], EdadesMasFrecuentes = 0, EdadesMenosFrecuentes = 0;
    int Fila =0, Columna = 0, edades = 0;
    bool Ocupado = true;

    srand(time(NULL));
    RellenarConCeros(SalaDeCine, CantidadFila, ArregloDeEdades);

    for(int j = 0; j < 100; j++)
    {
        do
        {
            Fila = rand()%25;
            Columna = rand()%15;
            if(SalaDeCine[Fila][Columna] == 0)
            {
                Ocupado = false;
                edades = 1+rand()%70;


                Ganancia += CalcularGanacia(edades);

                SalaDeCine[Fila][Columna] = edades;
            }
        }
        while(Ocupado);
        Ocupado = true;
    }



    for(int i = 0; i<25; i++)
    {
        for(int j = 0; j<15; j++)
        {
            if(SalaDeCine[i][j]<10)
            {
                cout<<" _|_ "<<SalaDeCine[i][j];
            }
            else
            {
                cout<<" _|_"<<SalaDeCine[i][j];
            }
            if(j == 14)
            {
                cout<<" _|"<<endl;
            }
        }
    }

    OrganizarEdadesFrecuentes(ArregloDeEdades, EdadesOrganizadas);
    EdadesMasFrecuentes = DeterminarEdadesMasFrecuentes(EdadesOrganizadas);
    EdadesMenosFrecuentes =  DeterminarEdadesMenosFrecuentes(EdadesOrganizadas);
    cout<<"La ganancia total optenida es de L. "<<Ganancia<<endl;
    cout<<"La edad mas frecuente es :"<<EdadesMasFrecuentes<<endl;
    cout<<"La edad menos frecuente es: "<<EdadesMenosFrecuentes<<endl;
    CantidadEnCadaFila(SalaDeCine,CantidadFila);
    EdadesAsistidas(SalaDeCine,ArregloDeEdades);
    cout << "\nFin del Programa" << endl;
    return 0;
}

void RellenarConCeros(int salaPrincipal[][15], int CantidadEnLasFilas[], int ArreglosDeLasEdades[])
{
    for(int i=0; i<25; i++)
    {
        CantidadEnLasFilas[i] = 0;
        for(int j =0; j<15; j++)
        {
            salaPrincipal[i][j] = 0;
        }
    }

    for(int L=0; L<70; L++)
    {
        ArreglosDeLasEdades[L] = 0;
    }

}

int CalcularGanacia(int edadCliente)
{
    int  boletoNigno = 60, boletoMayores = 100, boletoMayorEdad = 70;
    if(edadCliente>=3 && edadCliente<=12)
    {
        return boletoNigno;
    }
    else if(edadCliente >=13 && edadCliente<= 59)
    {
        return boletoMayores;
    }
    else
    {
        return boletoMayorEdad;
    }
}
void CantidadEnCadaFila(int SalaPrincipal[][15], int CadaFila[])
{
    int MayorNumero = 0, filaConMasButacas = 0;
    for(int i = 0; i < 25; i++)
    {
        for(int j = 0; j < 15; j++)
        {
            if(SalaPrincipal[i][j] != 0)
                CadaFila[i] +=1;
        }
    }
    MayorNumero = CadaFila[0];
    cout<<"\nLa cantidad de personas en cada fila es: "<<endl;
    for(int i =0; i<25; i++)
    {
        cout<<"En la fila "<<(i+1)<<" es: "<<CadaFila[i]<<endl;
        if(MayorNumero < CadaFila[i])
        {
            filaConMasButacas = i+1;
            MayorNumero = CadaFila[i];
        }
    }


    cout<<"\nLa fila con mas butacas es: "<<filaConMasButacas<<endl;
}

void EdadesAsistidas(int SalaPrincipal[][15],int EdadCliente[])
{
    int EdadRecopilada = 0;

    int EdadesFiltradas[70];

    for(int k =0; k<70; k++)
    {
        EdadesFiltradas[k] = k+1;
    }

    for(int i=0; i<25; i++)
    {
        for(int j = 0; j<15; j++)
        {
            EdadRecopilada = SalaPrincipal[i][j];
            if(EdadRecopilada !=0)
            {
                EdadCliente[EdadRecopilada-1] +=1;
            }
        }
    }

    cout<<"\nLa cantidad personas de determinadas edades que asistieron a la presentacion son: "<<endl;
    for(int k = 0; k <70; k++)
    {
        if(EdadCliente[k] !=0)
        {
            cout<<"Edad "<<EdadesFiltradas[k]<<" :";
            cout<<EdadCliente[k]<<endl;
        }
    }


}

void OrganizarEdadesFrecuentes(int arregloDeLasEdades[], int EdadOrg[])
{
    int CambiarDePosicion = 0, asientosVacios = 0;

    for(int q = 0; q<70; q++)
    {
        for(int p =0; p<70; p++)
        {
            if(arregloDeLasEdades[p] == q)
            {
                if(q == 0)
                {
                    asientosVacios++;
                }
                EdadOrg[CambiarDePosicion] = p+1;
                CambiarDePosicion++;
            }
        }
    }
    cout<<"\nLas ededades mas frecuentes (en orden Ascendentes) son :"<<endl;
    for(int i =29; i < 70; i++)
    {
        cout<<" | "<<EdadOrg[i]<<" | "<<endl;
    }


}

int DeterminarEdadesMasFrecuentes(int EdadCliente[])
{
    int MasFrecuente  = 0;
    MasFrecuente= EdadCliente[69];
    return MasFrecuente;
}
int DeterminarEdadesMenosFrecuentes(int EdadCliente[])
{
    int MenosFrecuente = 0;

    MenosFrecuente = EdadCliente[29];
    return MenosFrecuente;
}
