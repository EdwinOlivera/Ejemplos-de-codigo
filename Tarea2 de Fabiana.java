import java.util.Scanner;

public class Main{
	//espacio para declarar variables globales
	
	public static void main(String [] args){
		/*espacio para declarar variables locales y todas
		las instrucciones del programa*/
		int cantidadNotas=0, opcion=0, numNotaIngresada=1;
		float nota, promedio=0, suma=0;
		boolean notaCorrecta=false;
		Scanner entrada=new Scanner(System.in);
		
		System.out.print("Ingrese la cantidad de notas para calcular el promedio: ");
		cantidadNotas=entrada.nextInt();
		
		do{
			System.out.println("***MENU***");
			System.out.println("1) Ingresar otra nota");
			System.out.println("2) Calcular promedio");
			System.out.println("3) Salir");
			System.out.print("Ingrese su opcion: ");
			opcion=entrada.nextInt();
			
			switch (opcion){
			    case 1:
				
				 System.out.println("Ingrese la nota "+numNotaIngresada);
				if (numNotaIngresada<=cantidadNotas){
					do{
						nota=entrada.nextFloat();
						if ((nota>=0) && (nota<=100)){
							suma=suma+nota;
							numNotaIngresada++;
							notaCorrecta=true;
						}else{
							System.out.println("Nota fuera de rango "+
							", Ingrese de nuevo la nota");
							notaCorrecta=false;
						}
					}while(notaCorrecta==false);
				}else{
					System.out.println("Ya se ingresaron todas las "+
					"notas, calcule el promedio");
				}
				break;
				
				case 2:
				promedio=suma/cantidadNotas;
				System.out.println("El promedio es "+ promedio);
				break;
				default :
				System.out.println("Opcion invalida, ingrese una "+
				"opcion correcta");
				break;
			}
		}while(opcion!=3);
	}
}