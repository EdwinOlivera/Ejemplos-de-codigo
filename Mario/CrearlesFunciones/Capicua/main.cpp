#include <iostream>
#include <cstdlib>

using namespace std;

    void CAPICUA (int num);

    int a;
    int b;
    int c;

int main()
{
    int num;
    cout << "INTRODUZCA UN NUMERO PARA COMPROBAR SI ES O NO CAPICUA: ";
    cin >> num;
    cout << endl << endl;
    CAPICUA(num);
    return 0;
}

void CAPICUA (int num)
{
    a=num;
    c=0;
    b=0;
    while(a!=0)
    {
        b=a%10;
        a=a/10;
        c=c*10+b;

    }
    cout<<endl;
    if(c==num)
        cout<< num << " SI ES CAPICUA" << endl << endl;
    else
        cout << endl << num << " NO ES CAPICUA, YA QUE SU NUMERO VOLTEADO ES " << c << endl << endl;
}
