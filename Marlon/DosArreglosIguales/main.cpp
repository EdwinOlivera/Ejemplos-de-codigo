#include <iostream>

using namespace std;
bool comprobarArreglos(int [], int[], int);
void ingresarArreglo(int [], int);
bool comprobarNumero(int [], int, int );
int main()
{
    int dimensionArreglo=0;
    bool numDuplicado = false;
    cout<<"Ingrese la dimencion de los arreglos (n>5)"<<endl;
    do
    {
        cin>>dimensionArreglo;
    }
    while(dimensionArreglo<=5);

    int arregloUno[dimensionArreglo], arregloDos[dimensionArreglo];

    cout<<"Ingresando los datos del Primer Arreglo"<<endl;
    ingresarArreglo( arregloUno, dimensionArreglo);

    cout<<"Ingresando los datos del Segundo Arreglo"<<endl;
    ingresarArreglo(arregloDos, dimensionArreglo);

    if(comprobarArreglos(arregloUno, arregloDos, dimensionArreglo))
    {
        cout<<"Los arreglos SI son identicos"<<endl;
    }
    else
    {
        cout<<"Los arreglos NO son identicos"<<endl;
    }
    return 0;
}
bool comprobarArreglos(int arregloUno[], int arregloDos[], int dimensionArreglo)
{
    bool identicos = true, numeroEncontrado;

    for(int i=0; i<dimensionArreglo; i++)
    {
        for(int j=0; j<dimensionArreglo; j++)
        {
            if(arregloUno[i] == arregloDos[j])
            {
                numeroEncontrado = true;
            }
        }
        if(numeroEncontrado == false)
        {
            identicos = false;
        }
    }
    return identicos;
}
void ingresarArreglo(int arreglo[], int dimensionArreglo)
{
    int numeroAIngresar = 0;
    for(int i=0; i<dimensionArreglo; i++)
    {

        cout<<"Ingresado el dato #"<<(i+1)<<" al arreglo -> ";
        cin>>numeroAIngresar;
        for(int j=0; j<i; j++)
        {

        }
        if(!comprobarNumero(arreglo,i, numeroAIngresar))
        {
            arreglo[i] = numeroAIngresar;
        }
        else
        {
            i -= 1;
        }

    }
}
bool comprobarNumero(int arreglo[], int dimecionActual, int numeroAcomparar)
{
    bool numDuplicado = false;
    for(int j=0; j<dimecionActual; j++)
    {
        if(numeroAcomparar== arreglo[j])
        {
            numDuplicado = true;
            break;
        }
    }
    return numDuplicado;
}
