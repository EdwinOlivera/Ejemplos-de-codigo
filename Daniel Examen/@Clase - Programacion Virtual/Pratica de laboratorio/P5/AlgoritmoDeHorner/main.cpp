#include <iostream>

using namespace std;

int horner(int poly[], int cantNumeros, int numAEvaluar)
{
    if (cantNumeros == 0)
    {
        return poly[0];
    }
    return horner(poly, cantNumeros-1, numAEvaluar ) * numAEvaluar + poly[cantNumeros];
}

int main()
{
    int poly[] = {1, 0,1,1,0,0,1};//Esto son los coeficientes del polinomio p(x)=x*5+x*4+x*7−12+x*1
    int x = 5;
    int n = sizeof(poly)/sizeof(poly[0]);//Con esto conseguimos la longitud del Array Poly[]
    cout << "El valor del polinomio es = " << (horner(poly, n, x )-n)-12<<endl;
    return 0;
}
