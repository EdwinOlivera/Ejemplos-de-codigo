#include <iostream>
#include <cstring>
using namespace std;
bool ComprobarAnagrama(string, string, int, int);

int main()
{
    bool Verificar=false;
    string Frase1="", Frase2="";
    int CantidadLetras1=0, CantidadLetras2=0;
    char Oracion1[500], Oracion2[500];

    cout<<"\nEscriba la PRIMERA Palabra"<<endl;
    cin.getline(Oracion1,500);
    int temporal = strlen(Oracion1);
    for(int i=0; i<temporal; i++)
    {
        if(Oracion1[i]!=' ')
        {
            Frase1 += Oracion1[i];
        }
    }

    cout<<"\nEscriba la SEGUNDA Palabra"<<endl;
    cin.getline(Oracion2,500);
    temporal = strlen(Oracion2);
    for(int i=0; i<temporal; i++)
    {
        if(Oracion2[i]!=' ')
        {
            Frase2 += Oracion2[i];
        }

    }
    if(Frase1.size()<=1)
    {
        cout<<"Ha introducido solo una letra, no se hara la comprobacion"<<endl;
    }
    else
    {
        Verificar= ComprobarAnagrama(Frase1, Frase2, CantidadLetras1, CantidadLetras2);

        if(Verificar)
        {
            cout<<"Si son un anamgrama las dos cadenas"<<endl;
        }
        else
        {
            cout<<"No son un Anagrama las cadenas"<<endl;
        }
    }
    return 0;
}

bool ComprobarAnagrama(string Cadena1, string Cadena2, int LetrasCadena1, int LetrasEncontradas)
{
    LetrasCadena1 = Cadena1.size();
    string EspacioEnBlanco=" ";
    int espaciosEnBlancos1=0, espaciosEnBlancos2=0;

    for(int j=0; j< LetrasCadena1; j++)
    {
        Cadena1 = towlower(Cadena1[j]);
        for(int i=0; i < Cadena2.size(); i++)
        {
            Cadena2 = towlower(Cadena2[i]);
            if(Cadena1[j]==Cadena2[i])
            {

                LetrasEncontradas++;
                break;
            }
        }
    }

    if(LetrasCadena1== LetrasEncontradas)
    {
        return true;
    }
    else
    {
        return false;
    }

}
