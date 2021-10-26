Algoritmo puntos_dentro_circunferencia
	Definir  numeroIngresadoX, numeroIngresadoY, RadioIngresado, numeroX, numeroY, hipotenusaPrimera, hipotenusaSegunda,  numeroRestadosX, numeroRestadosY Como Real;
	Definir  CantidadDeCalculosHechos, CantidadAciertos Como Entero;
	Definir  porcentajeAcierto Como Real;
	RadioIngresado <- 1;
	CantidadDeCalculosHechos <- 1;
	hipotenusaPrimera <- 1;
	Escribir "Ingrese el par (X, Y)";
	Escribir "X " Sin Saltar;
	leer numeroIngresadoX;
 	Escribir "Y " Sin Saltar;
	leer numeroIngresadoY;
	Escribir "Los valores ingresado son -> (",numeroIngresadoX,", ", numeroIngresadoY,")";
	Mientras RadioIngresado <> 0 Hacer
		Escribir "Ingresa un nuevo Par ordenado de (X, Y) y su respectivo Radio (r)";
		Escribir "X " Sin Saltar;
		leer numeroX;
		Escribir "Y " Sin Saltar;
		leer numeroY;
		Escribir "Ingrese el Radio en donde estara centrado "
		Escribir "r " Sin Saltar;
		Leer RadioIngresado;
		CantidadDeCalculosHechos <- CantidadDeCalculosHechos + 1;
		hipotenusaPrimera <- RC((numeroX * numeroX) + (numeroY * numeroY))
		numeroRestadosX <- numeroIngresadoX - numeroX;
		numeroRestadosY <- numeroIngresadoY - numeroY;
		hipotenusaSegunda <- RC((numeroRestadosX * numeroRestadosX) + (numeroRestadosY * numeroRestadosY))
		Si hipotenusaSegunda < hipotenusaPrimera Entonces
			hipotenusaPrimera <- hipotenusaPrimera + 1;
		Fin Si
	Fin Mientras
	porcentajeAcierto  <- hipotenusaPrimer / CantidadDeCalculosHechos;
	Si porcentajeAcierto >= 0.6 Entonces
		Escribir "SI esta contenido en la mayoria de los circulos proporcionados";
	SiNo
		Escribir "NO esta contenido en la mayoria de los circulos Proporcionado"
	Fin Si
FinAlgoritmo
