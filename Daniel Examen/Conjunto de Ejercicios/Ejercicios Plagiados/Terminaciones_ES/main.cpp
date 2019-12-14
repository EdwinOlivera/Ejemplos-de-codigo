#include <iostream>
#include <cstring>
using namespace std;
void BuscarTerminacionES(char [], char []);
int main()
{
    int EspaciosDeChar=500;
    char OracionCompleta[EspaciosDeChar], PalabrasRecopiladas[EspaciosDeChar];
    cout<<"Ingrese la oracion o frase a la cual le desea encontrar las palabras con terminacion \"ES\""<<endl;
    cin.getline(OracionCompleta, EspaciosDeChar);
    BuscarTerminacionES(OracionCompleta, PalabrasRecopiladas);
    return 0;
}

void BuscarTerminacionES(char OracionPrincipal[], char PalabrasEs[])
{
    int TamagnoDeLaOracion= 0;
    TamagnoDeLaOracion = strlen(OracionPrincipal);
    bool TerminacionES=false, EncotraraUnaPalabra = false;
    int EspaciosRecorridos = 0, Espacios=0, EspaciosCrecientes=0, DiferenciasEntrePalabras=0, ConteoDeLetras=0;
    for(int i=0; i< TamagnoDeLaOracion; i++)
    {
        EspaciosRecorridos = i+1;
        ConteoDeLetras++;
        if(OracionPrincipal[i]==' '){
            ConteoDeLetras=0;
        }
        TerminacionES = (OracionPrincipal[i]=='e' && OracionPrincipal[i+1]=='s') || (OracionPrincipal[i]=='E' && OracionPrincipal[i+1]=='S');
        if(TerminacionES)
        {
            EncotraraUnaPalabra = true;
            Espacios=EspaciosRecorridos;
            DiferenciasEntrePalabras= Espacios-ConteoDeLetras;
            for(int j=DiferenciasEntrePalabras; j<Espacios+1; j++)
            {
                PalabrasEs[EspaciosCrecientes] =OracionPrincipal[Espacios - ConteoDeLetras];
                if(ConteoDeLetras <= 0 && EspaciosRecorridos != TamagnoDeLaOracion-1){
                    EspaciosCrecientes++;
                    PalabrasEs[EspaciosCrecientes] =',';
                }else if(ConteoDeLetras <= 0 && EspaciosRecorridos == TamagnoDeLaOracion-1){
                    EspaciosCrecientes++;
                    PalabrasEs[EspaciosCrecientes] =' ';
                }
                ConteoDeLetras--;
                EspaciosCrecientes++;
            }
        }
    }
    if(EncotraraUnaPalabra){
        cout<<"Las palabras con terminacion ES son: "<<PalabrasEs<<endl;
    }else {
    cout<<"En esta oracion no hay ningua palabra con Terminacion \"ES\""<<endl;
    }


}
