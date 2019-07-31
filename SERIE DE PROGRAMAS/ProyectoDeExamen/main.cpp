#include <iostream>
//#include <cstring>
using namespace std;


int main()
{
    char str[80];

    cout<<"Enter string: ";
    cin.getline(str,80); // Lee la cadena
    int i;
    for(i =0; str[i]!='\0'; i++);
    cout << i;

    return 0;
}
