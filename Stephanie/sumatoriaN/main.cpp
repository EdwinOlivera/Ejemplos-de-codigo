#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int i= 0, n;
    float r = 0, s = 0;
    cout<<"Valor para desarrollar sumatoria"<<endl;
    cin>> n;
    for(i=1;i<=n;i++){
        s = 1/(pow(2,i));
  //      cout<<"s = "<<s<<endl;
        r = r + s;
        cout<<"r = "<<r<<endl;
    }

    cout << "Valor de la sumatoria: "<< r << endl;
    return 0;
}
