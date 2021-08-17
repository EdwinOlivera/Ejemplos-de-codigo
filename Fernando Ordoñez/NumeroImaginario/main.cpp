#include <iostream>

using namespace std;
class NumeroComplejos
{
public:
    float parteReal;
    float parteImaginaria;
    float segundo;
    NumeroComplejos();
    ~NumeroComplejos();
    void escribirComplejo();
    void leerComplejo();

    float getParteReal();
    float getParteImaginaria();

    void setParteReal(float _parteReal);
    void setParteImaginaria(float _parteReal);
};

NumeroComplejos::NumeroComplejos()
{
    parteReal = 0;
    parteImaginaria = 0;
}

float NumeroComplejos::getParteReal()
{
    return parteReal;
}
float NumeroComplejos::getParteImaginaria()
{
    return parteImaginaria;
}

void NumeroComplejos::setParteReal(float _parteReal)
{
    parteReal = _parteReal;
}
void NumeroComplejos::setParteImaginaria(float _parteReal)
{
    parteImaginaria = _parteReal;
}

void NumeroComplejos::escribirComplejo()
{
    cout<<"El numero complejo creado es: "<<endl;
    cout<<"("<<parteReal<<" + "<<parteImaginaria<<"i)"<<endl;
}

void NumeroComplejos::leerComplejo()
{
    cout << "Ingresa la parte real del numero complejo:" << endl;
    cin >> parteReal;
    cout << "Ingresa la parte imaginaria del numero complejo" << endl;
    cin >> parteImaginaria;
}
NumeroComplejos::~NumeroComplejos()
{
}
int main()
{

    cout << "NUMERO COMPLEJO" << endl;

    NumeroComplejos objNumeroComplejo;

    cout << "\n<----------------------------->\n";

    objNumeroComplejo.leerComplejo();
    objNumeroComplejo.escribirComplejo();

    return 0;
}
