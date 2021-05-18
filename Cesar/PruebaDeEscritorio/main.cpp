#include <iostream>
#include <cstring>
using namespace std;
void soyUnaFuncion(char *, char *, int);
int main()
{
    char cadena1[150]= "No me rendire y llegar hasta el final";
    char cadena2[50];
    int n = strlen(cadena1)/2;
    soyUnaFuncion(cadena1, cadena2, n);

    cout<<"soyUnaFuncion modifico cadena 2 y ahora es: \n\n";
    cout<<cadena2<<endl;

    return 0;
}

void soyUnaFuncion(char *cadena1, char *cadena2,int n)
{
    for(int i =0; i<n; i++)
    {
        *cadena2 = *cadena1;
        *cadena1++;
        *cadena2++;
    }
    *cadena2='\0';
}
