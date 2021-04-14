#include <iostream>

using namespace std;
class EcuacionLineal
{
private:
    int a,b,c,d;
public:
    EcuacionLineal(float, float, float, float);
    ~EcuacionLineal();
    void resolver();
    void ComoInecuacion();
};

EcuacionLineal::EcuacionLineal(float _a,float _b, float _c,float _d)
{
    a = _a;
    b = _b;
    c = _c;
    d = _d;

}
EcuacionLineal::~EcuacionLineal()
{

}

void EcuacionLineal::resolver()
{
    float x=0;
    x = (d-b);
    x = x/(a-c);
    cout<<"La solucion de la ecuacion "<<a<<"x + "<<b<<" = "<<c<<"x + "<<d<<" es: x = "<<x<<endl;
}

void EcuacionLineal::ComoInecuacion()
{
    float m = 0;
    m = ( d-b);
    m = m /(a-c);
    cout<<"La solucion de la inecuacion  "<<a<<"x +"<<b<<" > "<<c<<"x +"<<d <<" es: x > "<<m<<endl;
}
int main()
{
    float elementA, elementB, elementC, elementD;
    cout<<"Ingrse el el emento A:";
    cin>>elementA;
    cout<<"Ingrse el el emento B:";
    cin>>elementB;
    cout<<"Ingrse el el emento C (C!=A):";
    do
    {
        cin>>elementC;
    }
    while(elementA==elementC);
    cout<<"Ingrse el el emento D:";
    cin>>elementD;

    cout<<"Valores a evualuar: a = "<<elementA<<", b = "<<elementB<<", c = "<<elementC<<", d = "<<elementD<<endl;
    cout<<endl;

    EcuacionLineal ecuacion = EcuacionLineal(elementA,elementB,elementC,elementD);

    ecuacion.resolver();
    ecuacion.ComoInecuacion();
    return 0;
}
