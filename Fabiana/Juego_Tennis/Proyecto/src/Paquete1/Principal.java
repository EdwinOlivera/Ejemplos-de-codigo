package Paquete1;

import java.util.Random;
import java.util.Scanner;


public class Principal {
	public static void main(String [] args){
		//Variables
		String jugador1;
		String jugador2;
		String Direccion1;
		int Direccion;
		int puntos1;
		int puntos2;
	
		
		//ArregloJugadores
		String[] array = {"Alexander Zverev","Serena Williams","Rafael Nadal","Naomi Osaka","Kei Nishikori"};
		
		//Random
		Random rdm = new Random();
		
		//ConfiguracionDeLosJUGADORES
		Scanner entrada = new Scanner(System.in);
		System.out.print("¨US OPEN¨");
		System.out.print("\nIngrese el nombre del Jugador 1: ");
		jugador1 = entrada.nextLine();
		System.out.print("\nEl jugador 1: "+jugador1);
		jugador2 = array[rdm.nextInt(array.length)]; 
		System.out.printf("\nEl jugador 2: "+jugador2);
		System.out.printf("\n");
		
		//Ciclos
		System.out.printf("\nSaca: "+jugador1);
		System.out.printf("\nIngrese el numero de la Direccion deseada: \n1.DERECHA \n2.IZQUIERDA\n");
		Direccion = entrada.nextInt();
		if(Direccion==1){
			Direccion1= "Derecha";
		}else{
			Direccion1= "Izquierda";
		}
		System.out.printf("\nDireccion1: "+Direccion1);
		
		
		
		/*
		if(Direccion1==Devolucion2){
			puntos2=15;
			System.out.printf("\nPunto para: "+jugador2);
			System.out.printf("\n"+jugador2+": 15");
		}else{
			puntos1=15;
			System.out.printf("\nPunto para: "+jugador1);
		}
		*/
		
		
		
      }
		

}
