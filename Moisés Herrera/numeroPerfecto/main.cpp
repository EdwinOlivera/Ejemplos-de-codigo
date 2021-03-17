#include <iostream>

using namespace std;
float sumaDivpropio(int n);
int main()
{
    int n,i,s=0;

    cout << "Ingrese un numero: ";
    cin >> n;

    for (i=1; i<n-1; i++)
    {
        if (n % i == 0)
            s += i;
    }

    if (n == s)
        cout <<"Si es perfecto"<<endl;
    else
        cout <<"No es perfecto"<<endl;
    return 0;
}

float sumaDivpropio(int n)
{
    float sumatoria = 0;
    for (int i = 0; i<=n; i++ ){

        if(i%n == 0)
        {
            sumatoria += i;
        }
    }
    return sumatoria;
}
