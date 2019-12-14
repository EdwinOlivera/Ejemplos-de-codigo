#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;

int main()
{
    srand(time(NULL));
    double ArregloPrincipal[100], tamanioDeVector = 0;
    int opcion = 0, cerosEncontrados = 0;
    bool comprobarVector = false;

    cout<<"Ingrese el tamanio del Vector ->";
    cin>>tamanioDeVector;
    do
    {
        cout<<"\n 1 = Vector aleatorio \n 2 = Vector manual"<<endl;
        cout<<"Ingrese su opcion -> ";
        cin>>opcion;
        switch(opcion)
        {
        case 1:
            for(int i = 0; i < tamanioDeVector; i++)
            {
                ArregloPrincipal[i] = rand()%2;
            }
            break;
        case 2:
            for(int i = 0; i < tamanioDeVector; i++){
                cout<<"Ingrese el elemento ["<<(i+1)<<"] ->";
                cin>>ArregloPrincipal[i];
            }
            break;
        default:
            cout<<"Opcion no valida. Intente de nuevo\n"<<endl;
            break;

        }

    }
    while(opcion< 1 || opcion> 2);

    cout<<"\nEl vector creado es "<<endl;
    cout<<"[ ";
    for(int i = 0; i<tamanioDeVector; i++)
    {
        cout<<ArregloPrincipal[i]<<" ";
    }
    cout<<"]"<<endl;

    for(int i = 0; i < tamanioDeVector; i++){
        if(ArregloPrincipal[i] == 0){
            cerosEncontrados++;
        }
    }
    cout<<endl;
    cout<<"El resultado muestra que = "<<endl;
    cout<<endl;
    if(cerosEncontrados == tamanioDeVector){
        cout<<"El vector es un Vector Nulo"<<endl;
    }else {
        cout<<"No es un Vector Nulo"<<endl;
        for(int i = 0; i<tamanioDeVector; i++){
            if(ArregloPrincipal[i] !=0){
                cout<<"Hay un elemento no Cero (o) en la posicion ("<<(i+1)<<") -> "<<ArregloPrincipal[i]<<endl;
            }
        }
        cout<<"Tiene "<<(tamanioDeVector-cerosEncontrados)<<" de elementos no Cero (0)"<<endl;
    }


    return 0;
}
