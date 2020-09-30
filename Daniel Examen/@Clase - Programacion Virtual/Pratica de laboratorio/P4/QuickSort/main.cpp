#include <iostream>

using namespace std;

//IMPORTANTE
//Ejecucion del metodo Quicksort mara ordera arreglos de numeros
void MostarArreglo(int *ArregloDeElementos, int n)
{
    for (int i = 0; i < n; ++i)
        cout << ArregloDeElementos[i] <<  endl;
}

void EjecutarQuickSort(int ArregloDeElementos[], int numeroInferior, int numeroSuperior)
{
    int i = numeroInferior;
    int j = numeroSuperior;
    int elementoPivote = ArregloDeElementos[(i + j) / 2];
    int temp;

    while (i <= j)
    {
        while (ArregloDeElementos[i] < elementoPivote)
            i++;
        while (ArregloDeElementos[j] > elementoPivote)
            j--;
        if (i <= j)
        {
            temp = ArregloDeElementos[i];
            ArregloDeElementos[i] = ArregloDeElementos[j];
            ArregloDeElementos[j] = temp;
            i++;
            j--;
        }
    }
    if (j > numeroInferior)
        EjecutarQuickSort(ArregloDeElementos, numeroInferior, j);
    if (i < numeroSuperior)
        EjecutarQuickSort(ArregloDeElementos, i, numeroSuperior);
}

int main()
{
    int ArregloDeElementos[] = {-12,100,9, -1,0,3, 2, 1,11,-10 };
    int n = sizeof(ArregloDeElementos)/sizeof(ArregloDeElementos[0]);
    cout<<endl;
    cout<< "Antes de ejecutar el Algoritmo QuickSort :" << endl;
    MostarArreglo(ArregloDeElementos, n);

    EjecutarQuickSort(ArregloDeElementos, 0, n-1);
    cout<<endl;
    cout << "Despues de ejecutar el algoritmo Quick Sort :" <<  endl;
    cout<<endl;
    MostarArreglo(ArregloDeElementos, n);
    return (0);
}
