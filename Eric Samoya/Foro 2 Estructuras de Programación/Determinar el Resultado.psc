Algoritmo determinarResultado
	//
	Escribir "Ingrese el valor de N";
	acumN<-1;
	Leer numN;
	
	Para i<-1  Hasta numN Con Paso 1 Hacer
		
		acumN<-acumN*i;
		
	FinPara
	
	//
	acumR<-1;
	Repetir
		Repetir
			Escribir "Ingrese el valor de R // 0 <= R <= N";	
			
			Leer numR;
				
		Hasta Que numR <= numN;	
	Hasta Que 0 <= numR
	
	Para i<-1  Hasta numR Con Paso 1 Hacer
		
		acumR<-acumR*i;
		
	FinPara
	
	//
	factorialResta<-1;
	resta<-(numN - numR);
	Para i<-1  Hasta resta Con Paso 1 Hacer
		
		factorialResta<-factorialResta*i;
		
	FinPara
	
	multiplicacion <- (factorialResta * numR);
	
	division = numN/multiplicacion;
	Escribir "El resultado final es ", division;
	
FinAlgoritmo
