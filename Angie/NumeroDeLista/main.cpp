#include <iostream>

int F(int);
int Diagonal(int[][3]);

int main( )
{

    int M[3][3] = {{7, 2, 3}, {5, 6, 7}, {9, 10, 11}};

    int x = 0;
    std::cout << "Ingresar numero de lista:" << std::endl;
    std::cin>>x;
    std::cout << "Resultados:" << std::endl;
    std::cout<<F(x)<<std::endl;
    std::cout<<F(Diagonal(M))<<std::endl;
    return 0;
}
int F(int x)
{
    return x%7;
}

int Diagonal(int M[][3])
{
    int Sum = 0;
    for(int i =0; i<3; i++)
    {
        for(int j=0; j<3; j++)
        {
            if(i==j)
            {
                Sum+=i;
            }
        }
    }
    return Sum;
}
