#include <iostream>
#include<cmath>

using namespace std;

class Rectangulo
{
public:
    Rectangulo(float _base, float _altura);
    ~Rectangulo();
    void desplegarEnPantalla(char *letra);
    void area();
    void perimetro();

private:
    float BASE, ALTURA;

};
Rectangulo::Rectangulo(float _base, float _altura )
{
    BASE = _base;
    ALTURA = _altura;
}
void Rectangulo::desplegarEnPantalla(char *letra)
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

void Rectangulo::perimetro()
{
    cout<<"El perimetro es: "<<(BASE *2)+ (ALTURA*2)<<endl;
}

Rectangulo::~Rectangulo()
{
    cout<<"\n>>>>>>>Calculo hechos.<<<<<<<"<<endl;
}

int main()
{
    float baseRectangulo=0, alturaRectangulo=0;
    char letra;

    do
    {
        cout<<"Base del Rectangulo (mayor a 2): "<<endl;
        do
        {
            cin>>baseRectangulo;

        }
        while(baseRectangulo<=2);
        cout<<"Altura del Rectangulo (mayor a 2): "<<endl;
        do
        {
            cin>>alturaRectangulo;
        }
        while(alturaRectangulo<=2);

        if(baseRectangulo==alturaRectangulo)
        {
            cout<<"La ALTURA y la BASE tienen que ser diferentes. ALTURA != BASE\n"<<endl;
        }
    }
    while(baseRectangulo == alturaRectangulo);
    Rectangulo cir = Rectangulo(baseRectangulo, alturaRectangulo);
    cout<<"Ingrese la letra que se usara para formar la figura"<<endl;
    cin>>letra;
    cir.desplegarEnPantalla(&letra);
    cir.area();
    cir.perimetro();
    return 0;
}
