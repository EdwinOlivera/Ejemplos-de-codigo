#include <iostream>
#include <stdio.h>
#include <iomanip>

#include<string.h>
using namespace std;



void AsignarNumerosDeDatos(int *Dat, int *OrdenDefinitivaPolinomio, float Val[][102]);
float Potencia(int n, float Num);
void PreparaSistemaDeEcuacionesDeEcuaciones(int OrdenDefinitivaPolinomio, int Dat, float SistemaEcuaciones[][102], float Val[][102]);
void ResuelveGauss(int DimensionPolinomio, float SistemaEcuaciones[][102]);
void EscribeNumeroDeDatos(int DimensionPolinomio, float SistemaEcuaciones[][102]);


int main(void)
{
char str1[10] = "AMWEBTCH";
    char str2[10] = "AMWEBTCH";

	int n = strspn(str1, str2);

	printf("%d", n);

    int NumeroDeDatos,OrdenDefinitivaPolinomioenEcuacion,C;

    float ValoresultadoDeEcuaciones[2][102],SistemaDeEcuaciones[102][102];

    AsignarNumerosDeDatos(&NumeroDeDatos,&OrdenDefinitivaPolinomioenEcuacion,ValoresultadoDeEcuaciones);

    PreparaSistemaDeEcuacionesDeEcuaciones(OrdenDefinitivaPolinomioenEcuacion,NumeroDeDatos,SistemaDeEcuaciones,ValoresultadoDeEcuaciones);

    cout<<"\n El sistema a resultante es el siguiente: "<<endl;

    EscribeNumeroDeDatos(OrdenDefinitivaPolinomioenEcuacion,  SistemaDeEcuaciones);
    ResuelveGauss(OrdenDefinitivaPolinomioenEcuacion, SistemaDeEcuaciones);
    cout<<"\n El sistema final es:"<<endl;
    EscribeNumeroDeDatos(OrdenDefinitivaPolinomioenEcuacion,SistemaDeEcuaciones);
    cout<<"La Ecuacion del Polinomio resultante final es:"<<endl;
    cout<<":";
    for(C=1; C<=OrdenDefinitivaPolinomioenEcuacion; C++)
    {
        cout<<" +("<<SistemaDeEcuaciones[C][OrdenDefinitivaPolinomioenEcuacion+1]<<")X^"<<C-1;
    }
    cout<<endl;
    return(0);
}



void AsignarNumerosDeDatos(int *Dat, int *OrdenDefinitivaPolinomio,float Val[][102])
{
    int OrdenAsignada = 1;
    cout<<"METODO DE MINIMOS CUADRADOS."<<endl;
    cout<<"\nIntroduce el numero de datos (Puntos): ";

    cin>>*Dat;
    cout<<"\n\nIntroce los valoresultado de cada punto\n";

    for(int I = 1; I <= *Dat; I++)
    {
        cout<<"-ValoresultadoDeEcuaciones del Punto "<<I<<":"<<endl;
        cout<<"   X"<<I<<": ";
        cin>>Val[0][I];
        cout<<"   Y"<<I<<": ";
        cin>>Val[1][I];
    }
    cout<<"Introduce el orden del polinomio ( Ejemplo = 1): ";
    cin>>OrdenAsignada;
    if(OrdenAsignada>2 || OrdenAsignada<1)
    {
        OrdenAsignada =1;
        cout<<"\n------ Has ingresultadoado un valor no valido. Se reetablecio el orden a UNO (1)"<<endl;

    }
    *OrdenDefinitivaPolinomio=OrdenAsignada+1;
}

void PreparaSistemaDeEcuacionesDeEcuaciones(int OrdenDefinitivaPolinomio, int Dat, float SistemaEcuaciones[][102], float Val[][102])
{
    int C, Exponente = 1;
    float sumaPotenciaYValor,termino;

    for(int A =1; A<=OrdenDefinitivaPolinomio; A++)
        for(int B=1; B<=OrdenDefinitivaPolinomio; B++)
        {
            sumaPotenciaYValor=0;

            Exponente = A + B-2;

            for(C=1; C<=Dat; C++)
            {
                termino = Val[0][C];
                sumaPotenciaYValor=sumaPotenciaYValor+Potencia(Exponente,termino);
            }
            SistemaEcuaciones[A][B]=sumaPotenciaYValor;
        }
    for(int A=1; A<=OrdenDefinitivaPolinomio; A++)
    {
        sumaPotenciaYValor = 0;
        Exponente= A - 1;

        for(C=1; C<=Dat; C++)
        {
            termino = Val[0][C];
            sumaPotenciaYValor = sumaPotenciaYValor+Val[1][C]*Potencia(Exponente,termino);
        }
        SistemaEcuaciones[A][OrdenDefinitivaPolinomio+1]=sumaPotenciaYValor;
    }
}

float Potencia(int n, float Num)
{

    float resultado;
    resultado=1;
    for(int A=1; A<=n; A++)
    {
        resultado = resultado * Num;
    }
    return resultado;
}





void ResuelveGauss(int DimensionPolinomio, float SistemaEcuaciones[][102])
{
    int NoCero = 0,A;
    float Pivote, V1;

    for(int Columna=1; Columna<=DimensionPolinomio; Columna++)
    {
        NoCero=0;
        A=Columna;
        while(NoCero==0)
        {
            if(SistemaEcuaciones[A][Columna]!=0)
            {
                NoCero=1;
            }
            else
                A++;
        }
        Pivote=SistemaEcuaciones[A][Columna];
        for(int NumAuxiliar1=1; NumAuxiliar1<=(DimensionPolinomio+1); NumAuxiliar1++)
        {
            V1=SistemaEcuaciones[A][NumAuxiliar1];
            SistemaEcuaciones[A][NumAuxiliar1]=SistemaEcuaciones[Columna][NumAuxiliar1];
            SistemaEcuaciones[Columna][NumAuxiliar1]=V1/Pivote;
        }
        for(int NumeroAuxiliar2=Columna+1; NumeroAuxiliar2<=DimensionPolinomio; NumeroAuxiliar2++)
        {
            V1=SistemaEcuaciones[NumeroAuxiliar2][Columna];
            for(int NumAuxiliar1=Columna; NumAuxiliar1<=(DimensionPolinomio+1); NumAuxiliar1++)
            {
                SistemaEcuaciones[NumeroAuxiliar2][NumAuxiliar1]=SistemaEcuaciones[NumeroAuxiliar2][NumAuxiliar1]-V1*SistemaEcuaciones[Columna][NumAuxiliar1];
            }
        }
    }

    for(int Columna=DimensionPolinomio; Columna>=1; Columna--)
        for(int NumAuxiliar1=(Columna-1); NumAuxiliar1>=1; NumAuxiliar1--)
        {
            SistemaEcuaciones[NumAuxiliar1][DimensionPolinomio+1]=SistemaEcuaciones[NumAuxiliar1][DimensionPolinomio+1]-SistemaEcuaciones[NumAuxiliar1][Columna]*SistemaEcuaciones[Columna][DimensionPolinomio+1];
            SistemaEcuaciones[NumAuxiliar1][Columna]=0;
        }
}

void EscribeNumeroDeDatos(int DimensionPolinomio, float SistemaEcuaciones[][102])
{
    int A,B;

    for(A=1; A<=DimensionPolinomio; A++)
    {
        for(B=1; B<=(DimensionPolinomio+1); B++)
        {
            cout<<setw(10)<<SistemaEcuaciones[A][B];

            if(B==DimensionPolinomio)
            {
                cout<<"   |";
            }
        }
        cout<<endl;

    }
    cout<<endl;
}
