#include <iostream>
#include <math.h>
using namespace std;
void Mersenne(int, int, int);
int main()
{//numero de Mersenne es M= 2^n - 1

    //variables
    int M=3;
    int N=0;
    int verificar;
    cout<<endl;
    cout<<"----------------------------------------------"<<endl;
    cout << "ingrese el numero del cual quiere saber su numero Mersenne"<<endl;
    cin >> M;
    Mersenne(M,N,verificar);
    cout<<"----------------------------------------------"<<endl;
    return 0;
}
    void Mersenne(int M, int N, int verificar){


    for (int i=0; i < M; i++){
        N = pow(2,i) - 1;
    }

    verificar = N%2;

    if(verificar != 0){
    cout<<endl;
    cout << "El #"<< M << " numero de Mersenne es numero Primo"<<endl;
    cout<<endl;
    cout<< "Y es: "<<N<<endl;
    }else {
      cout << "El 3"<< M << " numero de Mersenne es numero Par"<<endl;
    cout<<endl;
    cout<< "Y es: "<<N<<endl;
    }
 cout<<"----------------------------------------------"<<endl;
 cout<<endl;
    cout<< "Acontinuacion se enlistan los primeros 33 numero de Mersenne;contando desde cero (0), son: "<<endl;
    cout<<"----------------------------------------------"<<endl;
    cout<<"----------------------------------------------"<<endl;
    for (int i=0; i < 33; i++){
        N = pow(2,i) - 1;
        cout <<"# " << (i+1)<< ": 2^("<<i<<") - 1 = " << N<<endl;
    }
    cout<<"----------------------------------------------"<<endl;
    cout<<"----------------------------------------------"<<endl;
    }
