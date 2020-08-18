#include <iostream>
using namespace std;

void encriptar(char *frase, char *clave);
void mostrar(char *frase);

int main()
{
    char frase[100], clave[100];
    int tmpNum=0;
    bool palabraCorrecta = true;
    cin.getline(frase,100);

    cin.getline(clave,100);

    while(frase[tmpNum]!='\0')
    {
        frase[tmpNum] = toupper( frase[tmpNum]);

        if(frase[tmpNum]< 65 ||  frase[tmpNum] >90)
        {
            palabraCorrecta=false;
            break;
        }
        tmpNum++;

    }
    tmpNum = 0;
    if(palabraCorrecta)
    {
        while(clave[tmpNum]!='\0')
        {
            clave[tmpNum] = toupper( clave[tmpNum]);

            if(clave[tmpNum]< 65 ||  clave[tmpNum] >90)
            {
                palabraCorrecta=false;
                break;
            }
            tmpNum++;

        }
    }
    if(palabraCorrecta)
    {
        encriptar(frase, clave);
        mostrar(frase);
    }
    return 0;
}
void mostrar(char *frase)
{
    int tmpNum = 0;
    while(frase[tmpNum]!='\0')
    {
        cout<<frase[tmpNum];
        tmpNum++;

    }
}


void encriptar(char *frase, char *clave)
{
    int AuxNum1 = 0,AuxNum2 = 0;
    char letras []= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    while(frase[AuxNum1]!='\0')
    {
        if(clave[AuxNum2]=='\0')
        {
            AuxNum2 = 0;
        }
        frase[AuxNum1] = letras[((frase[AuxNum1]+clave[AuxNum2] )%26)];
        AuxNum2++;
        AuxNum1++;

    }

}
