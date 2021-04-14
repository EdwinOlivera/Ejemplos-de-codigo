#include <iostream>

using namespace std;
int longitud(char *c);
void LTRIM(char *c);
int main()
{
    char c[]="Hola mundo ";
    cout<<c<<"!"<<endl;
    LTRIM(c);
    cout<<c<<"!"<<endl;
    return 0;
}


void LTRIM(char *c)
{
    int l=longitud(c)-1;
    while(*(c+l)==' ')
    {
        *(c+l)='\0';
        l--;
    }
}

int longitud(char *c)
{
    int i=0;
    while(*(c+i)!='\0')
    {
        i++;
    }
    return i;
}
