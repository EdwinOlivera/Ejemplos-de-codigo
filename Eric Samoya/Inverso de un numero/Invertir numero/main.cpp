#include <iostream>

using namespace std;

int main()
{
    string num ="", numInv="";

    cin>>num;
    int cant = num.length();
    for(int i=0; i<cant; i++)
    {
        numInv += num[num.length()-1-i];
    }
    cout<<numInv<<endl;

    return 0;
}
