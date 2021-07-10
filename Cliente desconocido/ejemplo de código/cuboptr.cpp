#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

void cubo(int *valor);
main(){
	int n;
	setlocale(LC_ALL,"SPAnish");
	printf("Escriba el valor que desea ingresar: ");
	scanf("%d",&n);
	cubo(&n);
	printf("el numero %d elevado al cubo es: %d\n",n,n);
	
	
	

	
}//fin del main
void cubo(int *valor){
	*valor * *valor * *valor;
	
	

}