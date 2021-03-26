#include <iostream>
#include <chrono>

#include <random>

#include <iomanip>

using namespace std;

std::random_device rd;

std::mt19937 gen(rd());

std::uniform_int_distribution<> distrib(10, 110);

#define punterArreglo unsigned short
#define dimensionArreglo unsigned short

#define alea distrib(gen)

void llenar(punterArreglo*,dimensionArreglo );

void desplegar(punterArreglo*,dimensionArreglo );

void desplegarMultiplos(punterArreglo*,dimensionArreglo );


int main()
{
    unsigned short dimensionTotal;
    std::cout<<"Ingrese la dimension del arreglo ";
    std::cin>>dimensionTotal;

    punterArreglo x[dimensionTotal] = {};
    punterArreglo* ptrx = &x[0];
    llenar(ptrx, dimensionTotal);
    desplegar(ptrx, dimensionTotal);
    desplegarMultiplos(ptrx, dimensionTotal);
    return 0;
}

void llenar(punterArreglo* pa, dimensionArreglo dimension)
{

    for (size_t i = 0; i < dimension; i++)

    {

        *pa = alea;
        ++pa;

    }


}

void desplegar(punterArreglo* pa, dimensionArreglo dimension)
{

    for (size_t i = 0; i < dimension; i++)

    {
        std::cout<<*pa<<" ";
        ++pa;
    }
    std::cout << std::endl;

}

void desplegarMultiplos(punterArreglo* pa, dimensionArreglo dimension)
{

    for (size_t i = 0; i < dimension; i++)

    {
        if(*pa % 5 == 0)
        {
            std::cout<<"Elemento "<<*pa<<" Posicion "<<i<<" Direccion "<<pa<<std::endl;
        }
        ++pa;
    }
    std::cout << std::endl;

}
