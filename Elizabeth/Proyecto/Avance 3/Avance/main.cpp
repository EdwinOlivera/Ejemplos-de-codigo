#include <iostream>
#include <math.h>
#include <cmath>
#include <iomanip>

using namespace std;
const double constanteEuler = exp(1.0);
int calcularNumeroDeIteraciones(float numeroIngresado_H);
float  funcionUNO(float cantidad_T);
float  funcionDOS(float cantidad_T);
float  funcionTRES(float cantidad_T);
int main()
{

    // Redondemaos numeros decimales
    cout<<setprecision(6);
    float  cantidad_T = 0;


    float numeroIngresado_H = 0;
    cout<<"Ingrese el valor de H (0 <= H <= 1)"<<endl;
    cin>>numeroIngresado_H;

    while(numeroIngresado_H>1 || numeroIngresado_H<0)
    {
        cout<<"Has ingresado un valor no permitido. Solo se permiten valores mayores a 0 y menores a 1 (0 <= H <= 1)"<<endl;
        cin>>numeroIngresado_H;
    }
    int iteracionActual = 0;

    iteracionActual = calcularNumeroDeIteraciones(numeroIngresado_H);

    double valoresW[3][iteracionActual];

    valoresW[0][0] = 1;
    valoresW[1][0] = 1;
    valoresW[2][0] = -1;
    iteracionActual = 0;

    do
    {

        for(int i=0; i<3; i++)
        {
            if(i == 0)
            {
                valoresW[i][iteracionActual+1] = valoresW[i][iteracionActual] + (numeroIngresado_H * (valoresW[i+1][iteracionActual] - valoresW[i+2][iteracionActual] + cantidad_T));

            }
            else if(i==1)
            {
                valoresW[i][iteracionActual+1] = valoresW[i][iteracionActual] + (numeroIngresado_H * (3 * pow(cantidad_T,2) ));

            }
            else if(i == 2)
            {
                valoresW[i][iteracionActual+1] = valoresW[i][iteracionActual] + (numeroIngresado_H * (valoresW[i-1][iteracionActual] + pow(constanteEuler,-cantidad_T)));
            }
        }


        iteracionActual++;

        cantidad_T += numeroIngresado_H;
    }
    while(cantidad_T<=1);


    cantidad_T = 0;
    iteracionActual = 1;

    cout<<setw(5)<<"T"<<setw(5)<<""<<setw(11)<<"W[i][j]"<<setw(5)<<""<<setw(12)<<"Error real"<<setw(3)<<""<<endl;
    cout<<"----------------------------------------------"<<endl;
    do
    {


        for(int indiceFila=0; indiceFila<3; indiceFila++)
        {
            if(indiceFila==0)
            {
                cout<<setw(10)<<"|"<<setw(10)<<valoresW[indiceFila][iteracionActual]<<setw(5)<<"|"<<setw(10)<<abs(valoresW[indiceFila][iteracionActual] - funcionUNO(cantidad_T + numeroIngresado_H)) <<setw(5)<<"|"<<endl;
            }

            if(indiceFila==1)
            {
                cout<<setw(5)<<cantidad_T<<setw(5)<<"|"<<setw(10)<<valoresW[indiceFila][iteracionActual]<<setw(5)<<"|"<<setw(10)<<abs(valoresW[indiceFila][iteracionActual] - funcionDOS(cantidad_T + numeroIngresado_H)) <<setw(5)<<"|"<<endl;
            }
            if(indiceFila==2)
            {
                cout<<setw(10)<<"|"<<setw(10)<<valoresW[indiceFila][iteracionActual]<<setw(5)<<"|"<<setw(10)<<abs(valoresW[indiceFila][iteracionActual] - funcionTRES(cantidad_T + numeroIngresado_H)) <<setw(5)<<"|"<<endl;
            }
        }
        cout<<"----------------------------------------------"<<endl;


        iteracionActual++;
        cantidad_T += numeroIngresado_H;
    }
    while(cantidad_T<=1);

    return 0;
}

int calcularNumeroDeIteraciones(float numeroIngresado_H)
{
    int numeroDeIteraciones = 1;
    float cantidad_T = 0;
    do
    {
        numeroDeIteraciones++;

        cantidad_T += numeroIngresado_H;
    }
    while(cantidad_T<=1);

    return numeroDeIteraciones;
}

float  funcionUNO(float cantidad_T)
{
    return (-0.05 * pow(cantidad_T,5)) + (0.25 * pow(cantidad_T,4)) + cantidad_T + 2 - pow(constanteEuler,-cantidad_T);
}
float  funcionDOS(float cantidad_T)
{
    return pow(cantidad_T,3)+1;
}
float  funcionTRES(float cantidad_T)
{
    return (0.25* pow(cantidad_T,4)) + cantidad_T - pow(constanteEuler,-cantidad_T);

}
