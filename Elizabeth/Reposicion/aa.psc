Algoritmo sin_titulo
	Definir d1, d2, d3, d4, m, v, d Como Real;
	Leer  d1, d2, d3, d4;
	m <- (d1 + d2 + d3 + d4)/4;
	v <- ((d1-m)^2 + (d2-m)^2 + (d3-m)^2 + (d4-m)^2)/4;
	d<- rc(v);
	Escribir m;
	Escribir v;
	Escribir d;
FinAlgoritmo
