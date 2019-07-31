Algoritmo CalculoDeVuelo
	Escribir "Ingrese la primera ciudad"
	Leer C1
	Escribir "Escriba la zona horaria de esta ciudad"
	Leer Z1
	
	Escribir "Ingrese la segunda ciudad"
	Leer C2
	Escribir "Escriba la zona horaria de esta ciudad"
	Leer Z2
	
	
	Escribir "Escriba la duracio del viaje"
	Leer V
	
	Escribir "Escriba la Hora de salida"
	Leer H
	
	Si Z1>=100 || Z1<=100 Entonces
		Z1 <- Z1/100
		
	Fin Si
	Si Z2>=100 || Z2<=100 Entonces
		Z2 <- Z2/100
		
	Fin Si
	
	Si Z1>=1000 || Z1<=1000 Entonces
		Z1 <- Z1/100
		
	Fin Si
	Si Z2>=1000 || Z2<=1000 Entonces
		Z2 <- Z2/100
		
	Fin Si
	
	Si Z1>0 && Z2<0 Entonces
		T1 <- Z1
		T2 <- -1* (Z2)
		calculo <- T1 + T2
	Fin Si
	Si Z1<0 && Z2<0 Entonces
		T1 <- -1*(Z1)
		T2 <- -1* (Z2)
		calculo <- T1 - T2
	Fin Si
	Si Z1<0 && Z2>0 Entonces
		T1 <- -1*(Z1)
		T2 <- Z2
		calculo <- T1 + T2
	Fin Si
	Si Z1>0 && Z2>0 Entonces
		si Z1 > Z2 Entonces
			calculo <- Z2 - Z1
		SiNo
			calculo <- -1*(Z1 - Z2)
		FinSi
	Fin Si
	
	Escribir calculo
	calculoFinal <- V + H + calculo 
	Escribir calculoFinal
	Si calculoFinal > 24 Entonces
		calculoFinal <- calculoFinal - 24
		Si calculoFinal <= 5 Entonces
			Escribir "Hora de llegada del vuelo es a la: ", calculoFinal  " de la madrugada"
		SiNo
			Escribir "Hora de llegada del vuelo es a la: ", calculoFinal 
		Fin Si

	SiNo
		Escribir "Hora fuera de rango o se introdujo datos invalidos"
	Fin Si
	
FinAlgoritmo
