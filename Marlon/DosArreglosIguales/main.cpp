#include <iostream>

using namespace std;
bool comprobarArreglos(int [], int[], int);
int main()
{
    int dimensionArreglo=0, numeroAIngresar = 0;
    bool numDuplicado = false;
    cout<<"Ingrese la dimencion de los arreglos (n>5)"<<endl;
    do
    {
        cin>>dimensionArreglo;
    }
    while(dimensionArreglo<=5);

    int arregloUno[dimensionArreglo], arregloDos[dimensionArreglo];
    cout<<"Ingresando los datos del Primer Arreglo"<<endl;
    for(int i=0; i<dimensionArreglo; i++)
    {
        numDuplicado  = false;
        cout<<"Ingresado el dato #"<<(i+1)<<" al arreglo -> ";
        cin>>numeroAIngresar;
        for(int j=0; j<i; j++)
        {
            if(numeroAIngresar == arregloUno[j])
            {
                numDuplicado = true;
                i -= 1;
            }
        }
        if(!numDuplicado)
        {
            arregloUno[i] = numeroAIngresar;
        }

    }
    cout<<"Ingresando los datos del Segundo Arreglo"<<endl;
    for(int i=0; i<dimensionArreglo; i++)
    {
        numDuplicado  = false;
        cout<<"Ingresado el dato #"<<(i+1)<<" al arreglo -> ";
        cin>>numeroAIngresar;
        for(int j=0; j<i; j++)
        {
            if(numeroAIngresar == arregloDos[j])
            {
                numDuplicado = true;
                i -= 1;
            }
        }
        if(!numDuplicado)
        {
            arregloDos[i] = numeroAIngresar;
        }

    }
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
