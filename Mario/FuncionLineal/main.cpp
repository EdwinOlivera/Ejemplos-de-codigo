#include <iostream>

using namespace std;

int main()
{
    float a, b, x, resultado, interceptoX, interceptoY, temporal;

    cout<<"Se calculara una funcion lineal del tipo f(x)= ax + b"<<endl;
    cout<<"Ingrese los valores de las constante a y b"<<endl;
    cout<<endl;

    cout<<"Ingrese el valor de a: "<<endl;
    cout<<"------> ";
    cin>>a;

    cout<<"Ingrese el valor de b: "<<endl;
    cout<<"------> ";
    cin>>b;
    cout<<endl;

    x= -b/a;
    interceptoX = x;
    interceptoY = b;
    temporal = (x*a);
    resultado = temporal + b;
    cout<<"El intercepto en X es: ("<<x<<", 0)"<<endl;
    cout<<"El intercepto en Y es: (0, "<<interceptoY <<")"<<endl;
    cout<<"La pendiente (m) de la funcion es: "<<a<<"."<<endl;
    cout<<"El valor de la funcion f(x)= ax + b, con los valores encontrados, es: "<<resultado<<endl;

    return 0;
}
