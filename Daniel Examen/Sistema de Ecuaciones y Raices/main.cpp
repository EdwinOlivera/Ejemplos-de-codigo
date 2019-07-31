#include <iostream>

using namespace std;

void EcuacionRecta();
void RaicesPlinomicas();
int main()
{
    int opcion=0;
    string MensajeDeError;

    do
    {
        cout<<"***Menu****"<<endl;
        cout<<"\nEscoja una opcion (solo numeros)\n"<<endl;
        cout<<"1 = Ecuacion de La Recta\n"<<endl;
        cout<<"2 = Raices de polinomio cuadratico\n"<<endl;
        cout<<"-1 = para salir\n"<<endl;

        opcion=2;
        //cin>>opcion;
        switch(opcion)
        {
        case 1:
            cout<<"Opcion 1 Seleccionada"<<endl;
            EcuacionRecta();

            break;
        case 2:
            cout<<"Opcion 2 Seleccionada"<<endl;
            RaicesPlinomicas();
            break;
        case -1:
            cout<<"Ha salido exitosamente"<<endl;
            break;

        default:
            cout<<"<<<<< Ha ingresado una opcion invalidad. Intente de Nuevo >>>>>\n"<<endl;
            break;

        }
        opcion=-1;
    }
    while(opcion!= -1);




    cout << "************Fin del Programa*************" << endl;

    return 0;
}
void RaicesPlinomicas()
{

}
void EcuacionRecta()
{
    float X1, X2, Y1, Y2, M;
    cout<<"Se ha accedido a la Funcion de Creacion de Recta"<<endl;

    cout<<"Ingrese la Primera coordenada (x,y)"<<endl;

    cout<<"x =";
    cin>>X1;
    cout<<"Y =";
    cin>>Y1;

    cout<<"La coordenada ingresada es: (" << X1<<","<<Y1<<")\n"<<endl;
    cout<<"Ingrese la Segunda coordenada (x,y)"<<endl;

    cout<<"x =";
    cin>>X2;
    cout<<"Y =";
    cin>>Y2;
    cout<<"La coordenada ingresada es: (" << X2<<","<<Y2<<")\n"<<endl;

    if(X1 == X2)
    {
        cout<<"La pendiente es vertical, por lo tanto No se tendra la ecuacion de la recta"<<endl;
    }
    else
    {
        M = (Y2-Y1)/(X2-X1);

        if(M<0)
        {
            cout<<"La ecuacion formada es: Y= "<<M<<"X + "<<(-1*(M*X1))+Y1<<endl;
        }
        else
        {
            cout<<"La ecuacion formada es: Y= "<<M<<"X "<<(-1*(M*X1))+Y1<<endl;
        }

    }
}
