#include <iostream>
#include <time.h>
#include <cstdlib>

using namespace std;

int main()
{
    srand(time(NULL));
    float ArregloGeneral[5], numeroAIngresar = 0;
    cout<<"Formando el arreglo aleatoriamente . . ."<<endl;

    for(int elementoActual  = 0; elementoActual < 5; elementoActual++)
    {

        do
        {
            numeroAIngresar = 1+rand()%25;
            if(elementoActual>0)
            {
                for(int numeroComprobar = 0; numeroComprobar<elementoActual; numeroComprobar++)
                {
                    if(ArregloGeneral[numeroComprobar] == numeroAIngresar/2 || numeroAIngresar == ArregloGeneral[numeroComprobar]/2)
                    {
                        numeroAIngresar = -1;
                        break;
                    }
                }
            }

        }
        while(numeroAIngresar == -1);

        ArregloGeneral[elementoActual] = numeroAIngresar;
    }

    cout<<"El arreglo creado es: "<<endl;
    cout<<"[ ";
    for(int i = 0; i<5; i++)
    {
        cout<<ArregloGeneral[i]<<" ";
    }
    cout<<"]"<<endl;
    return 0;
}
