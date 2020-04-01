#include <iostream>
#include <cstring>
using namespace std;
void ContarPalabras(string, string, string);
int main()
{

    //Dene ingresar la Cadena desde aca, para que tenga efecto el reemplazo
    char originalCadena[500];
    string original, PalabraAbuscar;
    char cPalabraAbuscar[500];
    string PalabraConLaCualReemplazar = "programar";


    cout<<"Ingrese una cadena"<<endl;
    cin.getline(originalCadena,500);
    cout<<"Ingrese la Plabra a buscar"<<endl;
    cin.getline(cPalabraAbuscar,500);

    int Caracteres = strlen(originalCadena);

    for(int i=0; i<Caracteres;i++){
        original += originalCadena[i];
    }
    int CaracteresABuscar = strlen(cPalabraAbuscar);

    for(int j=0; j<CaracteresABuscar; j++){
        PalabraAbuscar = cPalabraAbuscar[j];
    }
    PalabraConLaCualReemplazar =PalabraAbuscar;
    ContarPalabras(original, PalabraAbuscar,PalabraConLaCualReemplazar);

    return 0;
}

void ContarPalabras(string original, string PalabraAbuscar, string PalabraConLaCualReemplazar)
{
    int VecesEncotradas=0;
    string::size_type pos = 0;
    string CadenaCambiada;
    CadenaCambiada = original;
    while ((pos = original.find(PalabraAbuscar, pos)) < string::npos)
    {
        VecesEncotradas++;
        CadenaCambiada .replace(pos, PalabraAbuscar.length(), PalabraConLaCualReemplazar);
        pos+=PalabraConLaCualReemplazar.size();
    }

    cout<<"Veces que se encontro la palabra: "<<VecesEncotradas<<endl;
}
