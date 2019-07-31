Algoritmo TrianguloIsoceles
	Escribir "El Primer angulo"
	Leer A1
	
	Escribir "El Segundo angulo"
	Leer A2
	
	Escribir "El Tercer angulo"
	Leer A3
	
	comprobar <- A1 + A2 + A3
	
	Si comprobar > 180 Entonces
		Escribir "Ha ingresado angulos incorrectos"
	SiNo
		Si A1 == A2 o A2==A3 Entonces
			Escribir "Es un triangulo Isoceles"
		SiNo
			Escribir "Es otra clase de Triangulo"
		FinSi
	FinSi
FinAlgoritmo
