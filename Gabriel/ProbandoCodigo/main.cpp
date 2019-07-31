



#include <iostream>

#include <conio.h>
#include <math.h>
using namespace std;
main( )
{
    int n, i, j, k ;
    float a[100][100], b[100], c[100], x[100], det;

cout << endl << endl << "\n\t\t\t UTILIZANDO EL METODO DE ELIMINACION DE GAUSS " <<endl;
cout << " \t " << endl << endl  <<endl;
cout << " INTRODUCE EL NUMERO DE ECUACIONES ";
cin >> n;
cout << endl << endl;
cout << " INTRODUCE LOS COEFICIENTES DE LA MATRIZ A " << endl;

for(i=1;i<=n;i++)  // carga los coefientes de a
      {
          for(j=1;j<=n;j++)
             {
                cout<<"\n A["<<i<<"]["<<j<<"]"<<" = ";
                cin>>a[i][j];
             }
          cout<<endl;
      }

    cout<<" INTRODUCE EL VECTOR INDEPENDIENTE b  "<<endl;
    for(j=1;j<=n;j++) //carga vector independiente
      {
            cout<<" \n b["<<j<<"]["<<i<<"]"<< " = ";
            cin >>b[j];
      }
    //muestra la matriz a aumenta con sus valores independientes

    cout << " \n\t LA MATRIZ INGRESADA ES: " ;
    for(i=1;i<=n;i++)
       {
           cout << "\n\n\t " ;
           for(j=1;j<=n;j++)
             {
                cout<<a[i][j]<<"\t ";
             }
           cout << " | " << b[i];
       }
    //calcula el determinante de a // <<<<< INICIA EL METODO DE GAUSS >>>>>

    i=1;
    det=1; //paso uno
    for(i=1; i<=n-1; i=i+1)
       {
            det=det*a[i][i];
            if(det==0)
               {
                    cout<<"\n\n Hay un cero en la diagonal principal...";
                    cout<<" \n\n Su determinante es " << det << endl<<endl;

               }
            for(k=i+1;k<=n;k=k+1)
               {
                   for(j=i+1;j<=n;j=j+1)
                       {
                          a[k][j]=a[k][j]-(a[k][i]*a[i][j])/a[i][i];
                       }
                   b[k]=b[k]-(a[k][i]*b[k])/a[i][i];
                }
       } //fin del for

    det=det*a[n][n];

    if(det==0)
       {
            cout<<"Hay un cero en la diagonal principal...";
            cout<<" Su determinante es : " << det<< endl<<endl;

       }

    x[n]=b[n]/a[n][n];

    for(i=n-1; i>=1; i=i-1)
       {
           x[i]=b[i];
            for(j=i+1; j<=n; j=j+1)
                 {

                    x[i]=x[i]-a[i][j]*x[j];
                 }
            x[i]=x[i]/a[i][i];
        }

    cout << " \n\n\n\n\t\t\t SOLUCIONES " ;
    cout<<"\n\n\n  El determinante de A es ==  "<<det;
    cout<<"\n\n Los valores del vector Solucion son :  "<<endl;

    for(j=1; j<=n; j++)
       {
            cout<<"\n\t x["<<j<<"]"<<"=>"<<x[j];cout<<endl;
       }

    cout << endl<< endl;

    return 0;

}
