#include <iostream>

using namespace std;

bool ComprobarNumero(int );
int main()
{
    int numeroIngresado = 0;
    int cantidadPrimos =0, cantidadCompuestos = 0, numeroAcomprobar = 0;


    cout<<"Ingrse un numero cualquiera "<<endl;
    cin>>numeroIngresado;

    do
    {

        numeroAcomprobar  = numeroIngresado%10;
        if(numeroAcomprobar!=1){


        if(ComprobarNumero(numeroAcomprobar))
        {
            cantidadPrimos++;
        }
        else
        {
            cantidadCompuestos++;
        }
        }
        numeroIngresado = numeroIngresado/10;
    }
    while(numeroIngresado>0);
    cout<<"\nLa cantidad de numeros Primos es :"<<cantidadPrimos<<endl;
    cout<<"\nLa cantidad de numeros Compuestos es :"<<cantidadCompuestos<<endl;

    cout<< "\n           Fin del Programa" <<endl;
    return 0;
}
//Retorna TRUE si el numero es primo, y FALSE en caso contrario
bool ComprobarNumero(int numeroDelUsuario)
{


    int NumeroAEvaluar = numeroDelUsuario%10, copiaDeNumero = numeroDelUsuario;
    int numerosEncotrados = 0, siguienteNumero = 0;
    bool ValorDeRetorno = false;


        siguienteNumero = 1;
        do{
            if(copiaDeNumero%siguienteNumero == 0){
                numerosEncotrados++;
            }
            siguienteNumero++;
        }while(siguienteNumero<= copiaDeNumero);

        if(numerosEncotrados == 2){
            ValorDeRetorno = true;
        }else {
        ValorDeRetorno = false;
        }


    return ValorDeRetorno ;
}
