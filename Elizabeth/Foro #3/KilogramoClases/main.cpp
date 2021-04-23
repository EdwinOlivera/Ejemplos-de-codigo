#include <iostream>

using namespace std;

class KilogramoClass
{
public:
    KilogramoClass(float);
    ~KilogramoClass();
    void libras();
    void toneladas();

private:
    float KILOGRAMOS;
};

KilogramoClass::KilogramoClass(float _kilo)
{
    KILOGRAMOS = _kilo;
}

KilogramoClass::~KilogramoClass()
{
    cout<<"\nFin"<<endl;
}

void KilogramoClass::libras()
{
    cout<<"Conversion Kilogramo a libra: "<<KILOGRAMOS * (2.20462)<<" lb"<<endl;
}
void KilogramoClass::toneladas()
{
    cout<<"Conversion Kilogramo a toneladas: "<<KILOGRAMOS * (0.001)<<" Tn"<<endl;
}
int main()
{
    float kilo =0;
    cout<<"Ingrese el peso en Kilogramo (K >= 0)"<<endl;
    do
    {
        cin>>kilo;
    }
    while(kilo<0);
    cout<<endl;
    KilogramoClass objKilos = KilogramoClass(kilo);
    objKilos.libras();
    objKilos.toneladas();
    return 0;
}
