#include <iostream>
#include <time.h>
#include <math.h>
#include <cstdlib>
#include <iomanip>
using namespace std;
    //Funciones
    void DiagonalEnUno(int, float X[][100], float, float B[][1]);
    void CrearMatrizIdentidad(float,int, float X[][100],float B[][1], int, int, float, float);
int main()
{
    int N= 4;
    srand(time(NULL));
    N = rand()%10+2;
    int a = 1;
    int C = 0;
    int f = N-2;
    int g = N-1;
    float aux=0;
    float eliminar = 0;
    float diagonal=1;
    float Eliminar_B = 0;
    float elemento_Permanente1;
    float elemento_Permanente2;
    float Renglon_Evaluar=0;

    int opcion = 1;

    float Recorrido;

    //Matriz
    float X[100][100];

    float B[100][1];
for(int RecorridoTotal =0; RecorridoTotal<1; RecorridoTotal++){

  cout << "Iniciando la aplicacion" << endl;


    cout<<"        <<<<Metodo de Gauss >>>>         ";
cout<<"\n Matriz cuadrada de orden N= ";
cin>>N;
cout<<"\n Digite los elementos de la matriz en la posicion ";
for(int i=0;i<N;i++)
{
for(int j=0;j<N;j++)
{
cout<<"\n M=["<<i+1<<","<<j+1<<"]= ";
cin>>X[i][j];
}
cout<<"\n Termino independiente de X"<<i+1<<" ";
cin>>B[i][0];

}

    cout<<endl;
    cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
    cout<<"Imprimiendo la  matriz original"<<endl;
    for(int i=0; i < N; i++)
    {
        for(int j=0; j< N; j++ )
        {
            cout << setw(3);
            cout <<"|"<< X[i][j]<<"|";

            if (j==N-1)
            {
                cout<<endl;
            }
        }

    }
      cout<<"Imprimiendo la matriz (vector Columna) B Original"<<endl;
    for(int i=0; i < N; i++)
    {
        aux=B[i][0];

         cout <<"    |"<<setprecision(5)<<aux<<"|"<<endl;

    }    cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
    cout<<"<--------------------------------------------------------------->"<<endl;
    cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
//Haciedo uno (1) al primer elemento
    if (X[0][0]!=1)
    {
        float F= X[0][0];
        B[0][0] = B[0][0]/F;
        for(int k=0; k < N; k++)
        {
            X[0][k] = (X[0][k])/(F);
        }
    }
    //Haciendo ceros los elemetos debajo de la diagonal principal
    for(int Ceros=0;Ceros<N; Ceros++){
    for(int Fila=a; Fila<N; Fila++)
    {
        aux=X[Fila][Ceros];
        elemento_Permanente2 = (-1)*(aux);
        for(int Columnas=C; Columnas<N; Columnas++)
        {
            elemento_Permanente1= X[Ceros][Columnas];
            Renglon_Evaluar = elemento_Permanente2;
            eliminar = elemento_Permanente1*Renglon_Evaluar;
            X[Fila][Columnas]= X[Fila][Columnas] + eliminar;


        }
        Eliminar_B = elemento_Permanente2 * B[Ceros][0];
        B[Fila][0] = B[Fila][0]+ Eliminar_B;

       //Funcion que hace UNO (1) a todo los elementos de la diagonal principal
         DiagonalEnUno(N, X, diagonal,B);
    }

    a+=1;//Inicia en UNO (1)
    C+=1;//Inicia en CERO (0)
    }


    cout<<"Imprimiendo la nueva matriz. Despues de las operacions De GAUSS"<<endl;
    for(int i=0; i < N; i++)
    {
        for(int j=0; j< N; j++ )
        {
            cout << setw(3);
            aux=X[i][j];
            if(aux == 0){
                X[i][j]= aux*aux;
                aux=X[i][j];
            }

            cout <<"|"<<setprecision(5)<<aux;
            if (j==N-1)
            {
                cout<<endl;
            }
        }

    }
    cout<<"-------------------------/*/*-------------------------"<<endl;
    cout<<"Imprimiendo la matriz B. Los componentes independientes"<<endl;
    for(int i=0; i < N; i++)
    {
        aux=B[i][0];
        cout<<"El componente X"<<i+1<<" Es: ";

         cout <<"|"<<setprecision(5)<<aux<<"|"<<endl;

    }

    cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
    cout<<endl;
    do{
            //Pregunta si se quiere crear la matriz identidad, usando la matriz anterior
    cout<<"¿Desea crea la matriz anterior en una matriz Identidad?"<<endl;
    cout<<"1 = Si"<<endl;
    cout<<"2 = Salir del sistema"<<endl;
    cout<<endl;
    cout<<"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"<<endl;
    cout<<"------------------------------> :";
    cin >> opcion;
    cout<<"*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"<<endl;
    cout<<endl;

    switch(opcion){
    case 1:
        CrearMatrizIdentidad(aux,N,X,B,f,g,Recorrido,eliminar);
        break;
    case 2:
        cout<<"Se ha salido del sistema. :\")";
        break;
    default:
        cout<<"no se reconoce la opcion que ha ingresado. Ingrese de nuevo el numero"<<endl;
        cout<<"------///-------------------/*/*----------------///---------"<<endl;
        cout<<endl;
        break;

    }

    }while(opcion<1 || opcion>2);
}
    return 0;

}
 void DiagonalEnUno(int N, float X[][100], float diagonal, float B[][1]){
    for (int D=1; D<N; D++)
    {
        diagonal = X[D][D];
        for (int M=1; M<N; M++)
        {
            X[D][M] = (X[D][M])/(diagonal);
        }
        B[D][0]= B[D][0]/(diagonal);

    }
    }

    //Lineas de codigo para crear la matriz Identdad
    void CrearMatrizIdentidad(float aux,int N, float X[][100],float B[][1], int f, int g, float Recorrido, float eliminar){
    float Eliminar_B = 0;
    float Elemento_Previo_B = 0 ;
    float Elemento_Siguiente_B = 0;
    for(int Matriz = 0; Matriz<N-1; Matriz++){
    for (int Columnas=g; Columnas>0; Columnas--){
        for(int Filas =f; Filas>=0; Filas--){
                Recorrido = X[Filas][Columnas];
                eliminar = -1*(Recorrido);
                X[Filas][Columnas] = X[Filas][Columnas] + eliminar;

                //Realizar las operaciones en el Vector vertical B[X1]
                Elemento_Previo_B = B[Columnas][0];//Selecciona el elemento de una fila abajo de la fila a evaluar
                Eliminar_B = Elemento_Previo_B * eliminar;//No se como explicar esta parte.
                Elemento_Siguiente_B = B[Filas][0];//Selecciona el elemento de la fila superior a evaluar
                B[Filas][0] = Elemento_Siguiente_B + Eliminar_B;//Realiza la operacion requerida en la fila correspondiente.
        }

            f=f-1;//N-2 = 4-2 = 2,1,0
    }
        g=g-1;//N-1 = 4-1=3,2,1,0

    }

    cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
    //Imprimiendo la matriz, despues de haber hecho los calculos de Gauss-Jordan
        cout<<"Imprimiendo la nueva matriz Identidad"<<endl;
    for(int i=0; i < N; i++)
    {
        for(int j=0; j< N; j++ )
        {
            cout << setw(3);
            aux=X[i][j];
            if(aux == 0){
                X[i][j]= aux*aux;
                aux=X[i][j];
            }

            cout <<"|"<<setprecision(5)<<aux;
            if (j==N-1)
            {
                cout<<endl;
            }
        }

    }
    cout<<endl;

    //Imprimiendo las incognitas
    cout<<"Imprimiendo la matriz B, Despues de las operaciones de Gauss-Jordan"<<endl;
    for(int i=0; i < N; i++)
    {
        aux=B[i][0];
        cout<<"El componente X"<<i+1<<" Es: ";

         cout <<"|"<<setprecision(5)<<aux<<"|"<<endl;

    }
        cout<<"*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/"<<endl;
}
