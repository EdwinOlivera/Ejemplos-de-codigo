#include <iostream>
#include <cstring>
using namespace std;

void ContarMayusculas(char [],char [], int);
int main()
{

    char LetrasMayusculas[]="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int iLetraEncontrada=0, NumeroDeLetras=500;
    char Cadena[NumeroDeLetras];

    cout<<"Ingrese la cadena en la cual quiere contar la cantidad de letras MAYUSCULAS que contiene"<<endl;
    cin.getline(Cadena,NumeroDeLetras);

    ContarMayusculas(Cadena, LetrasMayusculas,iLetraEncontrada);
    cout << "Fin del Programa" << endl;
    return 0;
}
void ContarMayusculas(char Oracion [],char Letras [], int CantidadEncontradas)
{
    int TamanioDeOracion=0, TamanioDeLetras=0;
    TamanioDeOracion = strlen(Oracion);
    TamanioDeLetras = strlen(Letras);

    for(int i=0; i< TamanioDeOracion; i++){
        for(int j=0; j< TamanioDeLetras; j++){
            if(Oracion[i]==Letras[j]){
                CantidadEncontradas++;
            }
        }
    }
    cout<<"El numero de MAYUSCULAS en la cadena son: "<<CantidadEncontradas<<endl;
}
