#include <iostream>
#include <math.h>
using namespace std;
class Complejo
{
public:
    Complejo(float, float);
    ~Complejo();
    void modulo();
    void conjugado();
private:
    float reales;
    float numImaginario;
};
Complejo::Complejo(float _reales, float _numImaginario)
{

    reales = _reales;
    numImaginario = _numImaginario;
}


void Complejo::modulo()
{

}
Complejo::conjugado()
{
}
int main()
{
    float numeroComplejo =0, numeroReal = 0;
    cout<<"Ingrese la parte Compleja del numero: ";
    cin>>numeroComplejo;
    cout<<"Ingrese la parte Real del numero: ";
    cin>>numeroReal;

    cout << "Fin del programa" << endl;
    return 0;
}
