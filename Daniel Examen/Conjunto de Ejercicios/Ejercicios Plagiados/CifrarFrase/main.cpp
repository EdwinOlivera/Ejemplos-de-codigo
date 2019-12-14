#include <iostream>
#include <stdio.h>
#include <cstring>
#include <ctype.h>
using namespace std;

string CifrarFrases(char [], int );

int main()
{
    int NumeroDeLetras=500;
    char Oracion[NumeroDeLetras];
    string OracionConvertida="";
    cout<<"Ingrese un texto para cifrarlo"<<endl;
    cin.getline(Oracion,NumeroDeLetras);
    OracionConvertida = CifrarFrases(Oracion, NumeroDeLetras);

    cout<<"La frase Cifrada es: "<<OracionConvertida<<endl;

    return 0;
}
string CifrarFrases(char Oracion[], int NumeroDeLetras)
{
    char OracionCifrada[NumeroDeLetras], Letras[]="ABCDEFGHIJKLMNOPQRSTUVWXYZ", LetrasMinusculas[NumeroDeLetras];

    int LetrasEnOracion = strlen(Oracion);
    int CantidadDeLetras = strlen(Letras);

    //Hace la evaluacion con letras mayusculas
    for(int i=0; i<LetrasEnOracion; i++)
    {
        if(Oracion[i] ==' ')
        {
            OracionCifrada[i]=Oracion[i];
        }
        for(int j=0; j<CantidadDeLetras; j++ )
        {
            if(Oracion[i]==Letras[j] && Oracion[i]!=' ')
            {
                switch(j)
                {
                case 25:
                    OracionCifrada[i]=Letras[0];
                    break;
                case 26:
                    OracionCifrada[i]=Letras[1];
                    break;
                case 27:
                    OracionCifrada[i]=Letras[2];
                    break;
                default:
                    OracionCifrada[i]=Letras[j+3];
                    break;
                }
            }

        }
    }
    //Convierte las letras en minusculas
    for(int C = 0; C< CantidadDeLetras; C++)
    {
        LetrasMinusculas[C] = tolower(Letras[C]);
    }
    //Hace la misma evaluacion, solo que ahora con minusculas
    for(int i=0; i<LetrasEnOracion; i++)
    {
        if(Oracion[i] ==' ')
        {
            OracionCifrada[i]=Oracion[i];
        }
        for(int j=0; j<CantidadDeLetras; j++ )
        {
            if(Oracion[i]==LetrasMinusculas[j] && Oracion[i]!=' ')
            {
                switch(j)
                {
                case 25:
                    OracionCifrada[i]=LetrasMinusculas[0];
                    break;
                case 26:
                    OracionCifrada[i]=LetrasMinusculas[1];
                    break;
                case 27:
                    OracionCifrada[i]=LetrasMinusculas[2];
                    break;
                default:
                    OracionCifrada[i]=LetrasMinusculas[j+3];
                    break;
                }
            }

        }
    }
    string Cifrado="";

    for(int m=0;m<LetrasEnOracion ; m++){
        Cifrado +=OracionCifrada[m];
    }

    return Cifrado;
}


