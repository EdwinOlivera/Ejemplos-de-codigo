#include <iostream>
#include <time.h>
#include <math.h>
#include <cstdlib>
#include <iomanip>
using namespace std;
char jump= '\n';
/** Resolver el sistema 2x2 con modelo {ax + by = c; dx + ey =f;
Para este ejercicio yo utilice el método de igualación **/
int main()
{

    int a = 1;
    int b= 0;
    int eliminar = 0;
    srand(time(NULL));

    int N= rand()%5+2;

    float X[N][N];
    int B[N];

    for(int i=0; i < N; i++){
        for(int j=0; j< N; j++ ){
        do{
        X[i][j] = rand()%9+1;
        }while(X[j][j]==0);
        }

    }

    for(int i=0; i < N; i++){
        for(int j=0; j< N; j++ ){
                cout << setw(3);
        cout <<" "<< X[i][j];
    if (j==N-1){
        cout<<endl;
    }
        }

    }

        //do{

    cout<<"---------------"<<endl;
    //Haciedo uno (1) al primer elemento
         if (X[0][0]!=1){
                float F= X[0][0];
            for(int k=0; k < N; k++){
                    X[0][k] = (X[0][k])/(F);
                    cout<<"<--------------->"<<endl;
            }
                }
                //Verificando si hay Ceros (abajo del 1)

                do{
                    for (int M=a; M<N; M++){
                            cout<<"< Haciedo Cero a los elementos  >"<<endl;
                        if(X[M][b]!=0){
                            eliminar = -1*X[M][b];
                            for(int L=b; L<N; L++){
                                X[M][L] = X[M][L] + eliminar;

                            }
                        }
                    }
                    a+=1;
                    b+=1;
                    cout<<b<<endl;
                }while(a<N);



                cout<<"Imprimiendo la nueva matriz"<<endl;
     for(int i=0; i < N; i++){
        for(int j=0; j< N; j++ ){
                cout << setw(3);

        cout <<" "<<setprecision(1)<< X[i][j];
    if (j==N-1){
        cout<<endl;
    }
        }

    }

    return 0;
}
