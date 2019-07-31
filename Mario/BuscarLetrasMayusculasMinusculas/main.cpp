#include <iostream>
#include <ctype.h>

using namespace std;
void BuscarLetras(string);
int main()
{

    string Cadena="";

    cout<<"Escriba alguna palabra"<<endl;
    cin>>Cadena;
    BuscarLetras(Cadena);

    return 0;
}

void BuscarLetras(string Cadena)
{
    char Alfabeto[]="ABCDFGHIJKLMNÑOPQRSTUVWXYZ";
    int numerosDeLetras=26;
    char *p1= Alfabeto;
    string LetraAlmacenada;
    int LetrasMayusculas=0, LetrasMinusculas=0;

    for(int k=0; k<numerosDeLetras; k++)
    {
        LetraAlmacenada = *(p1+k);
        for(int l=0; l<Cadena.length(); l++)
        {
            if(Cadena[l] == LetraAlmacenada[0])
            {
                LetrasMayusculas++;

            }
        }
    }

    for(int i=0; i<numerosDeLetras; i++)
    {
        Alfabeto[i] = tolower(Alfabeto[i]);
    }
    for(int i=0; i<numerosDeLetras; i++)
    {
        LetraAlmacenada = *(p1+i);

        for(int j=0; j<Cadena.length(); j++)
        {
            if(Cadena[j] == LetraAlmacenada[0])
            {
                LetrasMinusculas++;
            }
        }
    }

    cout<<"El numero de letras MAYUSCULAS en la palabra son: "<<LetrasMayusculas<<endl;
    cout<<"El numero de letras minusculas en la palabra son: "<<LetrasMinusculas<<endl;
}
