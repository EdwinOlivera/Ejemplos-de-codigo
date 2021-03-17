#include <iostream>

using namespace std;

int main()
{
    float k = 0, k2 = 0, s=0, d=0;
    cout << "Introduzca el valor de las millas:" << endl;
    cin>>k;
    cout << "Introduzca el valor de las millas:" << endl;
    cin>>k2;
    cout << "Introduzca el valor de los galones usados:" << endl;
    cin>>s;
    d = (k2-k)/s;
    cout<<"Los galones utilizados en este segmento del viaje son:"<<d<<" mpg"<<endl;

    return 0;
}
