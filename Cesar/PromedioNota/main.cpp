#include <iostream>

using namespace std;

int main()
{
    int catindadParcipantes=0, indiceParticipante = 0;
    double promedioParticipante =0, sumaNotaParticipante = 0, promedioMayor;
    cout<<"Ingrese la cantidad de participantes"<<endl;
    do
    {

        cin>>catindadParcipantes;
        if(catindadParcipantes<=0)
        {
            cout<<"Ingrese una cantidad igual o mayor a 1"<<endl;
        }
    }
    while(catindadParcipantes <=0);

    double notaArreglo[catindadParcipantes][5], promedioArreglo[catindadParcipantes][1];
    for(int i =0; i<catindadParcipantes; i++)
    {
        cout<<"Notas del participante #"<<(1+i)<<": "<<endl;
        for(int j = 0; j<5; j++)
        {
            cout<<"Nota #"<<(1+j)<<" = ";
            cin>> notaArreglo[i][j];
        }
    }

    for(int i =0; i<catindadParcipantes; i++)
    {
        cout<<"Promedio del Participante #"<<(1+i)<<": "<<endl;
        promedioParticipante =0, sumaNotaParticipante = 0;
        for(int j = 0; j<5; j++)
        {
            sumaNotaParticipante += notaArreglo[i][j];
        }
        promedioParticipante = sumaNotaParticipante/5;

        promedioArreglo[i][0]= promedioParticipante;

        cout<<promedioParticipante<<endl;
    }

    promedioMayor = promedioArreglo[0][0];
    for(int i =0; i<catindadParcipantes; i++)
    {
        if(promedioMayor<promedioArreglo[i][0])
        {
            promedioMayor = promedioArreglo[i][0];
            indiceParticipante = i;
        }
    }
    cout<<"El promedio mayor es: "<<promedioMayor<<", del participante #"<<(indiceParticipante+1)<<endl;
    return 0;

}
