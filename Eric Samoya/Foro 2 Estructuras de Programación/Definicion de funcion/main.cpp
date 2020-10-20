#include <iostream>

using namespace std;

int main()
{
    int numN = 0, numR= 0;
    int factorialN=1, factorialR=1;
    double restaNum = 0, restaFactorialNum = 1 ;
    double multiplicacion = 0, division = 0;
    cout << "Ingrese N" << endl;
    cin>>numN;

    if(numN<0)
        factorialN =0;
    else if(numN==0)
        factorialN=1;
    else
    {
        for (int i = 1; i <= numN; i++)
        {
            factorialN= factorialN*i;

        }
    }

    do
    {
        do
        {
            cout << "Ingrese R" << endl;
            cin>>numR;
        }
        while(numR>numN);
    }
    while(numR<0);


    if(numR==0)
        factorialR=1;
    else
    {
        for (int i = 1; i <= numR; i++)
        {
            factorialR= factorialR*i;

        }
    }


    restaNum = numN - numR;

    if(restaNum <0)
        restaFactorialNum =0;
    else if(restaNum ==0)
        restaFactorialNum=1;
    else
    {
        for (int i = 1; i <= restaNum ; i++)
        {
            restaFactorialNum = restaFactorialNum*i;
        }
    }

    multiplicacion = factorialR*restaFactorialNum;

    division = factorialN/multiplicacion;
    cout<<"El resultado final es: "<<division<<endl;
    return 0;
}
