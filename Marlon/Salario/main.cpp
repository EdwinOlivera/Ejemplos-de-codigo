#include <iostream>

using namespace std;
float salario(float, float);
int main()
{
    float horas, valor;
    cout<<"Ingrese las horas trabajadas"<<endl;
    cin>>horas;
    cout<<"Ingrese el valor por hora"<<endl;
    cin>>valor;
    cout<<"Su salario es:\n";
    cout<< salario(horas,valor)<< endl;
    return 0;
}

float salario(float horas, float valor)
{
    float salarioCalculado = horas * valor;
    return salarioCalculado;
}
