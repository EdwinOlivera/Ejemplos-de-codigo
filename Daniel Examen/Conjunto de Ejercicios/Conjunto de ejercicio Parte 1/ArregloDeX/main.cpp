#include <iostream>
#include <time.h>
#include <cstdlib>
using namespace std;

int CalcularElFactoria(int);
int main()
{
    srand(time(NULL));
    double ArregloDeX[41], CambioDeSigno = 1, sumantoriaFinal = 0, SumatoriaParcial = 1;
    int numeroFactorial = 1;
    for(int i=0; i<41; i++)
    {
        ArregloDeX[i] = rand()%11;
    }
    cout<<"Todas las X son :"<<endl;

    for(int i = 0; i< 41; i++)
    {
        cout<<ArregloDeX[i]<<" ";
    }
    cout<<endl;

    for(int i = 0; i<38; i++)
    {
        for(int j = 0; j <3; j++)
        {

            SumatoriaParcial *= ArregloDeX[i+j];

            if(j ==3-1)
            {
                i += j-1;
            }
        }
        SumatoriaParcial = (SumatoriaParcial/CalcularElFactoria(numeroFactorial));
        numeroFactorial += 2;
        sumantoriaFinal += (SumatoriaParcial * CambioDeSigno);
        CambioDeSigno *= -1;

    }
    cout<<"La suma final es: "<<sumantoriaFinal<<endl;
    return 0;
}

int CalcularElFactoria(int Numero)
{

    if(Numero < 0)
        return 0;
    else if(Numero > 1)
        return Numero*CalcularElFactoria(Numero-1);
    return 1;


}
