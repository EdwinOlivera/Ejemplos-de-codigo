#include <iostream>

using namespace std;

int main()
{
    float elementoX = 0, elementoY = 0, OperacionMatematica = 0;
    int opcion = 0;
    do
    {
        cout<<"\nEscriba el primer numero: "<<endl;
        cin>>elementoX;

        cout<<"Escriba el segundo numero: "<<endl;
        cin>>elementoY;

        cout<<"Escoja una opcion"<<endl;
        cout<<"\n 1 = Sumanr \n 2 = Restar \n 3 = Multiplicar \n 4 = Dividir \n 0 = Terminar"<<endl;
        cin>>opcion;

        switch(opcion)
        {
        case 1:
            OperacionMatematica = elementoX + elementoY;
            break;
        case 2:
            OperacionMatematica = elementoX - elementoY;
            break;
        case 3:
            OperacionMatematica = elementoX * elementoY;
            break;
        case 4:
            if(elementoY == 0){
                cout<<"La division no se puede realizar."<<endl;
            }else{
            OperacionMatematica = elementoX / elementoY;
            }

            break;
        default:
            cout<<"Opcion invalida"<<endl;
            break;
        }
        if(opcion >= 1 && opcion <= 4 && elementoY !=0){
            cout<<"El resultado es: " <<OperacionMatematica<<"\n"<<endl;
        }
    }
    while(opcion != 0);
    cout << "       Fin del Programa" << endl;
    return 0;
}
