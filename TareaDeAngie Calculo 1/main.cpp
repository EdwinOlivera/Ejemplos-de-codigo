#include <iostream>
#include <math.h>

using namespace std;

int main()
{

    return 0;
}
 /* int N= 30;
    double X=0;
    float L=0;
    float A=0;
    double B=0;
    double C=0;
    double D=0;
    double K=0;
    double M=0;
    double F=0;

    cout << "Ingrese el numero del cual desea calcular el logaritmo natural"<<endl;
    cin >> X;

    for (int i=0; i < 30; i++){
        L = (2*i+1);
        A = 1/L;
        B = (pow(X,2)-1);
        C = (pow(X,2)+1);
        D = (2*i)+ 1;
        K = B/C;
        M = pow(K,D);
        F+=A*M;


    }
cout << F<<endl;

    float V[3];
    int temporal[3];
    int X[3];
    int Y[3];
    cout << "Hello world!" << endl;

    for (int i=0; i < 3; i++){
    cout<< "Ingrese los valores del #"<<(i+1)<<" Vertice"<<endl;
    cout<<endl;
    cout<< "Ingrese el valor de X"<<(i+1)<<endl;
    cin >> X[i];
    cout<< "Ingrese el valor de Y"<<(i+1)<<endl;
    cin >> Y[i];
    cout<<endl;
    }
    cout << "Los Valores ingresados son: "<<endl;
    for (int i=0; i < 3; i++){
        cout << "El vertice #"<<(i+1)<<" es: ( "<<X[i]<<", "<<Y[i]<<" )"<<endl;
        if (i==0){
            temporal[i] = pow((X[i+1] - X[i]),2) + pow((X[i+1] - Y[i]),2);
        }
        if (i==1){
            temporal[i] = pow((X[i+1] - X[i]),2) + pow((X[i+1] - Y[i]),2);
        }
        if (i==2){
            temporal[i] = pow((X[i-2] - X[i]),2) + pow((X[i-2] - Y[i]),2);
        }
    }

    for (int j=0; j <3; j++){
        V[j] = sqrt(temporal[j]);
    }
    cout<<endl;
    //comprobar si es un triangulo

    if (V[0]==V[1] || V[1] == V[2] || V[2] == V[0]){
        cout << "Se tiene un triangulo Isosceles"<<endl;
    }else{
            cout<< "Los vertices introducidos no corresponden a un triangulo isosceles"<<endl;
        }

*/

