
#include <windows.h>
#include <iostream>
#include <stdlib.h>
#include <conio.h>

#define ARRIBA 72
#define IZQUIERDA 75
#define DERECHA 77
#define ABAJO 80
#define ESC 27


// Definimos las variables de forma globla para no definierlas en cada funcion
int cuerpo[200][2];
int n = 1, tam = 10, dir = 3;
int x = 10, y = 12;
int xc = 30, yc = 15;
int velocidad = 120;
char tecla;

void gotoxy(int x, int y);
void OcultaCursor();
void pintar();
void guardar_posicion();
void dibujar_cuerpo();
void borrar_cuerpo();
void teclear();
void comida();
bool game_over();

int main()
{
    OcultaCursor();

    pintar();
    gotoxy(xc, yc);
    printf("%c", 70);

// Este siclo se repetira hasta que se pierda el juego
    while(tecla != ESC && game_over())
    {
        borrar_cuerpo();
        guardar_posicion();
        dibujar_cuerpo();
        comida();
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

void gotoxy(int x, int y)
{
    HANDLE hCon;
    COORD dwPos;

    dwPos.X = x;
    dwPos.Y = y;
    hCon = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(hCon,dwPos);
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
        gotoxy (i, 1);
        printf ("%c", 205);
        gotoxy(i, 23);
        printf ("%c", 205);
    }
    for(int v=2; v < 23; v++)
    {
        gotoxy (2,v);
        printf ("%c", 186);
        gotoxy(60,v);
        printf ("%c", 186);
    }

    // Esquina izquierda superior
    gotoxy (2,1);
    printf ("%c", 201);
    // Esquina izquierda inferior
    gotoxy (2,23);
    printf ("%c", 200);
    // Esquina derecha superior
    gotoxy (60,1);
    printf ("%c", 187);
    // Esquina derecha inferior
    gotoxy(60,23);
    printf ("%c", 188);
}
void guardar_posicion()
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
        gotoxy(cuerpo[i][0], cuerpo[i][1]);
        printf("*");
    }
}
void borrar_cuerpo()
{
    gotoxy(cuerpo[n][0], cuerpo[n][1]);
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
        }
    }
}
void comida()
{
    if(x == xc && y == yc)
    {
        // Zonas donde si puede aparecer la comida en el tablero
        xc = (rand() % 57) + 4;
        yc = (rand() % 18) + 4;

        tam++;
        gotoxy(xc, yc);
        printf("%c", 70);
    }
}
bool game_over()
{
    if(y == 0 || y == 24 || x == 2 || x == 61)
        return false;
    for(int j = tam - 1; j > 0; j--)
    {
        if(cuerpo[j][0] == x && cuerpo[j][1] == y)
            return false;
    }
    return true;
}
