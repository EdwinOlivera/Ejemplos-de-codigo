#include <iostream>
#include <stdio.h>
#include <cstring>
using namespace std;

int main()
{
    int palabraContadas=1, NumeroDeLetras=500;
    char Frases[NumeroDeLetras];
    cout<<"Ingrese un texto para contar el numero de palabras que tiene"<<endl;
    cin.getline(Frases,NumeroDeLetras);
    int CantidadDeLetras = strlen(Frases);
    for(int i=0; i< CantidadDeLetras; i++)
    {
        if(Frases[i]==' ' && i>0 && Frases[i-1]!=' ')
        {
            palabraContadas++;
        }
    }
    if(Frases[CantidadDeLetras-1]==' ')
    {
        palabraContadas--;
    }
    cout<<"El numero de Palabras que tiene la oracion son: "<< palabraContadas<<endl;
    return 0;
}
