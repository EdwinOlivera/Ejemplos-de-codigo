#include <stdio.h> 
#include <iostream>
#include<stdlib.h>
using namespace std;
 
int tamanioMatriz = 0; 
void generarMatriz(int tamanioMatriz); 
  
int main(){ 
    cout<<"Inserta el tamanio de la matriz\n"; 
    cin>>tamanioMatriz; 
    generarMatriz(tamanioMatriz); 
    system("pause");
} 
 
//Funcion que generara la matriz en espiral 
void generarMatriz(int tamanioMatriz){ 
    int i,j; 
    int countTotal = 1,tamanioTotal = tamanioMatriz*tamanioMatriz; 
    int fila = 0, check = tamanioMatriz, band = 1;  
    int matrizEspiral[tamanioMatriz][tamanioMatriz]; 
 
    //Llena matriz 
    while(countTotal<=tamanioTotal){ 
        //Hacia la derecha 
        for(i=band-1; i < check; i++){ 
            matrizEspiral[fila][i] = countTotal; 
            countTotal++; 
        } 
        fila = tamanioMatriz - band; 
        check = tamanioMatriz - band;     
 
        //Hacia abajo 
        for(i=band; i <= check; i++){ 
            matrizEspiral[i][fila] = countTotal; 
            countTotal++; 
        } 
 
        //Hacia la izquierda 
        for(i=check-1; i >= (band-1) ; i--){ 
            matrizEspiral[fila][i] = countTotal; 
            countTotal++; 
        } 
         
        fila = band-1; 
 
        //Hacia arriba 
        for(i=check-1; i >= band ; i--){ 
            matrizEspiral[i][fila] = countTotal; 
            countTotal++; 
        }         
        band++; 
        fila = band-1; 
    } 
 
    //Imprimir matriz         
    for(i=0; i<tamanioMatriz; i++){ 
        for(j=0; j<tamanioMatriz; j++){ 
            printf("%d \t", matrizEspiral[i][j]); 
        } 
        printf("\n"); 
    } 
} 


