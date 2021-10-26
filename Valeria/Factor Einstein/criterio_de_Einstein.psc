Algoritmo criterio_de_Einstein
	Definir numPrimo, ordenPolinomio, numero_primo_cuadrado Como Entero;
	Definir coeficiente_ingresado Como Real;
	Definir division_ultimo_elemento, division_primer_elemento,division_normal , cumple_criterio Como Logico;
	
	division_ultimo_elemento<-Verdadero;
	division_primer_elemento<-Verdadero;
	division_normal<-Verdadero;
	cumple_criterio<-Falso;
	
	Escribir "Ingrese el numero primo a comprobar: "
	Leer numPrimo;

	numero_primo_cuadrado <- numPrimo * numPrimo;
	
	Escribir "Ingrse el orden del polinomio P(x): "
	Leer ordenPolinomio;
	ordenPolinomio <- ordenPolinomio+1;
	Dimension Coeficientes[ordenPolinomio];
	
	Para variable_numerica<-1 Hasta ordenPolinomio Con Paso 1 Hacer

		Escribir "Ingrese el valor del coeficiente #", variable_numerica;
		Leer coeficiente_ingresado;
		Coeficientes[variable_numerica] <-coeficiente_ingresado;
		
		Si variable_numerica = 1 Entonces
			Si coeficiente_ingresado MOD numero_primo_cuadrado = 0 Entonces
				division_primer_elemento<-Verdadero;
			SiNo
				division_primer_elemento<-Falso;
			Fin Si
		Fin Si
		
		Si variable_numerica < ordenPolinomio Entonces
			Si coeficiente_ingresado MOD numero_primo_cuadrado <> 0 Entonces
				division_normal<-Falso;
			Fin Si
		SiNo
			Si coeficiente_ingresado MOD numero_primo_cuadrado <> 0 Entonces
				division_ultimo_elemento<-Falso;
			Fin Si
		Fin Si
	Fin Para
	
	Si division_primer_elemento = falso Y division_ultimo_elemento = falso  Y division_normal = Verdadero Entonces
		Escribir "El polinomo NO tiene raices Racionales";
	SiNo
		Escribir "El polinomio SI tiene raices Racionales";
	Fin Si

FinAlgoritmo
