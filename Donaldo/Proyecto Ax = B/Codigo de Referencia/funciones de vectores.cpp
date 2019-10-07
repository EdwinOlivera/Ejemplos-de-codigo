#include <iostream>
#include<cmath>
using namespace std;

void leer(int X[],int);
int pe(int X[],int Y[],int);
float norma(int X[],int);
float Coseno(int X[],int Y[],int);

int main(int argc, char *argv[]) {
	int tamanio=3;
	int A[tamanio];
	int B[tamanio];
	cout<<"Valores de A"<<endl;
	leer(A,tamanio);
	cout<<"Valores de B"<<endl;
	leer(B,tamanio);
	cout<<"producto Escalar ="<<pe(A,B,tamanio)<<endl;
	cout<<"Norma de A ="<<norma(A,tamanio)<<endl;
	cout<<"Coseno ="<<Coseno(A,B,tamanio)<<endl;
	
	
	
	
	
	system("PAUSE");   
	return 0;
}


void leer(int X[],int n){
     for(int i=0;i<n;i++){
             cin>>X[i];
             }
     }


int pe(int X[],int Y[],int n){
     int suma=0;
     for(int i=0;i<n;i++){
             suma=suma+X[i]*Y[i];
             }
     return suma;
}


float norma(int X[],int n){
     float suma=0;
     for(int i=0;i<n;i++){
             suma=suma+X[i]*X[i];
             }
      suma=sqrt(suma);
      
      return suma;
      }


float Coseno(int X[],int Y[],int n){
      float cose;
      cose =pe(X,Y,n)/(norma(X,n)*norma(Y,n));
      return cose;
      }



