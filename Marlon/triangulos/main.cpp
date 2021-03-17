#include <iostream>

using namespace std;
bool vericarTriangular(int);
int main()
{
    int numIngresado = 0, cantTriangulo = 0;

    do
    {
        cin>>numIngresado;

        if(numIngresado>0)
        {

            if(vericarTriangular(numIngresado))
            {
                cantTriangulo++;
            }
        }

    }
    while(numIngresado>0);

    cout<<cantTriangulo<<endl;
    return 0;
}

bool vericarTriangular(int numIngresado)
{
    bool esTriangulo = false;
    int base = 0;
    float periodo = 0;
    do
    {
        base++;
        periodo = (base*(base+1))/2;
    }
    while (numIngresado>periodo);

    if (numIngresado==periodo)
    {
        esTriangulo =  true;
    }
    else
    {
        esTriangulo =  false;
    }





    return esTriangulo;
}
