#include <iostream>

using namespace std;
char *h=NULL;
char f(char *, unsigned short*, short);
int main()
{

    unsigned short x{2}, y{3}, z{1};
    unsigned short *a=&x, *b=&y, *c=&z;
    char hiaoto[]= {'h','i','a','o','t','o','\0'};
    short unsigned data[] = {0,1,2,3,4,5};
    cout<<f(*&hiaoto, &*data, 3)<<'4';

    return 0;

}

char f(char *h, unsigned short *d, short r)
{
    for(size_t k{}; k<r; k++)
    {
        cout<<*(h+k+1)<<h[*(d+k)]<<*(&(*(&(*(d+k)))))<<r+k<<endl;
    }
    return h[*(d+r-1)];
}
