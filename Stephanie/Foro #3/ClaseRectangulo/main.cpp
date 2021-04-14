#include <iostream>
#include<cmath>

using namespace std;

class Rectangulo
{

private:
    float BASE, ALTURA;

public:
    Rectangulo(float, float);
    void Desplegar(char *letra);
    void area();
    ~Rectangulo();

};
Rectangulo::Rectangulo(float _base, float _altura )
{
    BASE = _base;
    ALTURA = _altura;
}
void Rectangulo::Desplegar(char *letra)
{
    cout<<"El rectangulo es: "<<endl;
    int i = 0, j=0;

    for(i=0; i<BASE; i++)
    {
        cout<<letra;
    }
    cout<<endl;
    for(i=0; i<ALTURA-1; i++)
    {
        for(j=0; j<=BASE; j++)
        {
            if(j==0 || j == BASE-1)
            {
                cout<<letra;
            }
            else
            {
                if(j < BASE-1 && i == ALTURA-2 && j >0)
                {
                    cout<<letra;
                }
                else
                {
                    cout<<" ";

                }
            }

        }
        cout<<endl;
    }

    cout<<endl;
}

void Rectangulo::area()
{
    cout<<"El area es: "<<BASE * ALTURA<<endl;
}

Rectangulo::~Rectangulo()
{
    cout<<"Saliendo."<<endl;
}

int main()
{
    float baseRectangulo=0, alturaRectangulo=0;

    do
    {

        cout<<"Base del Rectangulo: "<<endl;
        cin>>baseRectangulo;
        cout<<"Altura del Rectangulo: "<<endl;
        cin>>alturaRectangulo;

        if(baseRectangulo==alturaRectangulo)
        {
            cout<<"La ALTURA y la BASE tienen que ser diferentes. ALTURA != BASE\n"<<endl;
        }
    }
    while(baseRectangulo==alturaRectangulo);
    Rectangulo cir = Rectangulo(baseRectangulo, alturaRectangulo);
    cir.Desplegar("c");
    cir.area();
    return 0;
}
