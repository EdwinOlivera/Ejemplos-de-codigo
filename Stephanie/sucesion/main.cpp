#include <iostream>

using namespace std;
int f(int elementoX, int elementoA, int elementoB, int elementC);
void promedio(int arreglo[], int dimension);
int main()
{
    int numero, elementoA, elementoB, elementoC;
    int imagen;
    cout<<"Ingrese el tamanio del arreglo"<<endl;
    cin>>numero;
    int arregloImagenes[numero];
    cout<<"a = ";
    cin>>elementoA;
    cout<<"b = ";
    cin>>elementoB;
    cout<<"c = ";
    cin>>elementoC;
    for(int i=0; i<numero; i++)
    {
        imagen =  f(i, elementoA, elementoB, elementoC);
        arregloImagenes[i] = imagen;
    }

    promedio(arregloImagenes, numero);
    return 0;
}
int f(int elementoX, int elementoA, int elementoB, int elementC)
{
    int imagen = 0;
    imagen  = (elementoA * (elementoX * elementoX)) + (elementoB*elementoX) + elementC;
    cout<<imagen<<" ";
    return imagen;
}

void promedio(int arreglo[], int dimension)
{
    int promedio = 0, suma= 0;
    for(int i=0; i<dimension; i++)
    {
        suma += arreglo[i];
    }
    promedio = suma/dimension;

    cout<<"\n"<<promedio<<endl;
}
