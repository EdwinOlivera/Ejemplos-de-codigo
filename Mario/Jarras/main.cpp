#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;

int main()
{
    srand(time(NULL));
    //variables de seleccion
    int J, K;
    int pregunta=1;
    int cantidad = 0;
    //declarando los arreglos que contedran las jarras
    float azul[30];
    float rojo[30];

    for (int i=0; i < 30; i++){
        azul[i] = rand()%100 + 1;
        rojo[i] = rand()%100 + 1;
    }
    //mostrado la cantidad de agua que tienen las jarras
    cout<<"      La siguiente lista muestra la cantidad de agua (ml = militros) que continen cada jarra"<<endl;
    cout<<"     ********________________*********"<<endl;
    cout<<"   Jarras Azules                Jarras Rojas"<<endl;
    for (int i = 0; i < 30; i++){
    cout<<"  "<<(i+1)<<") "<<azul[i]<<" ml"<<"______________________"<<(i+1)<<") "<<rojo[i]<<" ml"<<endl;
    }
    //Seleccionar jarras a las cuales emparejar
    cout<<endl;
    cout<<"Seleccione cual de las jarras quiere emparejar para empezar a ajustar sus cantidades"<<endl;
    cout<<endl;
    do{

    cout<<"Seleccione la Jarra Azul que desea emparejar"<<endl;
    cin>> J;
    cout<<"La jarra azul que selecciono tiene "<< azul[J-1]<<" de liquido"<<endl;
    cout<<endl;
    cout<<"Seleccione la Jarra Roja que desea emparejar"<<endl;
    cin >> K;
    cout<<"La jarra Roja que selecciono tiene "<< rojo[K-1]<<" de liquido"<<endl;
    cout<<endl;
    if(azul[J-1] == rojo[K-1]){
            cout<<endl;
        cout<<">>>>>>>>>>>>>>>>>ERROR<<<<<<<<<<<<<<<<<<"<<endl;
        cout <<"**********************************"<<endl;
        cout<<"Ha seleccionado dos jarras (Azul y Roja) que tiene la misma cantidad de agua, debe escojer otras que tengas diferete cantidad de agua"<<endl;
        cout <<"**********************************"<<endl;
    }
    }while(azul[J-1] == rojo[K-1]);

    do{
        if (azul[J-1] < rojo[K-1]){
        cout<<"La jarra Roja tiene mas liquido que la jarra Azul. ¿Desea vertir agua en la jarra Azul de la jarra Roja?"<<endl;
        cout<< "1) Si\n 2) No"<<endl;
        cin>>pregunta;
        if (pregunta == 1){
                do{
            cout<<"La jarra Roja tiene "<<rojo[K-1]<<" de liquido ---///////////////////"<<endl;
            cout<<"La jarra Azul tiene "<<azul[J-1]<<" de liquido ---///////////////////"<<endl;
            cout<<"¿Cuanta cantidad quiere intercambiar entre las jarras? (de Roja a Azul)"<<endl;
            cin>>cantidad;
            rojo[K-1] -= cantidad;
            azul[J-1] += cantidad;
            if (azul[J-1] != rojo[K-1]){
                cout<<"las cantidades son diferentes entre las Jarras"<<endl;
            }
            }while(azul[J-1] != rojo[K-1]);
        }else{
        cout<<"No ha hecho ningun cambio"<<endl;
        }
        }
        if (azul[J-1] > rojo[K-1]){
                 cout<<"La jarra Azul tiene mas liquido que la jarra Roja. ¿Desea vertir agua en la jarra Roja de la jarra Azul?"<<endl;
        cout<< "1) Si\n 2) No"<<endl;
        cin>>pregunta;
        if (pregunta == 1){
                do{
            cout<<"La jarra Azul tiene "<<azul[J-1]<<" de liquido ---///////////////////"<<endl;
            cout<<"La jarra Roja tiene "<<rojo[K-1]<<" de liquido ---///////////////////"<<endl;
            cout<<"¿Cuanta cantidad quiere intercambiar entre las jarras? (de Azul a Roja)"<<endl;
            cin>>cantidad;
            azul[J-1] -= cantidad;
            rojo[K-1] += cantidad;
            if (rojo[K-1] != azul[J-1]){
                cout<<"las cantidades son diferentes entre las Jarras"<<endl;
            }
            }while(azul[J-1] != rojo[K-1]);
        }else{
        cout<<"No ha hecho ningun cambio"<<endl;
        }
        }
    }while(azul[J-1] != rojo[K-1]);
    return 0;
}
