Algoritmo Operaciones_Elementales
	Escribir "Escoja que operaciones quiere hacer:"
	Escribir "1= Sumar"
	Escribir "2= Restar"
	Escribir "3= Multiplicar"
	Escribir "4= Dividir"
	
	
	Leer n
	C<-0
	Segun n Hacer
		opcion 1:
			Escribir "Ingrese los dos numero para sumar"
			Escribir "Primer numero"
			Leer a
			Escribir "Segundo Numero"
			Leer b
			
			C <- a + b
		Opcion 2:
			Escribir "Ingrese los dos numero para Restar"
			Escribir "Primer numero"
			Leer a
			Escribir "Segundo Numero"
			Leer b
			
			C <- a - b
		Opcion 3:
			Escribir "Ingrese los dos numero para Multiplicar"
			Escribir "Primer numero"
			Leer a
			Escribir "Segundo Numero"
			Leer b
			
			C <- a * b
		Opcion 4:
			Escribir "Ingrese los dos numero para Dividir"
			Escribir "Primer numero"
			Leer a
			Escribir "Segundo Numero"
			Leer b
			Si b=0 Entonces
				Escribir "No se puede realizar la division, debido a que el segundo numero es un Cero"
			SiNo
				C <- a + b
			Fin Si
			
		De Otro Modo:
			Escribir "No ha escogino inguna opcion valida"
	Fin Segun
	
	Si b<0 || b>0 Entonces
		Escribir "El resultado de la operacion seleccionada es: ",c 
	SiNo
		Escribir "No se realizo ninguna operacion"
	Fin Si
	
	
	
FinAlgoritmo
