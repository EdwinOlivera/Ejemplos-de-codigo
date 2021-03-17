#include <iostream>

using namespace std;
void misterio(char *, char *);
int main()
{
    char cadena1[50] = "Feliz";
    char cadena2[50] = "Navidad";
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    misterio(cadena1, cadena2);
    cout<<endl;
    cout<<endl;
    cout<<cadena2;
    cout<<endl;
    return 0;
}
void misterio(char *ptr1, char *ptr2)
{
    while(*ptr2 != '\0')
    {
        ptr2++;
    }
    *ptr2 = '-';

    while(*ptr1 != '\0')
    {
        *ptr2 = *ptr1;
        ptr2++;
        ptr1++;
    }
    *ptr2 = '\0';
}
