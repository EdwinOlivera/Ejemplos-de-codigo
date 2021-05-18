#include <iostream>

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
    area();
    perimetro();
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
class recta
{

public:

    recta (float, float, float, float); //constructor

    ~recta ();//destructor

    void Ecuacion();
private:

    float x1, x2, y1, y2,m,b;

    void CalPendiente();//utilitarias

    void CalIntercepto();
};

recta ::recta (float a1, float a2, float b1, float b2)
{

    x1 = a1;

    y1 = a2;

    x2 = b1;

    y2 = b2;

    CalPendiente();
    CalIntercepto();

}

recta ::~recta ()

{

    std::cout << "fin de la recta";

    std::cout << std::endl;

}



void recta::Ecuacion()

{

    std::cout << "y=" << m << "x+(" << b << ")";

    std::cout << std::endl;

}

void recta::CalPendiente()
{
    m = (y2 - y1) / (x2 - x1);
}
void recta::CalIntercepto()

{

    b = -1 * x1 * m + y1;

}
int main()
{

    recta l1(1, 3, 5, 6),l2(1,1,2,2),l3(-2,5,8,12);
    Rectangulo rect = Rectangulo(2,3);
    l1.Ecuacion();

    l2.Ecuacion();

    l3.Ecuacion();



    return 0;



}
