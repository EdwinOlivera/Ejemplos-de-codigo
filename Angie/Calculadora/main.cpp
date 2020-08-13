#include <iostream>
#include <math.h>
//Operaciones basicas
void sumar(int *x, int *y, float *resultado);
void restar(int *x, int *y, float *resultado);
void dividir(int *x, int *y, float *resultado);
void multiplicar(int *x, int *y, float *resultado);
void potencia(int *x, float *resultado);
void raizCuadrada(int *x, float *resultado);
//Operaciones Avanzadas

//Operaciones Especiales
using namespace std;

int main()
{
    char opcion;
    int x,y;
    float resultado = 0;
    float *apuGen;
    int *apuX, *apuY;


    //Apuntando a las variables
    apuGen =&resultado;
    apuX = &x;
    apuY = &y;
    cout<<"Ingrese el valor de X: "<<endl;
    cin>>x;
    cout<<"Ingrese el valor de Y: "<<endl;
    cin>>y;
    do
    {

        cout<<"Menu principal"<<endl;
        cout<<"----->Operaciones Basicas<-----"<<endl;
        cout<<"1 = Sumar (X+Y)"<<endl;
        cout<<"2 = Restar (X-Y)"<<endl;
        cout<<"3 = Multiplicar (X*Y)"<<endl;
        cout<<"4 = Dividir (X/Y). Y!=0"<<endl;
        cout<<"5 = Potencia de X  (X^n)"<<endl;
        cout<<"6 = Potencia de Y  (Y^n)"<<endl;
        cout<<"7 = Raiz cuadrada X (sqrt(X))"<<endl;
        cout<<"8 = Raiz cuadrada Y (sqrt(Y))"<<endl;
        cout<<"s = Salir del sistema"<<endl;
        cin>>opcion;

        switch(opcion)
        {
        case '1':
            sumar(apuX,apuY,apuGen);

            cout<<"La suma es: "<<*apuGen<<endl;

            break;
        case '2':
            restar(apuX,apuY,apuGen);

            cout<<"La resta es: "<<*apuGen<<endl;

            break;
        case '3':
            multiplicar(apuX,apuY,apuGen);

            cout<<"La mulplicacion es: "<<*apuGen<<endl;

            break;
        case '4':
            dividir(apuX,apuY,apuGen);

            cout<<"La division es: "<<*apuGen<<endl;

            break;
        case '5':
            potencia(apuX,apuGen);

            cout<<"Potencia de X es: "<<*apuGen<<endl;

            break;
        case '6':
            potencia(apuY,apuGen);

            cout<<"Potencia de Y es: "<<*apuGen<<endl;
            break;
        case '7':
            raizCuadrada(apuX,apuGen);

            cout<<"Raiz cuadrada de X es: "<<*apuGen<<endl;

            break;
        case '8':
            raizCuadrada(apuY,apuGen);

            cout<<"Raiz cuadrada de Y es: "<<*apuGen<<endl;

            break;
        case 's':
            cout<<"saliendo del sistema"<<endl;
            break;

        }









        //Codigo para conseguir factorizar en numeros primos un numero X
        /*    int n,f;

         cout <<"Ingrese un numero > :";
         cin >>n;
         f = 2;

         while (n>1) {
           if (n%f==0) {
             cout <<f <<endl;
             n = n/f;
           }
           else
             f++;
         }

           cout << "Hello world!" << endl;
          */
    }
    while(opcion!='s');
    return 0;
}
void sumar(int *x, int *y, float *resultado)
{
    *resultado = *x + *y;
}
void restar(int *x, int *y, float *resultado)
{
    *resultado = *x - *y;
}

void dividir(int *x, int *y, float *resultado)
{
    *resultado  = 0;
    if(*y !=0)
        *resultado = *x / *y;
    else
        cout<<"No se puede hacer la division"<<endl;
}
void multiplicar(int *x, int *y, float *resultado)
{
    *resultado = *x * *y;
}
void potencia(int *valor, float *resultado)
{
    int potenciaSelec = 0;
    cout<<"Ingrese la potencia a elevar a "<<*valor<<endl;
    cin>>potenciaSelec;
    *resultado = pow(*valor,potenciaSelec);
}
void raizCuadrada(int *valor, float *resultado)
{
    *resultado = 0;
    if(*valor>=0)
    {
        *resultado = sqrt(*valor);
    }
    else
        cout<<"No se puede calcular la Raiz cuadrada"<<endl;

}

