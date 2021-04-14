#include <iostream>
#include<cmath>

using namespace std;

class Circulo
{
public:
    Circulo(float);
    ~Circulo();
    void perimetro();
    void area();

private:
    float RADIO;

};
Circulo::Circulo(float _radio )
{
    RADIO = _radio;
}
void Circulo::perimetro()
{
    cout<<"El perimetro del ciruclo es: "<<2 * RADIO *(3.141592653589793)<<endl;
}

void Circulo::area()
{
    cout<<"El area del ciruclo es: "<<(3.141592653589793)* pow(RADIO,2) <<endl;
}

Circulo::~Circulo()
{
    cout<<"Destructor ejecutado. Saliendo del programa"<<endl;
}

int main()
{
    float radioIngresado;
    cout<<"RADIO del circulo: "<<endl;
    cin>>radioIngresado;

    Circulo cir(radioIngresado);
    cir.perimetro();
    cir.area();
    return 0;
}
