/*******************************************************************************

                                      LIBRERIA CONSOLA
                                      ================
Autor: 
       -  Iván A. Sipirán Mendoza
          Ingeniero Informático - Universidad Nacional de Trujillo

Esta librería ha sido creada con la finalidad de hacer sencillo el uso de la
consola de windows. Permite limpiar la pantalla, esperar por entradas de usuario,
cambiar el color del texto y del fondo, localizar el cursor, etc. 

Esta librería usa los nombres de las antiguas funciones de la librería conio.h 
del Turbo C++ de manera que programar en consolas de windows sea tan igual como 
con la consola de DOS.


COPYRIGHT
=========

Esta librería es gratuita. La única restricción es que no debes borrar los
créditos del autor de la cabecera de este archivo. 
*******************************************************************************/



#include <iostream>
#include "CONSOLA.H"

using namespace std;

extern HANDLE consolaEntrada = INVALID_HANDLE_VALUE;
extern HANDLE consolaSalida  = INVALID_HANDLE_VALUE;

extern int COLOR_FONDO = BG_BLACK;
extern int COLOR_LETRA = FG_WHITE;


void ErrorConsola(char *mensaje){
	cout<<mensaje;
	exit(1);
}

void redimensionarBufferYVentana(HANDLE hConsola, SHORT xTam, SHORT yTam)
{
  CONSOLE_SCREEN_BUFFER_INFO csbi;
  BOOL retorno;
  SMALL_RECT RectanguloVentana;
  COORD coordenadasPantalla;

  retorno = GetConsoleScreenBufferInfo(hConsola, &csbi);
  coordenadasPantalla = GetLargestConsoleWindowSize(hConsola);
  RectanguloVentana.Right = (SHORT) (min(xTam, coordenadasPantalla.X) - 1);
  RectanguloVentana.Bottom = (SHORT) (min(yTam, coordenadasPantalla.Y) - 1);
  RectanguloVentana.Left = RectanguloVentana.Top = (SHORT) 0;
  coordenadasPantalla.X = xTam;
  coordenadasPantalla.Y = yTam;
  if ((DWORD) csbi.dwSize.X * csbi.dwSize.Y > (DWORD) xTam * yTam)
    {
    retorno = SetConsoleWindowInfo(hConsola, TRUE, &RectanguloVentana);
    retorno = SetConsoleScreenBufferSize(hConsola, coordenadasPantalla);
    }
  if ((DWORD) csbi.dwSize.X * csbi.dwSize.Y < (DWORD) xTam * yTam)
    {
    retorno = SetConsoleScreenBufferSize(hConsola, coordenadasPantalla);
    retorno = SetConsoleWindowInfo(hConsola, TRUE, &RectanguloVentana);
    }
  return;
}

//Procedimiento que prepara la consola para ser usada por la aplicacion
void IniciarConsola(char *cadena, int tamX, int tamY){
	
	char tituloVentana[100];

	strcpy(tituloVentana, cadena);

	int tamanoVentanaX = tamX;
	int tamanoVentanaY = tamY;

	if(!SetConsoleTitle(tituloVentana)){
		ErrorConsola("No se puede poner titulo");
	}

    if((consolaEntrada = GetStdHandle(STD_INPUT_HANDLE)) == INVALID_HANDLE_VALUE)
    {
        ErrorConsola("No se puede crear consola de entrada");
    }

    if((consolaSalida = GetStdHandle(STD_OUTPUT_HANDLE)) == INVALID_HANDLE_VALUE)
    {
        ErrorConsola("No se puede crear consola de salida");
    }
	redimensionarBufferYVentana(consolaSalida,tamanoVentanaX,tamanoVentanaY);
	if(!SetConsoleTextAttribute(consolaSalida,COLOR_FONDO | COLOR_LETRA))
    {
        ErrorConsola("No se puede asignar colores al texto y fondo");
    }

}

//Procedimiento que cierra los manipuladores de la consola
void CerrarConsola(){
	if(consolaEntrada != INVALID_HANDLE_VALUE)
    {
        CloseHandle(consolaEntrada);
        consolaEntrada = INVALID_HANDLE_VALUE;
    }

    if(consolaSalida != INVALID_HANDLE_VALUE)
    {
        CloseHandle(consolaSalida);
        consolaSalida = INVALID_HANDLE_VALUE;
    }
}

void gotoxy(int x, int y){
	COORD posicion;
	posicion.X = (SHORT)x;
	posicion.Y = (SHORT)y;

	if(!SetConsoleCursorPosition(consolaSalida, posicion))
    {
        ErrorConsola("No se puede cambiar la posicion del cursor");
    }

}

void textcolor(int modo){

	COLOR_LETRA = modo;
	if(!SetConsoleTextAttribute(consolaSalida,COLOR_FONDO | COLOR_LETRA))
	{
			ErrorConsola("No se puede cambiar el color de texto o fondo");
	}
}

void textbackground(int modo){

	COLOR_FONDO = modo;
	if(!SetConsoleTextAttribute(consolaSalida,COLOR_FONDO | COLOR_LETRA))
	{
			ErrorConsola("No se puede cambiar el color de texto o fondo");
	}
}

int wherex(){
	CONSOLE_SCREEN_BUFFER_INFO consola;

	if(!GetConsoleScreenBufferInfo(consolaSalida,&consola)){
		ErrorConsola("No se puede extraer coordenadas del cursor");
	}

	return consola.dwCursorPosition.X;
}

int wherey(){
	CONSOLE_SCREEN_BUFFER_INFO consola;

	if(!GetConsoleScreenBufferInfo(consolaSalida,&consola)){
		ErrorConsola("No se puede extraer coordenadas del cursor");
	}

	return consola.dwCursorPosition.Y;
}

void clrscr(){
	system("cls");
}

void getch1(){
     system("PAUSE");
     }
