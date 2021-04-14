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
    void diametro();

private:
    float RADIO;
    float pi = 3.14159;

};
Circulo::Circulo(float _radio )
{
    RADIO = _radio;
}
void Circulo::perimetro()
{
    cout<<"El perimetro del ciruclo es: "<<2 * RADIO * pi<<" U"<<endl;
}

void Circulo::area()
{
    cout<<"El area del ciruclo es: "<<pi * pow(RADIO,2)<<" U" <<endl;
}
void Circulo::diametro()
{
    cout<<"El diametro es: "<< (RADIO* 2) <<" U"<<endl;
}
Circulo::~Circulo()
{
    cout<<"\nFin del sistema"<<endl;
}

int main()
{
    float radio;
    cout<<"RADIO (r) del circulo (mayor a 0): "<<endl;
    do
    {
        cin>>radio;
        if(radio<=0)
        {
            cout<<"Radio no permitido"<<endl;
        }
    }
    while(radio<=0);

    Circulo cir = Circulo(radio);
    cir.perimetro();
    cir.area();
    cir.diametro();
    return 0;
}
