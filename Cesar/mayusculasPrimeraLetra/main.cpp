#include <iostream>

using namespace std;

void convertir(char *c);
int main()
{
    char cadena[]="juan tiene hambre ";
    convertir(cadena);

    cout<<cadena<<endl;
    return 0;
}


void convertir(char *c)
{
    int l=0;
    c[0] = toupper(c[0]);

    while(c[l]!='\0')
    {
        if(c[l]==' ' && c[l-1]!=' ')
        {
            c[l-1] = toupper(c[l-1]);
        }
        l++;
    }
    l=0;
    while(c[l]!='\0')
    {
        if(c[l]!=' ' && c[l-1]==' ')
        {
            c[l] = toupper(c[l]);
        }
        l++;
    }
}


