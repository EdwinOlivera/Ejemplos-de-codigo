#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int A[1500];
    for(int I=0; I<1500; I++){
        cin>> A[I];
    }
    for(int J=0; J<1500; J++){
        cout<<"A["<<setw(4)<<J<<"] ="<<setw(11)<<A[J]<<"\n";
    }
    cout << "Hello world!" << endl;
    return 0;
}
