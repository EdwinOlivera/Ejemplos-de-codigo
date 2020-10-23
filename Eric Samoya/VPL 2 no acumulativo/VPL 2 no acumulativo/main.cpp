#include <iostream>

using namespace std;

int main()
{
    int numN = 0;
    int factorialN=1;

    cout << "Ingrese N" << endl;
    cin>>numN;

    if(numN<0)
        factorialN =0;
    else if(numN==0)
        factorialN=1;
    else
    {
        for (int i = 1; i <= numN; i++)
        {
            factorialN= factorialN*i;

        }
    }
    cout<<factorialN<<endl;
    return 0;
}
