#include <iostream>

using namespace std;


int main()
{
    string oracionPrincipal = "";
    cin>>oracionPrincipal;
    int cantidadLetras = 0, cantidadNumeros = 0;
    for(int i = 0; i<oracionPrincipal.length(); i++)
    {
        if(*oracionPrincipal[i]  == "1")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "2")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "3")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "4")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "5")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "6")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "7")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }

        if(oracionPrincipal[i]  == "8")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "9")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }
        if(oracionPrincipal[i]  == "0")
        {
            cantidadNumeros++;
        }
        else
        {
            cantidadLetras++;
        }

    }
    cout<<"Cantidad de letras: "<<cantidadLetras<<endl;
    cout<<"Cantidad de numeros: "<<cantidadNumeros<<endl;
}
