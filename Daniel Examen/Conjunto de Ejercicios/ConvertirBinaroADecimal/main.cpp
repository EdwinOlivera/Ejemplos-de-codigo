#include <iostream>
#include <cmath>
#include <string>
using namespace std;

bool ComprobarBinario(int);
int NumeroDeDigitos(int);
void ConvertirBinario(int, int, int, double);
int main()
{
    bool EsBinario = false;

    int exp,digito;
    int binario;
    double decimal;
    cout << "Introduce numero: ";
    cin >> binario;

    EsBinario = ComprobarBinario(binario);
    cout<<"El numero de digitos ingresados son: "<<NumeroDeDigitos(binario)<<endl;
    if(EsBinario)
    {
        cout<<"El numero ingresado si es Binario"<<endl;
        exp=0;
        decimal=0;
        ConvertirBinario(binario,exp, digito, decimal);


    }
    else
    {

        cout<<"El numero ingresado no es Binario"<<endl;
    }

}
//Funcion encargada de hacer la conversion
void ConvertirBinario(int binario,int exp, int digito, double decimal){
        while(((int)(binario/10))!=0)
        {
            digito = (int)binario % 10;
            decimal = decimal + digito * pow(2.0,exp);
            exp++;
            binario=(int)(binario/10);
        }
        decimal=decimal + binario * pow(2.0,exp);
        cout << endl << "Decimal: " << decimal << endl;
}


//Retorna el numero de digitos que ingreso el usuario
int NumeroDeDigitos(int NumeroUsuario){
    string NumeroCadea = to_string(NumeroUsuario);
    return NumeroCadea.size();
}

//Con esta funcion se verifica la si un numero es binario o no.
bool ComprobarBinario(int NumeroDelUsuario)
{

    bool Verifacion = true;

    string NumeroCadena = to_string(NumeroDelUsuario);

    if(NumeroCadena.size()>8)
    {
        Verifacion = false;
    }
    else
    {
        for(int i = 0; i<NumeroCadena.size(); i++)
        {
            if(NumeroCadena[i] != '0' && NumeroCadena[i] != '1')
            {
                Verifacion = false;
            }
        }
    }
    return Verifacion;
}
