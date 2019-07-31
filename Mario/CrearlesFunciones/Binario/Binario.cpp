#include <iostream>

using namespace std;
string CrearBinario(int, int);
int main ()
{
    int numero, dividendo, resto;

    cout<<"ingrese un numero"<<endl;
    cin>>dividendo;
    numero=dividendo;

    cout<<"en sistema bianrio "<<numero<<"   se escribe   "<<CrearBinario(numero, resto)<<endl;
    return 0;
}
string CrearBinario(int dividendo, int resto)
{
    string binario ="";
    while(dividendo>=2)
    {
        resto = dividendo%2;
        if(resto==1)
            binario ="1" + binario;
        else
            binario = "0" + binario;
        dividendo=dividendo/2;

    }
    if(dividendo==1)
        binario = "1" + binario;
    else
        binario = "0" + binario;

    return binario;
}
