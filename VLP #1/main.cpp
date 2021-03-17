#include <iostream>

using namespace std;
void CalcularPromedioNotas(float, float, float);
int main()
{
    float nota1,  nota2, nota3;
    cout<<"Ingrese las tres notas"<<endl;
    cin>>nota1;
    cin>>nota2;
    cin>>nota3;

    if(nota1>=0 && nota2>=0 && nota3>=0)
    {
        CalcularPromedioNotas( nota1,  nota2, nota3);
    }else{
    cout<<"Ingreso una o varias notas no validas"<<endl;
    }

    return 0;
}

void CalcularPromedioNotas(float nota1, float nota2,float nota3)
{
    float   sumaDeNotas = 0;
    sumaDeNotas = nota1 + nota2 + nota3;
    float promedioNotas = sumaDeNotas / 3 ;

    if(promedioNotas >=65)
    {
        cout<<"APROBADO"<<endl;
    }
    else
    {
        cout<<"REPROBADO"<<endl;
    }

}
