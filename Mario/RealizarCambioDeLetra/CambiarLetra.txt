#include <iostream>
#include <conio.h>
#include <stdio.h>
#include <string.h>

using namespace std;

int main()
{
    int numeroDeLetras=500;
    char Cadena[numeroDeLetras];
    char *Pc = Cadena;
    char Letrab[]= "b",LetraB[]= "B", Espacio[]=" ";
    cout<<"Ingrese una Frase o Palabra a la cual se le cambiara la letra \"b\" por una la letra \"T\""<<endl;
    cout<<"Los espacios en blanco en doble espacio"<<endl;
    cin.getline(Cadena,numeroDeLetras);
    int longitud = strlen(Cadena);//Con esta variable se sabe el tamaño dinamico del char
    for(int i=0; i<longitud; i++)
    {
        if(Letrab[0] == *(Pc+i) || LetraB[0] == *(Pc+i))
        {
            *(Pc +i) ='T';
        }

    }

    cout<<"\nLa frase/Palabra Cambiada es: \n"<<endl;
    for(int k=0; k < longitud; k++)
    {
        cout<<Cadena[k];
        if(Espacio[0] == *(Pc+k) )
        {
            //cout<<"Se ha encontrado un espacio"<<endl;
            cout<<" ";
        }
    }
    return 0;
}
