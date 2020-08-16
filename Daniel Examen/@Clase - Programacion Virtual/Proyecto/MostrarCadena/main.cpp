#include <iostream>
#include <cstring>
using namespace std;

void Subcadenas(char * C);
int main()
{
    char A[100];
    cin.getline(A,99,'\n');
    Subcadenas(A);
    return 0;
}
void Subcadenas(char * C)
{
    string cadenaUnida;
    int letra1 = 0, letra2= 0;
    while(C[letra1]!='\0')
    {
        while(C[letra1]!='\0')
        {
            cadenaUnida +=C[letra1];
            cout<<cadenaUnida<<endl;
            letra1++;
        }
        cadenaUnida ="";
        letra2++;
        letra1 = letra2;
    }

}

