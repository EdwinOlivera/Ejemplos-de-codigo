#include <iostream>

using namespace std;
void HacerPromedio(float Arreglo[], int N, float Promedio, float Sumatoria);
int main()
{
    float Arreglo1[100];
    int N;
    float Promedio,Sumatoria;
    cout<<"Ingrese la cantidad de numeros que desea saber el promedio"<<endl;
    cin>>N;
    HacerPromedio(Arreglo1,N, Promedio, Sumatoria);
    return 0;
}

    void HacerPromedio(float Arreglo[], int N, float Promedio, float Sumatoria){

    for(int i=0; i < N; i++)
    {
        cout<<"Ingrese el numero en la posicion ["<<(i+1)<<"]"<<endl;
        cin>>Arreglo[i];
    }

    for(int j=0; j<N; j++)
    {
        Sumatoria += Arreglo[j];
    }
    if(N!=0)
    {
        Promedio = Sumatoria/N;
    }
    else
    {
        cout<<"No se sacara el promedio porque hay numeros en el arreglo"<<endl;
    }

    cout<<"El promedio de los numeros ingresado es: "<<Promedio<<endl;
    cout<<"Del arreglo con los numeros"<<endl;
    cout<<"[";
    for(int k=0; k<N; k++)
    {
        if(k==N-1)
        {
            cout<<Arreglo[k]<<"]";
        }
        else
        {
            cout<<Arreglo[k]<<", ";
        }
    }
    }

