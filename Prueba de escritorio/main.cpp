#include <iostream>

using namespace std;
void funcion(char *, char *);

int f1(char *ptrS)
{
    int  n = 0;
    while(*ptrS != '\0')
    {
        ptrS++;
        n++;
    }
    return n;

}

bool f2(char *c)
{
    int n = f1(c);
    for(int i = 0; i<n/2; i++)
    {
        if(*(c+1) != *(c+n-1-i))
        {
            return false;
        }
    }
    return true;
}
int main()
{

    return 0;
}

void funcion(char * ptr1, char * ptr2)
{
    int cont1 = 0;
    int cont2 = 0;
    while(*(ptr1 + cont1) != '\0')
    {

        cont1++;
    }
    while(*(ptr2 + cont2) != '\0')
    {

        cont2++;

    }

    *(ptr1 + cont1)= '-';
    for(int i = 1; i<=cont2; i++)
    {

        *(ptr1 + cont1 + i) = *(ptr2+i-1);
    }
    cout<<cont1+cont2<<endl;
}

