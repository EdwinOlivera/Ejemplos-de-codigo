#include <iostream>
using namespace std;

void Folio(int *x,int n);

void Imprimir(int *x,int n);
int main()
{
    int n;

    cin >> n;
    int A[n];

    Folio(A,n);
    Imprimir(A,n);
    return 0;
}
void Imprimir(int *x,int n)
{

    for(int i = 0; i<n; i++)
    {
        if(i!=n-1)
            cout<<x[i]<<",";
        else
            cout<<x[i];
    }
}
void Folio(int *x, int n)
{
    int eleRes = 0;
    int eleMas = 1;

    for(int i = 0; i<n; i++)
    {
        if(i%4==0 ||i%4==3 )
        {
            x[i]=n-eleRes;
            eleRes++;
        }
        else
        {
            x[i]=eleMas;
            eleMas++;
        }
    }
}
