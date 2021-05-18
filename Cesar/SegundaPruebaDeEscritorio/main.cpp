#include <iostream>
#include <cstring>
using namespace std;
int funcion1(char *);
void  funcion(char *);
int main()
{
    char A[20]="Hola mundo";
    Funcion(A);
    cout<<A;
/*
    char ABEC[25]="abcdefgh\0ijklmnopqrstuvw";
    char contendor[2000];
    for(int i =0; i<1999; i++)
    {
        contendor[i]= ABEC[(11*i)%24];
    }
    cout<<funcion1(contendor);
  */
    return 0;
}
void funcion(char *A){
char *X = A;
int n = strlen(A);
const int m = n+1;
char B[m];
B[m-1]='\0';
int k = m-2;
while(*A != '\0'){

    if(k%4 != 0){
        B[k] = *A;
    }else{
    B[k] ='a';
    }
    A++;
    k--;
}
strcpy(X,B);
}
int funcion1(char *contendor)
{
    int contador=0;
    char *inicio = contendor;
    while(*inicio !='\0' )
    {
        inicio = inicio+1;
        contador++;
    }
    return contador;
}
