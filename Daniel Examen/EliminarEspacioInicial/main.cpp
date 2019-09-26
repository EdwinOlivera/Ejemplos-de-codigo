#include <iostream>


using namespace std;
void LTRIM(char *c);
int main()
{
    char Frase[100];
    char *CF = Frase;
    cout<<"Escriba una frase o palabra"<<endl;
    cout<<"--> ";
    cin.getline(Frase,100);

    LTRIM(CF);
    cout<<"\nLa frase sin espacios iniciales es: "<<Frase<<endl;
    return 0;
}

void LTRIM(char *c)
{
    int m, n;
    int EspaciosEnBlancoInciales = 0;
    int TotalCaracteres = 0;

    n =0;
    while(*(c+n)!= '\0'){
        TotalCaracteres++;
        n++;
    }
    while((*c)==' ')
    {
        EspaciosEnBlancoInciales++;
        m = 1;
        n = 0;
        while(*(c+m) != '\0')
        {
            *(c+n) = *(c+m);
            n++;
            m++;
        }

    }
    TotalCaracteres = TotalCaracteres - EspaciosEnBlancoInciales;
    if(EspaciosEnBlancoInciales >0)
    {
        *(c+TotalCaracteres) = '\0';
    }
}
