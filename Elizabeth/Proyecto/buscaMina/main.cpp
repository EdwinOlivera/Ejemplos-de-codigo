#include <bits/stdc++.h> // Apuntadores
#include <iostream>
#include <time.h>
#include <stdlib.h>

// Variables contastes
#define MAXDIMENSION 15
#define MAXMINAS 20

// Variables declaradas globalmente
int dimensionTablero;
int MINAS; // Numero de minas que habra en el tablero

bool pasicionValida(int fila, int columna);
bool pasicionValidaUnaVez(int fila, int columna);
bool comprobarMina(int fila, int columna, char tablero[][MAXDIMENSION]);
void realizarMovimiento(int *x, int *y);
void dibujarTablero(char miTablero[][MAXDIMENSION]);
void colocarMinas(int minas[][2], char tableroPrincipal[][MAXDIMENSION]);
void inicializarTableroPrincipal(char tableroPrincipal[][MAXDIMENSION], char miTablero[][MAXDIMENSION]);
void remplazarMina(int fila, int columna, char tablero[][MAXDIMENSION]);
void iniciarJuego();
bool seguirJugando(char miTablero[][MAXDIMENSION], char tableroPrincipal[][MAXDIMENSION], int minas[][2], int fila, int columna, int *movFaltantes);
int conteoMinasAdyacente(int fila, int columna, int minas[][2], char tableroPrincipal[][MAXDIMENSION]);

using namespace std;

int main()
{

    srand(time(0));

    double porcentajetMinas = 12;
    do{

        cout<<"Ingre la dimiension del tablero (min = 6, max = 15)"<<endl;
        cin>>dimensionTablero;

    }while(dimensionTablero>15 || dimensionTablero<6);

    porcentajetMinas  = 11 + rand() % (10);
    MINAS = porcentajetMinas;
   iniciarJuego ();

    return (0);
}

// Verificamos la ubicacion seleccionada
bool pasicionValida(int fila, int columna)
{

    // Retorna true si se esta en el rango
    return (fila >= 0) && (fila < dimensionTablero) &&
               (columna >= 0) && (columna < dimensionTablero);
}

bool pasicionValidaUnaVez(int fila, int columna)
{
    return (fila >= 0) && (fila < dimensionTablero) && (columna >= 0) && (columna < dimensionTablero);

}


// Verifica si es o no una mina
bool comprobarMina (int fila, int columna, char tablero[][MAXDIMENSION])
{
    if (tablero[fila][columna] == '*')
        return true;
    else
        return false;
}

// Este es el mensaje que se muestra en pantalla para meter las coordenadas del tablero
void realizarMovimiento(int *x, int *y)
{
    cout<<"Ingrese coordenadas de movimiento, (Fila, Columna): "<<endl;
    cout<<"Fila: ";
    cin>>*x;
    cout<<"Columna: ";
    cin>>*y;

}

// Con esta funcion se dibuja el tablero en cada movimiento del usuario
void dibujarTablero(char miTablero[][MAXDIMENSION])
{
    int i, j;

    cout<<"  ";

    for (i=0; i<dimensionTablero; i++)
        cout<<" "<<i;

    cout<<"\n\n";

    for (i=0; i<dimensionTablero; i++)
    {
        cout<<' '<<i;

        for (j=0; j<dimensionTablero; j++)
            cout<<' '<< miTablero[i][j];
        cout<<"\n";
    }

}


