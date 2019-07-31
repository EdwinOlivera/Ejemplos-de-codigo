Proceso PromedioDependiente
	Definir TotalA, TotalB, TotalC, PromeA, PromeB, PromeC, CantArt, ValorArt, VentasA, VentasB, VentasC Como Real;
	Definir  NumeroDeVenta, turnoDependiente, i Como Entero;
	TotalA<-0; TotalB<-0; TotalC<-0; PromeA<-0; PromeB<-0; PromeC<-0; CantArt<-0; ValorArt<-0; VentasA<-0; VentasB<-0; VentasC<-0; 
	
	turnoDependiente <- 1;
	Mientras turnoDependiente <=3 Hacer
		Segun turnoDependiente Hacer
			Opcion 1:
				Escribir "Se registrara las ventas del Dependiente A";
				Escribir "Cuantos articulos Vendio?";
				Leer NumeroDeVenta;
				
				Para i<-1 Hasta NumeroDeVenta Con Paso 1 Hacer
					Escribir "Cantidad vendidas del Articulo #",i,"?";
					Leer CantArt;
					VentasA <- (VentasA + CantArt);
					Escribir "Cual es el valor del Articulo actual?";
					Leer ValorArt;
					TotalA <- (TotalA + (ValorArt*CantArt));
				Fin Para
				Si VentasA>0 Entonces
					PromeA <- (TotalA/VentasA);
				SiNo
					Escribir "No se Realizara el promedio";
				Fin Si
			Opcion 2:
				Escribir "Se registrara las ventas del Dependiente B";
				Escribir "Cuantos articulos Vendio?";
				Leer NumeroDeVenta;
				
				Para i<-1 Hasta NumeroDeVenta Con Paso 1 Hacer
					Escribir "Cantidad vendidas del Articulo #",i,"?";
					Leer CantArt;
					VentasB <- (VentasB + CantArt);
					Escribir "Cual es el valor del Articulo actual?";
					Leer ValorArt;
					TotalB <- (TotalB + (ValorArt*CantArt));
				Fin Para
				Si VentasB>0 Entonces
					PromeB <- (TotalB/VentasB);
				SiNo
					Escribir "No se Realizara el promedio";
				Fin Si
			Opcion 3:
				Escribir "Se registrara las ventas del Dependiente C";
				Escribir "Cuantos articulos Vendio?";
				Leer NumeroDeVenta;
				
				Para i<-1 Hasta NumeroDeVenta Con Paso 1 Hacer
					Escribir "Cantidad vendidas del Articulo #",i,"?";
					Leer CantArt;
					VentasC <- (VentasC + CantArt);
					Escribir "Cual es el valor del Articulo actual?";
					Leer ValorArt;
					TotalC <- (TotalC + (ValorArt*CantArt));
				Fin Para
				Si VentasC>0 Entonces
					PromeC <- (TotalC/VentasC);
				SiNo
					Escribir "No se Realizara el promedio";
				Fin Si
			De Otro Modo:
				Escribir "Fuera de Rango";
		Fin Segun
		turnoDependiente <- ( turnoDependiente + 1 ) ; 
	Fin Mientras
	Escribir "Fin de la facturacion. Dependiente F: 000000000";
	
    Escribir "Total vendido por A: ", TotalA, ". El promedio vendido de A es: ", PromeA;
    Escribir "Total vendido por B: ", TotalB, ". El promedio vendido de B es: ", PromeB;
    Escribir "Total vendido por C: ", TotalC, ". El promedio vendido de C es: ", PromeC;
	
FinProceso
