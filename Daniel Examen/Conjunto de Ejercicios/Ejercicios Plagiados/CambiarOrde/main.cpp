#include <iostream>
#include <cstring>
using namespace std;
void RevertirOracion(char [], char[]);
int main()
{
    int NumeroDeEspacios=500;
    char OracionOriginal[NumeroDeEspacios], OracionCambiada[NumeroDeEspacios];
    cout<<"Ingrese la oracion o frase que desea voltear"<<endl;
    cin.getline(OracionOriginal, NumeroDeEspacios);
    RevertirOracion(OracionOriginal, OracionCambiada);
    return 0;
}
void RevertirOracion(char Oracion[], char OracionRevertida[])
{
    bool VariasPalabras=false;
    int CantidadDeLetras = 0;
    CantidadDeLetras = strlen(Oracion);
    for(int m=0; m < CantidadDeLetras; m++)
    {
        if(Oracion[m]==' ')
        {
            VariasPalabras=true;
            break;
        }
    }
    if(VariasPalabras)
    {
        Oracion[CantidadDeLetras]=' ';
        CantidadDeLetras = strlen(Oracion);
        int EspaciosRecorridos = 0, Espacios=0, EspaciosCrecientes=0, DiferenciasEntrePalabras=0;
        for(int i=0; i < CantidadDeLetras; i++)
        {
            bool EspaciosEnBlanco= (Oracion[i]==' ' &&  Oracion[i-1]!=' ');
            bool UltimaPosicion= (i==CantidadDeLetras-1);
            EspaciosRecorridos = i+1;
            if( EspaciosEnBlanco || UltimaPosicion )
            {
                Espacios=EspaciosRecorridos;
                DiferenciasEntrePalabras= Espacios-EspaciosCrecientes;
                for(int j=DiferenciasEntrePalabras; j>0 ; j--)
                {
                    OracionRevertida[(CantidadDeLetras) - Espacios]=Oracion[EspaciosCrecientes];
                    Espacios--;
                    EspaciosCrecientes++;
                }
            }
        }
        cout<<"La oracion rervertida es: "<<OracionRevertida<<endl;
    }
    else
    {
        cout<<"A introducido una sola palabra. No se puede revertir la oracion/frase si solo es una palabra"<<endl;
    }
}
