#include <iostream>
#include <cstring>
using namespace std;
void CompletarCadea(char []);
int main()
{
    char CadenaCompleta[30];
    cout<<"Ingrese la Cadena (espacio maximo de 30)"<<endl;
    cin.getline(CadenaCompleta,30);
    CompletarCadea(CadenaCompleta);
    cout << "Final del Programa" << endl;
    return 0;
}
void CompletarCadea (char Cadena[]){
    char Colocar[]="*";
    int LargoDeCadena=0;
    LargoDeCadena = strlen(Cadena);

    for(int i=LargoDeCadena; i<29;i++){
        Cadena[i]=Colocar[0];
    }
    cout<<"La cadena completada es: "<<Cadena<<endl;
}
