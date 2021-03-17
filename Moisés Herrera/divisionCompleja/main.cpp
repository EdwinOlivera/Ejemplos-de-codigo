#include <iostream>

using namespace std;

int main()
{
    int a, n = 0;
    cin>>a;
    do
    {

        cin>>n;
    }
    while(n < 0);
    int arreglo[n];
    arreglo[0]=a;
    for(int i= 1; i<n; i++)
    {
        arreglo[i] = arreglo[i-1]*3;
        arreglo[i] = arreglo[i]%14;
    }
    cout<<arreglo[n-1]<<endl;
    return 0;
}
