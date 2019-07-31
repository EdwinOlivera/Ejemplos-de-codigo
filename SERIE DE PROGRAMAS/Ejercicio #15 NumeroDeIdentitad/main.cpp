#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    char Departamento[4];
    char NumeroDeIdentidad[15], Numeros[]="0123456789-", LetrasMinusculas[]="abcdefghijklmnopqrstuvwxyz", LetrasMayusculas[]="ABCDEFGHIJKLMNOPQRSTUVXYZ";
    int LargoCadena=0;
    string Nacimiento, Folio, NumeroFinal;
    bool TodosNumeros=true;
    cout<<"Ingrese el nuermo de identidad de la forma xxxx-xxxx-xxxxx"<<endl;
    cin.getline(NumeroDeIdentidad,16);
    LargoCadena= strlen(NumeroDeIdentidad);
    for(int N=0; N < LargoCadena; N++){
        NumeroFinal += NumeroDeIdentidad[N];
    }
    for(int i=0; i<LargoCadena; i++)
    {
        for(int j=0; j<27; j++)
        {
            if(NumeroDeIdentidad[i]==LetrasMayusculas[j] || NumeroDeIdentidad[i]==LetrasMinusculas[j] )
            {
                TodosNumeros=false;
                return 0;
            }
        }

    }
    if(LargoCadena ==15 || TodosNumeros==true)
    {
        cout<<"Ingresado la cadena adecuada"<<endl;
        for(int D=0; D<4; D++)
        {
            Departamento[D]=NumeroDeIdentidad[D];
        }
        //comprobar si esta el departamento
        bool DentroDeLosDepartamentos = (Departamento[0]==Numeros[0]||Departamento[0]==Numeros[1]);
        if( DentroDeLosDepartamentos && Departamento[1]!=Numeros[9])
        {
            cout<<"Departamento encontrado"<<endl;
        }
        else
        {
            cout<<"No se ha encontrado el departamento, por lo tanto no se seguira el proceso"<<endl;
            return 0;
        }


        for(int A=0; A<4; A++)
        {
            Nacimiento+=NumeroDeIdentidad[A+5];
        }
        //comprobar el año de nacimiento
        bool Natalicio = (Nacimiento[0]==Numeros[1]||Nacimiento[0]==Numeros[2]);
        bool RangoCorrecto =(Nacimiento[1]==Numeros[9] || Nacimiento[1]==Numeros[9]);
        if( Natalicio && RangoCorrecto)
        {
            cout<<"Anio Correcto"<<endl;
        }
        else
        {
            cout<<"Se ha intrducido un año incorrecto, por lo tanto no se seguira el proceso"<<endl;
            return 0;
        }

        //Guradando el Folio
        for(int F=0; F<5; F++)
        {
            Folio+=NumeroDeIdentidad[F+10];
        }

        cout<<"\n La persona con el numero de Identidad: "<<NumeroFinal<<".\n Nacio en el Departamento "<<Departamento[0]<<Departamento[1]<<".\n En el municipio: "<<Departamento[2]<<Departamento[3]<<".\n En el anio: "<<Nacimiento<<".\n Su registro de nacimiento esta en el folio: "<<Folio<<endl;


    }
    else
    {
        cout<<"Ha ingresado una cantidad no permitida de caracteres"<<endl;
    }

    return 0;
}
