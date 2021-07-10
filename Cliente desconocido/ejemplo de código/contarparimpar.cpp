#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
void contarparimpar(int arreglo[3][4]);
main(){
	int nums[3][4]={0};
	printf("Ingrese 12 valores númericos: \n");
	for(int fila=0; fila<3; fila++){
		for(int col=0; col<4; col++){
			printf("nums[%d][%d]: ",fila,col);
			scanf("%d",&nums[fila][col]);
		}
		printf("\n");
	}
	contarparimpar(nums);		
}//fin del main
void contarparimpar(int arreglo[3][4]){
	int pares=0,impares=0,max=0,min=1000;
	for(int fila=0; fila<3; fila++){
		for(int col=0; col<4; col++){
			printf("\t%2d",arreglo[fila][col]);
		}
		printf("\n");
	}
	//contar numeros pares
	for(int fila=0; fila<3; fila++){
		for(int col=0; col<4; col++){
			if((arreglo[fila][col]%2)==0){
				pares++;
			}
			else{
				impares++;
			}
			if(arreglo[fila][col]>max){
				max=arreglo[fila][col];
			}
			if(arreglo[fila][col]<=min){
				min=arreglo[fila][col];
			}
		}
	}
	printf("la cantidad de pares es: %d\n",pares);
	printf("la cantidad de impares es: %d\n",impares);
	printf("El valor máximo es: %d\n",max);
	printf("El valor minimo es: %d\n",min);
	
}//fin de la funcion contarparimpar
