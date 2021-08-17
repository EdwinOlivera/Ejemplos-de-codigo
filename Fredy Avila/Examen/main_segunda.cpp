
#include <iostream>

#include <string.h>

#include <cstring>
using namespace std;

void Funcion(char *A);
int main()
{

    char A[100] = "acaso yo hubo no buhos aca";
    Funcion(A);
    cout<<A;
    return 0;

}
void Funcion(char *A)
{
    const int n = strlen(A);
    char *Parte = strtok(A," ");
    char Arreglo[n+1] ="";
    char Arreglo1[n+1] ="";
    char *Nulo = NULL;
    int i = 0;
    while (Parte != NULL)
    {
        if(i%2 == 0)
        {
            strcpy(Arreglo1, Parte);
            strcat(Arreglo1," ");
            strcat(Arreglo1, Arreglo);
            strcpy(Arreglo,Arreglo1);
        }
        Parte = strtok(NULL," ");
        i++;
    }
    strcpy(A, Arreglo);

}
