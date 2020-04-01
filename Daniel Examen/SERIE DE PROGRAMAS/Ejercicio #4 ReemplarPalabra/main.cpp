#include <iostream>

using namespace std;
void ReemplazarPalabra(string, string, string);
int main()
{

    //Dene ingresar la Cadena desde aca, para que tenga efecto el reemplazo
    string original = "Me voy a dormir, que todos sabemos que a partir de las 12 de la noche es hora de dormir.";
    string PalabraAbuscar = "dormir";
    string PalabraConLaCualReemplazar = "programar";
    cout << "Cadena original: "<<original<<endl;
    cout<<"Ingrese la Plabra a buscar"<<endl;
    cin>>PalabraAbuscar;
    cout<<"Ingrese la plabra con la cual quiere reemplazar"<<endl;
    cin>>PalabraConLaCualReemplazar;
    ReemplazarPalabra(original, PalabraAbuscar,PalabraConLaCualReemplazar);

    return 0;
}

void ReemplazarPalabra(string original, string PalabraAbuscar, string PalabraConLaCualReemplazar)
{
    string::size_type pos = 0;
    string CadenaCambiada;
    CadenaCambiada = original;
    while ((pos = original.find(PalabraAbuscar, pos)) < string::npos)
    {
        CadenaCambiada .replace(pos, PalabraAbuscar.length(), PalabraConLaCualReemplazar);
        pos+=PalabraConLaCualReemplazar.size();
    }

    if(original == CadenaCambiada)
    {
        cout<<"No se ha encontrado la palabra a buscar, por lo tanto no tendra cambio la candea original"<<endl;
    }
    else
    {
        cout << "Cadena resultante: "<<CadenaCambiada<<endl;
    }
}
