Proceso AlquilerDeAutoPseint
	Dimension ClientesAutos[100,100],AutosAlquilados[100,100];
	
	Escribir "Ingrese a cuantos clientes se les desea cobarar"
	Hacer
		Leer  clientN
		Si clientN<=0 o clientN>100 Entonces
			Escribir "Ha ingresado: ", (clientN), "; y es una cantidad no valida. Ingrese de nuevo la cantidad de clientes"
		Fin Si
	Hasta Que(clientN>0 y clientN<100)
	Escribir "Ingresara los costo que tendran los clientes en las siguientes  areas"
	Escribir "Costo por alquiler de auto (B1)"
	Repetir
		Leer  Base1
		Si Base1<=0
        Escribir "Ha ingresado como costo B1: ",Base1,"; y es una cantidad no validad. Ingrese de nuevo el costo B1"
		FinSi
	Hasta Que Base1>0
	
	Escribir  "Costo por kilometraje por cada auto (C1)"
	Repetir
		Leer Costo1;
		Si(Costo1<=0)
			Escribir "Ha ingresado como costo C1: ",Costo1,"; y es una cantidad no validad. Ingrese de nuevo el costo C1"
		FinSi
	Hasta Que Costo1>=0
    
	Escribir "En caso que el kilometraje sea mayor a 100km, se cobrara las siguientes tarSi as"
    Escribir "Costo por alquiler de auto (B2)"
    Repetir
		Leer Base2;
		Si (Base2<=0) 
			Escribir "Ha ingresado como costo B2: ", Base2, "; y es una cantidad no validad. Ingrese de nuevo el costo B1"
		FinSi
		Si (Base2<=Base1) 
			Escribir "Ha ingresado una cantidad igual o menor a B1, la cual es: ", Base2, "; y la cantidad de B1 es: ", Base1, ". Ingrese de nuevo la cantidad de B2"
		FinSi
		
		Hasta Que Base2>0 y Base2>Base1
    Escribir "Costo por kilometraje recorrido por auto (C2)"
    Repetir
		Leer Costo2;
		Si (Costo2<=0) 
			Escribir "Ha ingresado como costo C2: ", Costo2, "; y es una cantidad no validad. Ingrese de nuevo el costo C2"
		FinSi
			Si (Costo2<=Costo1) 
				Escribir "Ha ingresado una cantidad igual o menor a C1, la cual es: ", Costo2, "; y la cantidad de C1 es: ", Costo1, ". Ingrese de nuevo la cantidad de C2"
			FinSi	
	Hasta Que Costo2>0 y Costo2>Costo1
	
    Para i<-1 Hasta clientN Con Paso 1 Hacer
		Escribir "Datos del cliente numero: " , i
		Escribir "¿Cuantos autos alquilo este cliente?" 
		Leer NumeroDeAutos;
		ClientesAutos[i,1] = NumeroDeAutos;//3
		Para j<-1 Hasta NumeroDeAutos Con Paso 1 Hacer
			Escribir "Ingrese los datos del auto numero: ", j
			Escribir "Ingrese el kilometraje de este auto" 
			Repetir
				Leer temporal;
				Si(temporal<0)
				Escribir "No tiene sentido la cantidad ingresada. Ingrese un numero positivo" 
				FinSi
				AutosAlquilados[i,j]=temporal;
			Hasta Que temporal>0
		Fin Para
	Fin Para
	
	Escribir "se mostrara la cantidad que debe pagar cada cliente, con su inoformacion" 
	
	Para m<-1 Hasta clientN Con Paso 1 Hacer
		Escribir "Se mostrara la informacion cliente numero: ", m
		Escribir  "El numero de autos que alquilo este cliente son: ",ClientesAutos[m,1]	
		Para n<-1 Hasta ClientesAutos[m,1] Con Paso 1 Hacer
			Si AutosAlquilados[m,n]>100
				Escribir "El kilometraje es mayor a 100, por lo tanto se usara el C2 y B2, en este auto" 
				acuCosto = Costo2 *AutosAlquilados[m,n];
				acuBase = Base2;
			Sino
				acuCosto = Costo1 * AutosAlquilados[m,n];
				acuBase = Base1;
			FinSi
			CostoParcial = acuCosto;
			BaseParcial = acuBase;
			Escribir "Lo facturado por el auto numero: ", n
			Escribir "Costo por el kilometraje, es:" 
			Escribir CostoParcial;
			Escribir "Costo por el alquiler del auto, es:" 
			Escribir BaseParcial;
			BaseTotal = BaseTotal + BaseParcial;
			CostoTotal = CostoTotal + CostoParcial;
		Fin Para
		
		Escribir "Los totales a pagar por este cliente es:" 
		Escribir "Total a pagar por el alquiler de ", ClientesAutos[m,1], " auto(s) es de = ", BaseTotal 
		
		Escribir "Total a pagar porla sumatoria de los kilometrajes de lo(s) auto(s) es de = ", CostoTotal 
		
	Fin Para
FinProceso
