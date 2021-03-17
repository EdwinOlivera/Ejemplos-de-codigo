#include <iostream>

using namespace std;

int main()
{
    double  nume =0, sumS, sumO, sumT;
    cout<<"Multiplicacion por Adicion Repetida usando 1001 = 7*11*13"<<endl;
    cout<<"Resultado de la Suma Repetida 33 * 1001"<<endl;
    nume = 33;
    for(int i = 0; i<7; i++)
    {
        sumS +=  nume;
        sumO = 0;
        for(int j = 0; j<11; j++)
        {
            sumO +=  sumS;
            sumT = 0;
            for(int m = 0; m<13; m++)
            {
                sumT += sumO;
            }
        }
    }
    cout << sumT << endl;
    cout<<"Resultado de la Suma Repetida 47 * 1001"<<endl;
    nume = 47;
    sumS= 0;
    for(int i = 0; i<7; i++)
    {
        sumS +=  nume;
        sumO = 0;
        for(int j = 0; j<11; j++)
        {
            sumO +=  sumS;
            sumT = 0;
            for(int m = 0; m<13; m++)
            {
                sumT += sumO;
            }
        }
    }
    cout << sumT << endl;

    cout<<"Resultado de la Suma Repetida 83 * 1001"<<endl;
    nume = 83;
    sumS= 0;
    for(int i = 0; i<7; i++)
    {
        sumS +=  nume;
        sumO = 0;
        for(int j = 0; j<11; j++)
        {
            sumO +=  sumS;
            sumT = 0;
            for(int m = 0; m<13; m++)
            {
                sumT += sumO;
            }
        }
    }
    cout << sumT << endl;
    return 0;
}
