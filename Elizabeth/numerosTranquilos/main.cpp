#include <iostream>


using namespace std;
int factorial(int ultimoDigito);
int main()
{
    int numero = 0;
    cin>>numero;
    if(numero >99 && numero<1000)
    {

        int unidad = numero / 100;
        int decena = (numero % 100) / 10;
        int centena = (numero % 100) % 10;

        int multiplicacionDeDigitos = unidad * decena * centena;
        int numeroFactorial = factorial(centena);

        if(multiplicacionDeDigitos < numeroFactorial){
            cout<<"1"<<endl;
        }else{
            cout<<"0"<<endl;
        }
    }
    else
    {
        cout<<"0"<<endl;
    }
    return 0;
}

int factorial(int ultimoDigito)
{
    if(ultimoDigito < 0)
        return 0;
    else if(ultimoDigito > 1)
        return ultimoDigito*factorial(ultimoDigito-1);
    return 1;
}
