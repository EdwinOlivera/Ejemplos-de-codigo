#include <iostream>

using namespace std;
void LTRIM(char *c);
int main()
{
    char cadenaPrincipal[]="Texto con mucho espacio         ";
    cout<<cadenaPrincipal<<"!"<<endl;

    LTRIM(cadenaPrincipal);

    cout<<cadenaPrincipal<<"!"<<endl;
    return 0;
}

void LTRIM(char *c)
{

    int longitudCadenaCalculada = 0, caracter = 0;
    while(c[caracter] != '\0' )
    {
        longitudCadenaCalculada++;
        caracter++;
    }

    int longitudCadena=longitudCadenaCalculada-1;

    while(*(c+longitudCadena)==' ')
    {
        *(c+longitudCadena)='\0';
        longitudCadena--;
    }
}

