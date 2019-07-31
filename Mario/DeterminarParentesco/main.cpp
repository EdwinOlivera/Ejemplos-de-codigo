#include <iostream>

using namespace std;

int main()
{
    //declarando los arreglos
    //int X[]={0,1,2,3,4,5,6,7,8,9};
    //int Y[]={0,1,2,3,4,5,6,7,8,9};

    //variables centinela
    int V=0;
    int N =1;

    //Definiendo el tamaño de los arreglos
    cout<< "Escribar de que tamaño desea los arreglos"<<endl;
    cin>>N;
    int X[N];
    int Y[N];

    //introduciendo valores a los arreglos
    for (int i=0; i < N; i++){
        cout<<"Ingrese el elemento #"<<(i+1)<< " del Primer Arreglo---------> ";
        cin>>X[i];
        cout<<"Ingrese el elemento #"<<(i+1)<< " del Segundo Arreglo--------> ";
        cin>>Y[i];
        cout<<endl;
    }

    //comparando los arreglos
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(X[i]== Y[j]){
                V+=1;
                break;
            }
        }
    }
    if (V==N){
        cout<<"Los Arreglos contienen los mismos elementos.";
    }else{
    cout<<"Los arreglos contienen elementos diferentes";
    }
    return 0;
}
