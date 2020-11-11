#include <iostream>

using namespace std;
bool validadNumero(int V[], int n, int indice);
void leerArreglo(int V[], int t);
void escribirArreglo(int V[], int t);
int main()
{
    int V[10],t ;
    do
    {
        cout<<"Ingrese cantidad de elementos (minimo 5, maximo 10) -> ";
        cin>>t;
    }
    while(t<5 || t>10);
    leerArreglo(V, t);
    return 0;
}
void leerArreglo(int V[], int t)
{
    int n,indice= 0;
    for(int i=0; i<t; i++)
    {
        cout<<"Ingrese numero ";
        cin>>n;
        if(validadNumero(V, n,i) == true)
        {
            i--;
            cout<<"Numero ya almacenado"<<endl;
        }
        else
        {
            V[i]=n;
        }


    }
    escribirArreglo(V, t);

}
void escribirArreglo(int V[], int t)
{
for(int m=0; m<t; m++){
    cout<<" "<<V[m];
}
}
bool validadNumero(int V[], int n, int indice)
{
    for(int j=0; j<indice; j++)
    {

        if(V[j] == n )
        {
            return true;
        }
    }
    return false;
}








