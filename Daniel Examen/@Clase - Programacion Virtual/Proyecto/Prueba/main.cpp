#include <iostream>
#include<stdlib.h>
#include<time.h>
using namespace std;

int main()
{
    int numero = -1;

    srand(time(NULL));
numero = rand();
numero=1+rand()%5;

    cout << numero << endl;
    return 0;
}
