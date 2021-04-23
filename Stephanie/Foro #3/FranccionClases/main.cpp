#include <iostream>

using namespace std;

class Fraccion
{
public:
    Fraccion(int, int);
    ~Fraccion();
    void simplificar();
    void mixta();

private:
    int numA;
    int numB;
    int numAInitial;
    int numBInitial;
    float numN;
    int numR;
    int numS;
};
Fraccion::Fraccion(int _a, int _b)
{
    numA = _a;
    numB = _b;
    numAInitial = _a;
    numBInitial = _b;
}

Fraccion::~Fraccion()
{
    cout<<"\n calculos hechos correctamente"<<endl;
}
void Fraccion::simplificar()
{
    cout<<"\nSIMPLIFICAR FRACCION\n"<<endl;
    int  aumentoNumero = 2;
    cout<<"Fraccion original: "<<endl;
    cout<<numA<<"/"<<numB<<endl;

    if(numB==1)
    {
        cout <<numA<<"/"<<numB;
    }
    else
    {
        aumentoNumero=2;
        while(aumentoNumero<=numA)
        {
            if(numB%aumentoNumero==0 && numA%aumentoNumero==0)
            {
                numB=numB/aumentoNumero;
                numA=numA/aumentoNumero;
            }
            else
            {
                aumentoNumero++;
            }
        }

    }

    cout<<"Fraccion simplificada: "<<endl;
    cout<<numA<<"/"<<numB<<endl;
}

void Fraccion::mixta()
{
    if(numAInitial<numBInitial)
    {
        numA = numAInitial;
        numB = numBInitial;
        cout<<"\nCREAR FRACCION MIXTA\n"<<endl;
        cout<<"Fraccion original: "<<endl;
        cout<<numA<<"/"<<numB<<endl;
        numN = numA/numB;
        numR = (numA%numB);
        numS = numB;
        cout<<"Fraccion Mixta: "<<endl;
        cout<<numN<<" * "<<numR<<"/"<<numS<<endl;
    }
    else
    {
        cout<<"No se puede mostrar la fraccion mixta"<<endl;
    }
}
int main()
{
    int numeroA, numeroB;
    cout<<"Ingrese el numero A: ";
    cin>>numeroA;
    cout<<"Ingrese el numero B: ";
    cin>>numeroB;

    Fraccion fra(numeroA,numeroB);

    fra.simplificar();
    fra.mixta();
    return 0;
}