// Cuenta la cantidad de minas contiguas
int conteoMinasAdyacente(int fila, int columna, int minas[][2],char tableroPrincipal[][MAXDIMENSION])
{
    int cantidad = 0;

    //----------- Casilla norte (arriba-centro) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila-1, columna) == true)
    {
        if (comprobarMina (fila-1, columna, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla sur (abajo - centro) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila+1, columna) == true)
    {
        if (comprobarMina (fila+1, columna, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla Este (Derecha-centro) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila, columna+1) == true)
    {
        if (comprobarMina (fila, columna+1, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla Oeste (izquierda-centro) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila, columna-1) == true)
    {
        if (comprobarMina (fila, columna-1, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla Noreste (arriba-derecha, derecha-arriba) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila-1, columna+1) == true)
    {
        if (comprobarMina (fila-1, columna+1, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla noroeste (arriba-izquierda, izquierda-arriba) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila-1, columna-1) == true)
    {
        if (comprobarMina (fila-1, columna-1, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla sur-este (abajo-derecha, derecha-abajo) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila+1, columna+1) == true)
    {
        if (comprobarMina (fila+1, columna+1, tableroPrincipal) == true)
            cantidad++;
    }

    //----------- Casilla suroeste (abajo-izquierda, izquierda-abajo) ------------

    // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
    if (pasicionValida (fila+1, columna-1) == true)
    {
        if (comprobarMina (fila+1, columna-1, tableroPrincipal) == true)
            cantidad++;
    }

    return (cantidad);
}

// Funcion que hace que se siga jugando hasta que se termine el juego (ganar o perder) y la funcion es recursiva
bool seguirJugando(char miTablero[][MAXDIMENSION], char tableroPrincipal[][MAXDIMENSION], int minas[][2], int fila, int columna, int *movFaltantes)
{


    // El caso final de la recursividad y ocurre cuando se encuentra una MINA
    if (miTablero[fila][columna] != '-')
        return false;

    int i;

    // Condicion final para perder definitivamente el juego
    if (tableroPrincipal[fila][columna] == '*')
    {
        miTablero[fila][columna]='*';

        for (i=0; i<MINAS; i++)
            miTablero[minas[i][0]][minas[i][1]]='*';

        dibujarTablero (miTablero);
        cout<<"\n Has perdido! :-( \n";
        return true ;
    }else
    {

        int cantidad = conteoMinasAdyacente(fila, columna, minas, tableroPrincipal);
        (*movFaltantes)--;

        miTablero[fila][columna] = cantidad + '0';

        if (!cantidad)
        {

            //----------- Casilla norte (arriba-centro) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila-1, columna) == true)
            {
                if (comprobarMina (fila-1, columna, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila-1, columna, movFaltantes);
            }

            //----------- Casilla sur (abajo - centro) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila+1, columna) == true)
            {
                if (comprobarMina (fila+1, columna, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila+1, columna, movFaltantes);
            }

            //----------- Casilla Este (Derecha-centro) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila, columna+1) == true)
            {
                if (comprobarMina (fila, columna+1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila, columna+1, movFaltantes);
            }

            //----------- Casilla Oeste (izquierda-centro) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila, columna-1) == true)
            {
                if (comprobarMina (fila, columna-1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila, columna-1, movFaltantes);
            }

            //----------- Casilla Noreste (arriba-derecha, derecha-arriba) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila-1, columna+1) == true)
            {
                if (comprobarMina (fila-1, columna+1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila-1, columna+1, movFaltantes);
            }

            //----------- Casilla noroeste (arriba-izquierda, izquierda-arriba) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila-1, columna-1) == true)
            {
                if (comprobarMina (fila-1, columna-1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila-1, columna-1, movFaltantes);
            }

            //----------- Casilla sur-este (abajo-derecha, derecha-abajo) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila+1, columna+1) == true)
            {
                if (comprobarMina (fila+1, columna+1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila+1, columna+1, movFaltantes);
            }

            //----------- Casilla suroeste (abajo-izquierda, izquierda-abajo) ------------

            // unicamente suma la cantidad de Minas encontradas abyacentemente a la ubicacion ingresada (sin mostrarlas)
            if (pasicionValida (fila+1, columna-1) == true)
            {
                if (comprobarMina (fila+1, columna-1, tableroPrincipal) == false)
                    seguirJugando(miTablero, tableroPrincipal, minas, fila+1, columna-1, movFaltantes);
            }
        }

        return false;
    }
}

void colocarMinas(int minas[][2], char tableroPrincipal[][MAXDIMENSION])
{
    bool marcas[MAXDIMENSION*MAXDIMENSION]; // 6 = 36 (6 x 6)
// Documentacion oficial
    memset (marcas, false, sizeof (marcas));
    for (int i=0; i<MINAS; )
    {
        // i = 0
        // i = 1
        int random = rand() % (dimensionTablero*dimensionTablero); // 1500 % 36 = 0 - 36
        int x = random / dimensionTablero;
        int y = random % dimensionTablero;


        if (marcas[random] == false) // marcas[3]== false, marcas[3]== true
        {
            minas[i][0]= x;
            minas[i][1] = y;

            // Colocamos la mina en el tablerow
            tableroPrincipal[minas[i][0]][minas[i][1]] = '*';
            marcas[random] = true;
            i++;
        }

    }


}


void inicializarTableroPrincipal(char tableroPrincipal[][MAXDIMENSION], char miTablero[][MAXDIMENSION])
{

    srand(time (NULL));

    for (int i=0; i<dimensionTablero; i++)
    {
        for (int j=0; j<dimensionTablero; j++)
        {
            miTablero[i][j] = tableroPrincipal[i][j] = '-'; //
        }
    }


}

void remplazarMina (int fila, int columna, char tablero[][MAXDIMENSION])
{
    for (int i=0; i<dimensionTablero; i++)
    {
        for (int j=0; j<dimensionTablero; j++)
        {
            // Verifica si la ubicion ingresada hay una mina para que reemplazara
            // y asi dar al jugador una jugada "limpia" y que no pierda
            if (tablero[i][j] != '*')
            {
                tablero[i][j] = '*';
                tablero[fila][columna] = '-';

            }
        }
    }

}

// La funcion que inicia le juego
void iniciarJuego ()
{
    // Variable que verifica el estado del juego
    bool gameOver = false;

    // La contruccion del tablero inicial (tableroPrincipal) el cual no cambia en el todo el juego
    // Y el tablero que mirara el jugador (miTablero) el cual cabia con cada jugada correcta
    char tableroPrincipal[MAXDIMENSION][MAXDIMENSION], miTablero[MAXDIMENSION][MAXDIMENSION];
                        // Dimencion del tablero         //Cantidad de minas
    int movFaltantes = dimensionTablero * dimensionTablero - MINAS, x, y;
    int minas[MAXMINAS][2]; // Almacena las corredenas de las minas. (sin colocarlas en el tablero)

    inicializarTableroPrincipal (tableroPrincipal, miTablero);

    // Colocando las minas aleatoriamente en el tablero
    colocarMinas (minas, tableroPrincipal);


    int currentMoveIndex = 0;
    while (gameOver == false)
    {

        cout<<"<--------------------------------> \n";
        dibujarTablero (miTablero);
        realizarMovimiento (&x, &y); // Accedemos al  espacio en memoria

        // Esto garantiza que el primer movimiento siempre sea libre de mina
        if (currentMoveIndex == 0)
        {
            // En el primer movimiento evitamos que el juegador toque una mina, para que tenga oportunidad de jugar al menos 2 turnos
            if (comprobarMina (x, y, tableroPrincipal) == true)
                remplazarMina (x, y, tableroPrincipal);
        }


        currentMoveIndex ++;
        if (pasicionValidaUnaVez (x, y) == false)
        {
            cout<<"\n>>>>>>> Fuera de rango. Ubicacion no valida\n"<<endl;
        }
        gameOver = seguirJugando (miTablero, tableroPrincipal, minas, x, y, &movFaltantes);

        if ((gameOver == false) && (movFaltantes == 0))
        {
            cout<<"\n Has ganado ! :-)\n";
            gameOver = true;
        }
    }

}


