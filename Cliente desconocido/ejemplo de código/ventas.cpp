#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
void funcion_ventas(void);
void imprimir_arreglo(int arreglo[3][4]);
main(){
	setlocale(LC_ALL,"spanish");
	funcion_ventas();
	
}//fin del main
void funcion_ventas(void){
	int arreglo[3][4]={0,0};
	char opc;
	do{
		printf("Escriba el número de vendedor(1-3): ");	
		printf("si desea ingresar un nuevo registro presione la letra S \n");
		printf("Su opción es: ");
		scanf("%c",&opc);	
	}while((opc==115)&&(opc==83));
	imprimir_arreglo(arreglo);
	
}//fin de la funcion_ventas
void imprimir_arreglo(int arreglo[3][4]){
	printf("\t    p1 \t    p2 \t    p3 \t    p4 \n");
	for(int i=0; i<3; i++){
		printf("V%d",i+1);
		for(int h=0; h<4; h++){
		printf("\t%5d", arreglo[i][h]);	
		}
		printf("\n");
	}
		
}//fin del arreglo