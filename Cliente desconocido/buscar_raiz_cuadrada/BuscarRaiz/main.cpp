
#include<stdio.h>
#include<stdlib.h>
#include<locale.h>


void RecibeNoRetorna(int *numeroExponente, double *numeroIngresado);
int main()
{
    double numeroIngresado=0;
    int numeroExponente = 1;
    printf("Escriba un valor entero potencia de 2: ");

    scanf("%lf",&numeroIngresado);

    if(numeroIngresado > 0 && (int)numeroIngresado%2==0)
    {

        RecibeNoRetorna(&numeroExponente, &numeroIngresado);

        printf("Exponente encontrado: %d",numeroExponente);
    }
    else
    {
        printf("El numero ingresado no es de potencia 2 positivo. Intente con otro.  ");
    }
    return 0;
}
void RecibeNoRetorna(int *numeroExponente, double *numeroIngresado)
{

    double numeroAEvular = 1;
    bool exponenteEncontrado = false;

        do
        {
            for(int i=0; i<*numeroExponente; i++)
            {
                numeroAEvular *= 2;

                if(numeroAEvular == *numeroIngresado)
                {
                    exponenteEncontrado= true;
                    break;
                }
            }
            numeroAEvular =1;
            if(!exponenteEncontrado )
            {
                *numeroExponente +=1;
            }

        }
        while(!exponenteEncontrado );

}
