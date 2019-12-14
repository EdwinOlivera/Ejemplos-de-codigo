#include <iostream>
#include <cmath>

void Fd(int[], int, int, int);
using namespace std;

int main()
{
    int B[5];
    for(int i = 0; i<5; i++)
    {
        B[i] = pow(i, 4-i);
    }
    Fd(B,3,0,5);
    return 0;
}


void Fd(int B[], int x, int k, int N)
{
    if(k<N)
    {
        if(B[k]==x)
        {
            cout<<"Fd con "<<k<<endl;
        }
        else
        {
            return Fd(B, x, k+1, N);
        }
    }

}
