#include <iostream>
using namespace std;

int main()
{
    int n,Sum=0;
    cin>>n;

    for(int i=1; i<=n; i++)
    {
    int concurrenciaCERO = 0;
        for(int j=1; j<=i; j++)
        {
            if(i%j==0)
            {
                concurrenciaCERO++;
            }
        }
        if(concurrenciaCERO==2)
        {
            if(i%10==3)
            {
                Sum+=i;
            }

        }

    }
    cout<<Sum;
    return 0;
}
