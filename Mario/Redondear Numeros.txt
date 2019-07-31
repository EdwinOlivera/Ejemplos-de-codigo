#include <iostream>

using namespace std;

int main()
{
    int numA,numB,numC,numD;
    char CnumA[0];
    char CnumB;
    char CnumC;
    char CnumD;
    cout<<"Ingrese los cuatro numeros(solo son validos valores numericos enteros)"<<endl;

    cout<<"Ingrese el valor de A"<<endl;
    do{
    cin>>numA;
    if(numA<0 || numA>9){
        cout<<"Ha ingresado un numero fuera de rango. Solo puede ingresar numeros entre 0 y 9"<<endl;
        cout<<"Vuelva a ingresar estes numero de nuevo"<<endl;
    }
    }while(numA<0 || numA>9);
    cout<<"Ingrese el valor de B"<<endl;
    do{
    cin>>numB;
    if(numB<0 || numB>9){
        cout<<"Ha ingresado un numero fuera de rango. Solo puede ingresar numeros entre 0 y 9"<<endl;
        cout<<"Vuelva a ingresar estes numero de nuevo"<<endl;
    }
    }while(numB<0 || numB>9);

    cout<<"Ingrese el valor de C"<<endl;
    do{
    cin>>numC;
    if(numC<0 || numC>9){
        cout<<"Ha ingresado un numero fuera de rango. Solo puede ingresar numeros entre 0 y 9"<<endl;
        cout<<"Vuelva a ingresar estes numero de nuevo"<<endl;
    }
    }while(numC<0 || numC>9);

    cout<<"Ingrese el valor de D"<<endl;
    do{
    cin>>numD;
    if(numD<0 || numD>9){
        cout<<"Ha ingresado un numero fuera de rango. Solo puede ingresar numeros entre 0 y 9"<<endl;
        cout<<"Vuelva a ingresar estes numero de nuevo"<<endl;
    }
    }while(numD<0 || numD>9);
    cout<<"El numero ingresado fue: "<<numA<<numB<<numC<<numD<<endl;
    if(numC>=5){
        if(numB==9){
            numA++;
            numB=0;
            numC=0;
            numD=0;
        }else{
        numB++;
        numC= 0;
        numD= 0;
        }
    }else {
       if(numC<5){
        numC=0;
        numD=0;

       }
    }
    cout<<"La centena mas proxima es: "<<numA<<numB<<numC<<numD<<endl;

    cout << "\nFin del Programa" << endl;
    return 0;
}
