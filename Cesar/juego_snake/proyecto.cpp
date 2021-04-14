
#include <windows.h>
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include<time.h>

#define ARRIBA 72
#define IZQUIERDA 75
#define DERECHA 77
#define ABAJO 80

#define tW 119
#define tA 97
#define tD 100
#define tS 115
#define ESC 27//Esta es la tecla de ESCAPE (ESC), la que se encuentra en la esquina izquierda superior de los teclados convencionales


// Definimos las variables de forma globla, asi evitamos que las funciones devuelvan algun valor o definir la misma variable en cada funcion
int cuerpo[300][2];
int n = 1, tam = 10, dir = 3;
int x = 10, y = 12;
int xc = 30, yc = 15;
int velocidad = 120;
char tecla;

void colocarCoordenada(int x, int y);
void OcultaCursor();
void pintar();
void guardar_posicion_en_movimiento();
void dibujar_cuerpo();
void borrar_cuerpo();
void teclear();
void colocarComida();
bool continuarJugando();

using namespace std;

int main()
{
    OcultaCursor();
    srand(time(NULL));
    pintar();
    colocarCoordenada(xc, yc);
    printf("%c", 70); // F (Es la primera vez que se coloca la comida en el tablero

    // Este siclo se repetira hasta que se pierda el juego
    while(tecla != ESC && continuarJugando())
    {
        borrar_cuerpo();
        guardar_posicion_en_movimiento();
        dibujar_cuerpo();
        colocarComida();
        // Se reptire la funcion para superar el lag de los inputs
        teclear();
        teclear();

        if(dir == 1)
            y--;
        if(dir == 2)
            y++;
        if(dir == 3)
            x++;
        if(dir == 4)
            x--;

        Sleep(velocidad);
    }
    pintar();
    return 0;
}

void colocarCoordenada(int x, int y)
{
    HANDLE cursoManual;
    COORD posicionesCursor;

    posicionesCursor.X = x;
    posicionesCursor.Y = y;
    cursoManual = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(cursoManual,posicionesCursor);
}
void OcultaCursor()
{
    CONSOLE_CURSOR_INFO cci = {100, FALSE};

    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cci);
}
void pintar()
{
    for(int i=2; i < 60; i++)
    {

        colocarCoordenada (i, 1);
        printf ("%c", 205);// ═══
        colocarCoordenada(i, 23);
        printf ("%c", 205);// ═══
    }

    for(int v=2; v < 23; v++)
    {
        colocarCoordenada (2,v);
        printf ("%c", 186); // ║
        colocarCoordenada(60,v);
        printf ("%c", 186); // ║
    }





    // Esquina izquierda superior
    colocarCoordenada (2,1);
    printf ("%c", 201);//╔

    // Esquina izquierda inferior
    colocarCoordenada (2,23);//╚
    printf ("%c", 200);

    // Esquina derecha superior
    colocarCoordenada (60,1);
    printf ("%c", 187);//╝

    // Esquina derecha inferior
    colocarCoordenada(60,23);// ╗
    printf ("%c", 188);
}
void guardar_posicion_en_movimiento()
{
    cuerpo[n][0] = x;
    cuerpo[n][1] = y;
    n++;
    if(n == tam)
        n = 1;
}
void dibujar_cuerpo()
{
    for(int i = 1; i < tam; i++)
    {
        colocarCoordenada(cuerpo[i][0], cuerpo[i][1]);
        printf("*");
    }
}
void borrar_cuerpo()
{
    colocarCoordenada(cuerpo[n][0], cuerpo[n][1]);
    printf(" ");
}
void teclear()
{
    if(kbhit())
    {
        tecla = getch();
        switch(tecla)
        {
        case ARRIBA :
            if(dir != 2)
                dir = 1;
            break;
        case ABAJO :
            if(dir != 1)
                dir = 2;
            break;
        case DERECHA :
            if(dir != 4)
                dir = 3;
            break;
        case IZQUIERDA :
            if(dir != 3)
                dir = 4;
            break;
        case tW :
            if(dir != 2)
                dir = 1;
            break;
        case tS :
            if(dir != 1)
                dir = 2;
            break;
        case tD :
            if(dir != 4)
                dir = 3;
            break;
        case tA :
            if(dir != 3)
                dir = 4;
            break;
        }
    }
}
void colocarComida()
{
    if(x == xc && y == yc)
    {
        // Zonas donde si puede aparecer la comidas en el tablero
        xc = (rand() % 55) + 4;
        yc = (rand() % 15) + 4;

        tam++;
        colocarCoordenada(xc, yc);
        printf("%c", 70);// F
    }
}
bool continuarJugando()
{
    if(y == 0 || y == 23 || x == 2 || x == 60)
        return false;
    for(int j = tam - 1; j > 0; j--)
    {
        if(cuerpo[j][0] == x && cuerpo[j][1] == y)
            return false;
    }
    return true;
}
