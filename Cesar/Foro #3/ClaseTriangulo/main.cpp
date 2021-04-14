#include <iostream>
#include<cmath>
using namespace std;
class triangulo
{
public:
    triangulo(float, float, float);
    ~triangulo();
    void EsTipo();
    void Area();

private:
    float ladoA, ladoB, ladoC, areaTriangulo;

};
triangulo::triangulo(float La, float Lb, float Lc)
{
    ladoA = La;
    ladoB = Lb;
    ladoC = Lc;

}
void triangulo::EsTipo()
{
    if(ladoA == ladoB && ladoA == ladoC)
    {
        cout<<"El triangulo es Equilatero"<<endl;
    }
    else if(ladoA == ladoB || ladoA == ladoC || ladoB == ladoC )
    {
        cout<<"Triangulo es Isosceles"<<endl;
    }
    else
    {
        cout<<"El triangulo es Escaleno"<<endl;
    }
}
void triangulo::Area()
{
    float semiPerimetro = (ladoA + ladoB + ladoC)/2;
    float altura = (2/ladoA);
    altura = altura *(sqrt(semiPerimetro* (semiPerimetro - ladoA)*(semiPerimetro - ladoB) * (semiPerimetro - ladoC)));
    float area = altura*ladoA;
    area = area/2;
    cout<<"El area del triangulo es: "<<area<<endl;
}

triangulo::~triangulo()
{
    cout<<"\nFin del programa"<<endl;
}

int main()
{
    float LADOA, LADOB, LADOC;
    cout<<"Ingrese el primer lado"<<endl;
    cin>>LADOA;
    cout<<"Ingrese el segundo lado"<<endl;
    cin>>LADOB;
    cout<<"Ingrese el tercer lado"<<endl;
    cin>>LADOC;
    triangulo tri = triangulo(LADOA,LADOB,LADOC);

    tri.Area();

    tri.EsTipo();

    return 0;
}
