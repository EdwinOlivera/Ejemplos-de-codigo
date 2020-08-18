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

void Folio(int *x, int n)
{
    int resEleme = 0;
    int sumaEleme = 1;

    for(int index  = 0; index <= n-1; index++)
    {
        if( index %4!=3 && index %4!=0)
        {
            x[index] = sumaEleme;
            sumaEleme++;
        }
        else
        {
            x[index ]= n-resEleme;
            resEleme++;
        }
    }
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
