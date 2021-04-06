#ifndef __CONSOLA_H_
#define __CONSOLA_H_

#include<windows.h>

//Definicion de variables para los colores de la consola
#define BG_BLACK   (0)   //0
#define BG_NAVY    (16)  //BACKGROUND_BLUE
#define BG_GREEN   (32)  //BACKGROUND_GREEN
#define BG_TEAL    (48)  //BACKGROUND_BLUE | BACKGROUND_GREEN
#define BG_MAROON  (64)  //BACKGROUND_RED
#define BG_PURPLE  (80)  //BACKGROUND_BLUE | BACKGROUND_RED
#define BG_OLIVE   (96)  //BACKGROUND_GREEN | BACKGROUND_RED
#define BG_SILVER  (112) //BACKGROUND_BLUE | BACKGROUND_GREEN | BACKGROUND_RED
#define BG_GRAY    (128) //BACKGROUND_INTENSITY
#define BG_BLUE    (144) //BACKGROUND_BLUE | BACKGROUND_INTENSITY
#define BG_LIME    (160) //BACKGROUND_GREEN | BACKGROUND_INTENSITY
#define BG_CYAN    (176) //BACKGROUND_BLUE | BACKGROUND_GREEN | BACKGROUND_INTENSITY
#define BG_RED     (192) //BACKGROUND_RED | BACKGROUND_INTENSITY
#define BG_MAGENTA (208) //BACKGROUND_BLUE | BACKGROUND_RED | BACKGROUND_INTENSITY
#define BG_YELLOW  (224) //BACKGROUND_GREEN | BACKGROUND_RED | BACKGROUND_INTENSITY
#define BG_WHITE   (240) //BACKGROUND_BLUE | BACKGROUND_GREEN | BACKGROUND_RED | BACKGROUND_INTENSITY

//Foreground (+1)
#define FG_BLACK   (0)  //0
#define FG_NAVY    (1)  //FOREGROUND_BLUE
#define FG_GREEN   (2)  //FOREGROUND_GREEN
#define FG_TEAL    (3)  //FOREGROUND_BLUE | FOREGROUND_GREEN
#define FG_MAROON  (4)  //FOREGROUND_RED
#define FG_PURPLE  (5)  //FOREGROUND_BLUE | FOREGROUND_RED
#define FG_OLIVE   (6)  //FOREGROUND_GREEN | FOREGROUND_RED
#define FG_SILVER  (7)  //FOREGROUND_BLUE | FOREGROUND_GREEN | FOREGROUND_RED
#define FG_GRAY    (8)  //FOREGROUND_INTENSITY
#define FG_BLUE    (9)  //FOREGROUND_BLUE | FOREGROUND_INTENSITY
#define FG_LIME    (10) //FOREGROUND_GREEN | FOREGROUND_INTENSITY
#define FG_CYAN    (11) //FOREGROUND_BLUE | FOREGROUND_GREEN | FOREGROUND_INTENSITY
#define FG_RED     (12) //FOREGROUND_RED | FOREGROUND_INTENSITY
#define FG_MAGENTA (13) //FOREGROUND_BLUE | FOREGROUND_RED | FOREGROUND_INTENSITY
#define FG_YELLOW  (14) //FOREGROUND_GREEN | FOREGROUND_RED | FOREGROUND_INTENSITY
#define FG_WHITE   (15) //FOREGROUND_BLUE | FOREGROUND_GREEN | FOREGROUND_RED | FOREGROUND_INTENSITY

#define COLOR_GENERAL	BG_BLACK | FG_GRAY	//Combinacion de colores para la consola
#define COLOR_ETIQUETAS BG_BLACK | FG_LIME
/*****************************************************************************
						VARIABLES PARA LAS INTERFACES DE CONSOLA
/****************************************************************************/

extern int COLOR_FONDO;
extern int COLOR_LETRA;

extern HANDLE consolaEntrada;
extern HANDLE consolaSalida;

//Prototipos de funciones
void ErrorConsola(char *mensaje);
void redimensionarBufferYVentana(HANDLE hConsola, SHORT xTam, SHORT yTam);
void IniciarConsola(char *, int, int);
void CerrarConsola();
void gotoxy(int x, int y);
void textcolor(int modo);
void textbackground(int modo);
int wherex();
int wherey();
void clrscr();
void getch1();

#endif
