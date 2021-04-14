#include <iostream>
#include<cstdlib>

using namespace std;
void LTRIM(char *c);
int longitud(char *tmoC);
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


    int longitudCadena=longitud(c)-1;

    while(*(c+longitudCadena)==' ')
    {
        *(c+longitudCadena)='\0';
        longitudCadena--;
    }
}

int longitud(char *tmoC)
{

    int anchoCadena = 0;
    while(*(tmoC) != '\0' )
    {
        anchoCadena++;
        tmoC++;
    }

return anchoCadena;
}

