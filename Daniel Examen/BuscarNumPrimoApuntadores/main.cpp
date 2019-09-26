#include <iostream>

using namespace std;
int primo_suma(int *A, int n);
int main()
{
    int AD[100];
    int *A = AD;
    int n = 15;
    int LaSumaDePrimos = 0;
    LaSumaDePrimos  = primo_suma(A, n);
    cout<<"\nLos numeros primos encontrados son: "<<endl;
    for(int i = 0; i<n; i++)
    {
        cout<<"#"<<(i+1)<<" = | "<<(AD[i])<<" |"<<endl;
    }

    cout<<"\nLa suma de los numeros primos es: "<<LaSumaDePrimos<<endl;

    return 0;
}

int primo_suma(int *A, int n)
{
    cout<<"La cantidad de numeros primos a buscar es de: "<<n<<endl;
    int sumanToria = 0;
    int NumeroEncontrado = 0;
    int numeroAComprobar = 0;

    int contador =0;
    int SiguienteNumero = 1;


    do
    {
        SiguienteNumero = 1;
        do
        {
            if(numeroAComprobar%SiguienteNumero == 0)
            {
                contador++;
            }
            SiguienteNumero++;
        }
        while(SiguienteNumero <= numeroAComprobar);

        if(contador == 2)
        {
            sumanToria += numeroAComprobar;
            *A = numeroAComprobar;
            NumeroEncontrado++;
            *A++;
            contador = 0;
        }
        else
        {
            contador = 0;
        }
        numeroAComprobar++;

    }
    while(NumeroEncontrado < n);

    return sumanToria;
}
