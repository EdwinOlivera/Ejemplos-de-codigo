#include <iostream>
#include <string.h>
using namespace std;

class Cadena
{
public:
    Cadena(string);
    ~Cadena();
    InvertirCadena();
    EsPal();
    string cadenaIngresada;

};
Cadena::Cadena(string _cadena)
{
    cadenaIngresada = _cadena;
}

Cadena::InvertirCadena()
{
    char *cadena = &cadenaIngresada[0];
    char* apC = NULL;

    int largoCadena = 0, indiceEspacioEnBlanco = 0, cantidadCaracteres = 0, ultimoIndicieEspacio=0;
    apC = &cadena[0];


    strlen(apC);

    int maxCaracteres = 0;

    maxCaracteres = strlen(apC)-1;
    while(*(apC+largoCadena)==' ')
    {
        *(apC+largoCadena)='\0';
        largoCadena++;
    }
    largoCadena=0;

    while(maxCaracteres > largoCadena)
    {
        if(*(apC+largoCadena)==' ')
        {
            for(int i =indiceEspacioEnBlanco-1; i>=ultimoIndicieEspacio; i--)
            {
                cout<<*(apC+i);
            }
            cout<<" ";
            ultimoIndicieEspacio=indiceEspacioEnBlanco;
        }
        cantidadCaracteres++;
        indiceEspacioEnBlanco++;
        largoCadena++;
    }

    while(ultimoIndicieEspacio <=maxCaracteres )
    {
        cout<<apC[maxCaracteres];
        maxCaracteres--;
    }
}
Cadena::EsPal()
{
    char *OracionIngresada = &cadenaIngresada[0];

    string  OracionSinEspaciosPrimera, OracionSinEspaciosSegunda;
    int ConteoNormal=0, ConteoInverso=0, NumeroDeCaracteres=0, numeroDeEspacios=0, PuntosEncotrados=0;
    bool EsPalindroma=true;

    NumeroDeCaracteres= cadenaIngresada.size();

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
        if(OracionSinEspaciosPrimera[ConteoNormal] != OracionSinEspaciosSegunda[ConteoInverso])
        {
            cout<<"No es una oracion Palindroma"<<endl;
            EsPalindroma = false;
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
}

Cadena::~Cadena()
{
    cout<<"\nFin de la ejecucion."<<endl;
}
int main()
{
    string cadenaIngresa = "123";
    cout<<"Ingrese la cadena: ";
    cin>>cadenaIngresa;
    while(cadenaIngresa.size()<5 || cadenaIngresa.size()>25)
    {
        cout<<"La cadena ingresada es muy corta. Ingresa una que tenga entre 5 y 25 letras"<<endl;
        cin>>cadenaIngresa;
    }
    Cadena objCadena(cadenaIngresa);
    objCadena.InvertirCadena();
    cout<<endl;
    objCadena.EsPal();

    return 0;
}
