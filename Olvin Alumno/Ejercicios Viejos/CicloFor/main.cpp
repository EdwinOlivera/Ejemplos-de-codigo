#include <iostream>

using namespace std;

int main()
{
    int n,I;
     cout<<"Ingrese un entero positivo"<<endl;
     cin>>n;
     for(int i = 0; i<n; i++){
        cout<<"valor de i = "<<i<<endl;
        I = i;
     }
     cout<<"Al terminar el ciclo For de i: "<<I;
    return 0;
}
