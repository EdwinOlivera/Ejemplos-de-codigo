#include <iostream>

using namespace std;

int main()
{
    double SumatoriaPrincipal = 0, elementoX = 0, elementoY = 0, restaInteran = 0;
    int valorN = 0;
    do
    {
        cout<<"Ingrese el valor de N, hasta donde se hara la sumatoria. El valor tiene que ser Mayor a 1"<<endl;
        cin>>valorN;

    }

    while(valorN<=1);
    for(int i = 1; i<= valorN; i++)
    {
        cout<<"Ingrese el elemento X #"<<(i)<<endl;
        cin>>elementoX;
        cout<<"Ingrese el elemento Y #"<<(i)<<endl;
        cin>>elementoY;

        restaInteran = ((elementoX*elementoX) - (elementoY*elementoY));

        SumatoriaPrincipal += restaInteran;

    }

    cout<<"La sumatoria final es: "<<SumatoriaPrincipal<<endl;

    return 0;
}
