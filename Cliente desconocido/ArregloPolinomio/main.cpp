#include <iostream>

using namespace std;
void Sintetico(int polinomioP[], int polinomioQ[], int polinomioC[], int gradoGeneral);



int main()
{
    int gradoP=1, gradoQ=1, gradoC=1, gradoGeneral = 1;

    cout<<"Grado de P: ";
    cin>>gradoGeneral;
    gradoP = gradoGeneral+1;
    gradoQ = 2;
    gradoC = gradoGeneral;
    int polinomioP[gradoP], polinomioQ[gradoQ], polinomioC[gradoC];

    cout<<"Ingrese los coeficientes de P empezando por el termino independiente:"<<endl;

    for(int i=0; i<gradoP; i++)
    {
        cin>>polinomioP[i];
    }

    cout<<"Ingrese los coeficientes de Q empezando por el termino independiente:"<<endl;

    for(int i=0; i<gradoQ; i++)
    {
        cin>>polinomioQ[i];
    }


    return 0;
}
void Sintetico(int polinomioP[], int polinomioQ[], int polinomioC[], int gradoGeneral)
{

}
