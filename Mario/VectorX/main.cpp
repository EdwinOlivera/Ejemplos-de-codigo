#include <iostream>

using namespace std;

int main()
{
    int N=0, comprobarNumero, NumeroPar=0, NumeroImpar=0;
    int Xpar[N], Ximpar[N], VectorX[N];

    cout<<"Cuantos numero quierce agregarle al vector X"<<endl;
    cin>> N;

    Xpar[N]; Ximpar[N]; VectorX[N];//Reasignacion del tamaño de los arreglos
    for(int i=0; i < N; i++){
        cout<<"Ingrese el numero en la posicion ["<<(i+1)<<"]"<<endl;
        cin>>VectorX[i];
    }
    for(int j=0; j < N; j++){
        comprobarNumero = VectorX[j]%2;
        if(comprobarNumero==0){
                Xpar[NumeroPar]=VectorX[j];
                NumeroPar+=1;
        }
        if(comprobarNumero!=0){
        Ximpar[NumeroImpar]=VectorX[j];
        NumeroImpar+=1;
        }

    }


    cout<<"El Vector X Original es: [";
    for(int m=0; m < N; m++){
        cout<<" "<<VectorX[m];
    }
    cout<<"]"<<endl;

    cout<<"El Vector X de pares es: [";
    for(int m=0; m < NumeroPar; m++){
        cout<<" "<<Xpar[m];
    }
    cout<<"]"<<endl;

    cout<<"El Vector X de impares es: [";
    for(int m=0; m < NumeroImpar; m++){
        cout<<" "<<Ximpar[m];
    }
    cout<<"]"<<endl;

    return 0;
}
