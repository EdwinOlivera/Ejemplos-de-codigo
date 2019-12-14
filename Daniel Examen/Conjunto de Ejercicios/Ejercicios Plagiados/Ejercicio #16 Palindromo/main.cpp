#include <iostream>
#include <cstring>
using namespace std;

int main()
{

    char OracionIngresada[500];
    string  OracionSinEspaciosPrimera, OracionSinEspaciosSegunda;
    int ConteoNormal=0, ConteoInverso=0, NumeroDeCaracteres=0, numeroDeEspacios=0, PuntosEncotrados=0;
    bool EsPalindroma=true;


    cout<<"Ingrese una oracion para comprobar si es un Palindromo"<<endl;
    cin.getline(OracionIngresada,500);

    NumeroDeCaracteres= strlen(OracionIngresada);

    for(int i=0; i < NumeroDeCaracteres; i++)
    {
        if(OracionIngresada[i]!= ' ' )
        {
            numeroDeEspacios++;
            if(OracionIngresada[i]!= '.' )
            {

                PuntosEncotrados++;
                OracionSinEspaciosPrimera += tolower(OracionIngresada[i]);
                OracionSinEspaciosSegunda += tolower(OracionIngresada[i]);
            }
        }
    }
    cout<<OracionSinEspaciosPrimera<<endl;
    NumeroDeCaracteres = (NumeroDeCaracteres-numeroDeEspacios)/2;
    ConteoInverso = NumeroDeCaracteres-1;
    for(int M=0; M<NumeroDeCaracteres; M++)
    {
        if(OracionSinEspaciosPrimera[ConteoNormal]!= OracionSinEspaciosSegunda[ConteoInverso])
        {
            cout<<"No es una oracion Palindroma"<<endl;
            EsPalindroma= false;
            return 0;
        }
        else
        {
            ConteoNormal++;
            ConteoInverso--;
        }
    }

    if(EsPalindroma==true)
    {
        cout<<"Si es una oracion Palindroma"<<endl;
    }
    return 0;
}
