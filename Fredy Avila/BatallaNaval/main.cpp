#include <iostream>
#include <iomanip>
#include <Windows.h>
using namespace std;
#define ORDENMATRIZ 9
#define ESPACIODEDIVISION 5
/*
ANOTACIONES
Codigo de numeros:
0 = Casilla libre de barcos
1 = Parte de banco colocado
2 = Parte de barco dañado

Codigo para la orientacion de los barcos
1 = vertical
2 = horizontal
*/

HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
//Matrices para la cuadricula de los mapas

int tableroPrincipalJugadorUNO[ORDENMATRIZ][ORDENMATRIZ];
int tableroBarcosJugadorUNO[ORDENMATRIZ][ORDENMATRIZ];

int tableroPrincipalJugadorDOS[ORDENMATRIZ][ORDENMATRIZ];
int tableroBarcosJugadorDOS[ORDENMATRIZ][ORDENMATRIZ];

// Variables importantes
int columnaSeleccionada = 0, filaSeleccionada = 0;
int cantidadEspaciosBarcosJugadorUNO = 9;
int cantidadEspaciosBarcosJugadorDOS = 9;

int turnoActual = 1;
bool finJuego = false;
bool disparoPermitido = true;
bool coordenadaPermitida = true;
int cantidadDeEspaciosRecorrer = 3;

// ************************************************************************
// Clase de Jugador para crear el objeto
class Jugador
{
    int var1;
    string nombre;
    int punto = 0;

public:
    void setNombre(string nombre);
    string getNombre();

    void setPuntos(int puntosIngresado);
    int getPuntos();
};

void Jugador::setNombre(string nombreIngresado)
{
    nombre = nombreIngresado;
}

string Jugador::getNombre()
{
    return nombre;
}

void Jugador::setPuntos(int puntosIngresado)
{
    punto += puntosIngresado;
}

int Jugador::getPuntos()
{
    return punto;
}
// ************************************************************************

// Funciones a utilizar
void incializarMatrices();
void colocarBarcos(int indiceJugador);
void mostrarMatrizBarcos(int indiceJugador);
void mostrarMatrizPrincipal(int indiceJugador);

bool finalizarJuego(); // No existe

void limpiaraPantalla();
void mostrarDivision();
void turnoJugador(int indiceJugador);
void seleccionarCoordenadas();
void realizarDisparo(int indiceJugador);
bool verificarCoordenadas();

bool ubicacionValidaParaColocarBarco(int fila, int columna, int orientacion, int cantidadBarcos, int indiceJugador);

void cambiarColorTexto(char inicialColor);

Jugador jugadorUNO;
Jugador jugadorDOS;

int main()
{

    incializarMatrices();
    string nombreIngresado;
    SetConsoleTextAttribute(hConsole, 15);
    cout << "Ingrese el nombre del jugador #1" << endl;
    cin >> nombreIngresado;

    // nombreIngresado = "Edwin";
    jugadorUNO.setNombre(nombreIngresado);
    jugadorUNO.setPuntos(0);

    cout << "Ingrese el nombre del jugador #2" << endl;
    cin >> nombreIngresado;
    // nombreIngresado = "Mario";
    jugadorDOS.setNombre(nombreIngresado);
    jugadorDOS.setPuntos(0);

    mostrarDivision();
    cout <<"Jugador #1: "<< jugadorUNO.getNombre() << endl;
    cout <<"Jugador #2: "<< jugadorDOS.getNombre() << endl;
    mostrarDivision();
    colocarBarcos(1);
    system("pause");
    limpiaraPantalla();

    colocarBarcos(2);
    system("pause");
    limpiaraPantalla();
    // cout << "Barcos colocados exitosamente. Matrices resultantes: " << endl;
    // mostrarMatrizBarcos(1);
    // mostrarMatrizBarcos(2);
    do
    {
        if (!finJuego)
            turnoJugador(1);
        if (!finJuego)
            turnoJugador(2);

    } while (!finJuego);

    if (cantidadEspaciosBarcosJugadorUNO == 0)
    {
        limpiaraPantalla();
        mostrarDivision();
        mostrarMatrizPrincipal(1);
        cout << "El jugador ganador es: " << jugadorDOS.getNombre() << endl;
        mostrarDivision();
    }
    else if (cantidadEspaciosBarcosJugadorDOS == 0)
    {
        limpiaraPantalla();
        mostrarDivision();
        mostrarMatrizPrincipal(2);
        cout << "El jugador ganador es: " << jugadorUNO.getNombre() << endl;
        mostrarDivision();
    }
    cout << "Fin del Juego!" << endl;
    return 0;
}

void incializarMatrices()
{

    // Establecemos todas las matrices con sus casillas sin barcos
    for (int i = 0; i < ORDENMATRIZ; i++)
    {
        for (int j = 0; j < ORDENMATRIZ; j++)
        {
            tableroBarcosJugadorUNO[i][j] = 0;
            tableroPrincipalJugadorUNO[i][j] = 0;
            tableroBarcosJugadorDOS[i][j] = 0;
            tableroPrincipalJugadorDOS[i][j] = 0;
        }
    }
}

void colocarBarcos(int indiceJugador)
{
    int fila = 0, columna = 0;
    int cantidadBarcos = 3;
    int orientacion = 1;
    if (indiceJugador == 1)
    {
        cout << "El jugador 1 colocara sus barcos en la tablero" << endl;
        mostrarMatrizBarcos(indiceJugador);
        do
        {
            cout << "EL BARCO A COLOCAR EN EL TABLERO ES: " << endl;
            //Mensajes ilustrativos para los tipos de barcos disponibles
            if (cantidadBarcos == 3)
            {

                cout << "Tipo de barco: Grande" << endl;
                cout << "Espacios: ****" << endl;
                cout << "Cantidad de casillas: 4" << endl;
            }
            else if (cantidadBarcos == 2)
            {
                cout << "Tipo de barco: Mediano" << endl;
                cout << "Espacios: ***" << endl;
                cout << "Cantidad de casillas: 3" << endl;
            }
            else if (cantidadBarcos == 1)
            {
                cout << "Tipo de barco: Pequegno" << endl;
                cout << "Espacios: **" << endl;
                cout << "Cantidad de casillas: 2" << endl;
            }

            cout << "Ingrese la Columna a colocar el barco: " << endl;
            cin >> columna;
            cout << "Ingrese la Fila a colocar el barco: " << endl;
            cin >> fila;

            cout << "Ingrese la orientacion en la que colocara al barco: " << endl;
            cout << "1 = Vertical " << endl;
            cout << "2 = Horizontal " << endl;
            do
            {
                cin >> orientacion;
                if (orientacion < 1 || orientacion > 2)
                {
                    cambiarColorTexto('r');
                    cout << "Ha ingreado una opcion no valida" << endl;
                    cambiarColorTexto('b');
                }
            } while (orientacion < 1 || orientacion > 2);

            if (columna > 0)
                columna--;
            if (fila > 0)
                fila--;
            if (ubicacionValidaParaColocarBarco(fila, columna, orientacion, cantidadBarcos, indiceJugador))
            {
                cantidadDeEspaciosRecorrer = cantidadBarcos;
                if (orientacion == 1)
                {
                    do
                    {
                        tableroBarcosJugadorUNO[fila + cantidadDeEspaciosRecorrer][columna] = 1;

                        cantidadDeEspaciosRecorrer--;
                    } while (cantidadDeEspaciosRecorrer >= 0);
                }
                else
                {
                    do
                    {
                        tableroBarcosJugadorUNO[fila][columna + cantidadDeEspaciosRecorrer] = 1;

                        cantidadDeEspaciosRecorrer--;
                    } while (cantidadDeEspaciosRecorrer >= 0);
                }
                cantidadBarcos--;
                cambiarColorTexto('v');
                cout << "Se ha colocado el barco correctamente" << endl;
                cambiarColorTexto('b');
                mostrarDivision();
            }
            else
            {
                cambiarColorTexto('r');
                cout << "Ubicacion no valida. Intenta con otra" << endl;
                cambiarColorTexto('b');
            }
        } while (cantidadBarcos >= 1);
    }
    else
    {
        cout << "El jugador 2 colocara sus barcos en la tablero" << endl;
        mostrarMatrizBarcos(indiceJugador);
        do
        {
            cout << "EL BARCO A COLOCAR EN EL TABLERO ES: " << endl;
            //Mensajes ilustrativos para los tipos de barcos disponibles
            if (cantidadBarcos == 3)
            {
                cout << "Tipo de barco: Grande" << endl;
                cout << "Espacios: ****" << endl;
                cout << "Cantidad de casillas: 4" << endl;
            }
            else if (cantidadBarcos == 2)
            {
                cout << "Tipo de barco: Mediano" << endl;
                cout << "Espacios: ***" << endl;
                cout << "Cantidad de casillas: 3" << endl;
            }
            else if (cantidadBarcos == 1)
            {
                cout << "Tipo de barco: Pequegno" << endl;
                cout << "Espacios: **" << endl;
                cout << "Cantidad de casillas: 2" << endl;
            }

            cout << "Ingrese la Columna a colocar el barco: " << endl;
            cin >> columna;
            cout << "Ingrese la Fila a colocar el barco: " << endl;
            cin >> fila;

            cout << "Ingrese la orientacion en la que colocara al barco: " << endl;
            cout << "1 = Vertical " << endl;
            cout << "2 = Horizontal " << endl;
            do
            {
                cin >> orientacion;
                if (orientacion < 1 || orientacion > 2)
                {
                    cambiarColorTexto('r');
                    cout << "Ha ingreado una opcion no valida" << endl;
                    cambiarColorTexto('b');
                }
            } while (orientacion < 1 || orientacion > 2);

            if (columna > 0)
                columna--;
            if (fila > 0)
                fila--;
            if (ubicacionValidaParaColocarBarco(fila, columna, orientacion, cantidadBarcos, indiceJugador))
            {

                cantidadDeEspaciosRecorrer = cantidadBarcos;
                if (orientacion == 1)
                {
                    do
                    {
                        tableroBarcosJugadorDOS[fila + cantidadDeEspaciosRecorrer][columna] = 1;
                        // tableroPrincipalJugadorDOS[fila + cantidadDeEspaciosRecorrer][columna] = 1;
                        cantidadDeEspaciosRecorrer--;
                    } while (cantidadDeEspaciosRecorrer >= 0);
                }
                else
                {
                    do
                    {
                        tableroBarcosJugadorDOS[fila][columna + cantidadDeEspaciosRecorrer] = 1;
                        // tableroPrincipalJugadorDOS[fila][columna + cantidadDeEspaciosRecorrer] = 1;
                        cantidadDeEspaciosRecorrer--;
                    } while (cantidadDeEspaciosRecorrer >= 0);
                }
                cantidadBarcos--;
                cambiarColorTexto('v');
                cout << "Se ha colocado el barco correctamente" << endl;
                cambiarColorTexto('b');
                mostrarDivision();
            }
            else
            {
                cambiarColorTexto('r');
                cout << "Ubicacion no valida. Intenta con otra" << endl;
                cambiarColorTexto('b');
            }
        } while (cantidadBarcos >= 1);
    }
}

void mostrarMatrizBarcos(int indiceJugador)
{

    if (indiceJugador == 1)
    {
        mostrarDivision();
        cout << "Matriz de los barcos de " << jugadorUNO.getNombre() << endl;
        for (int i = 0; i < ORDENMATRIZ + 1; i++)
        {

            if (i > 0)
            {
                cout << setw(ESPACIODEDIVISION) << i;
            }
            else
            {

                cout << setw(ESPACIODEDIVISION) << " ";
            }
        }
        cout << endl;
        for (int i = 0; i < ORDENMATRIZ; i++)
        {
            for (int j = 0; j < ORDENMATRIZ; j++)
            {
                if (j == 0)
                {
                    cout << setw(ESPACIODEDIVISION) << i + 1 << " ";
                }
                if (tableroBarcosJugadorUNO[i][j] == 0)
                {
                    cambiarColorTexto('a');
                    cout << setw(ESPACIODEDIVISION) << "[ ]";
                    cambiarColorTexto('b');
                }
                else if (tableroBarcosJugadorUNO[i][j] == 2)
                {
                    cambiarColorTexto('v');

                    cout << setw(ESPACIODEDIVISION) << "[1]";
                    cambiarColorTexto('b');
                }
            }
            cout << endl;
        }
    }
    else
    {
        mostrarDivision();
        cout << "Matriz de los barcos de " << jugadorDOS.getNombre() << endl;
        for (int i = 0; i < ORDENMATRIZ + 1; i++)
        {

            if (i > 0)
            {
                cout << setw(ESPACIODEDIVISION) << i;
            }
            else
            {

                cout << setw(ESPACIODEDIVISION) << " ";
            }
        }
        cout << endl;
        for (int i = 0; i < ORDENMATRIZ; i++)
        {
            for (int j = 0; j < ORDENMATRIZ; j++)
            {
                if (j == 0)
                {
                    cout << setw(ESPACIODEDIVISION) << i + 1 << " ";
                }
                if (tableroBarcosJugadorDOS[i][j] == 0)
                {
                    cambiarColorTexto('a');

                    cout << setw(ESPACIODEDIVISION) << "[ ]";
                    cambiarColorTexto('b');
                }
                else if (tableroBarcosJugadorDOS[i][j] == 1)
                {
                    cambiarColorTexto('v');

                    cout << setw(ESPACIODEDIVISION) << "[1]";
                    cambiarColorTexto('b');
                }
            }
            cout << endl;
        }
    }
}

void mostrarMatrizPrincipal(int indiceJugador)
{

    if (indiceJugador == 1)
    {
        mostrarDivision();
        cout << "Matriz de " << jugadorUNO.getNombre() << endl;
        for (int i = 0; i < ORDENMATRIZ + 1; i++)
        {

            if (i > 0)
            {
                cout << setw(ESPACIODEDIVISION) << i;
            }
            else
            {

                cout << setw(ESPACIODEDIVISION) << " ";
            }
        }
        cout << endl;
        for (int i = 0; i < ORDENMATRIZ; i++)
        {
            for (int j = 0; j < ORDENMATRIZ; j++)
            {
                if (j == 0)
                {
                    cout << setw(ESPACIODEDIVISION) << i + 1 << " ";
                }
                if (tableroPrincipalJugadorUNO[i][j] == 0)
                {
                    cambiarColorTexto('a');

                    cout << setw(ESPACIODEDIVISION) << "[ ]";
                    cambiarColorTexto('b');
                }
                else if (tableroPrincipalJugadorUNO[i][j] == 2)
                {
                    cambiarColorTexto('r');
                    cout << setw(ESPACIODEDIVISION) << "[*]";
                    cambiarColorTexto('b');
                }
                else if (tableroBarcosJugadorUNO[i][j] == 3)
                {
                    cambiarColorTexto('m');
                    cout << setw(ESPACIODEDIVISION) << "[/]";
                    cambiarColorTexto('b');
                }
            }
            cout << endl;
        }
    }
    else
    {
        mostrarDivision();
        cout << "Matriz de " << jugadorDOS.getNombre() << endl;
        for (int i = 0; i < ORDENMATRIZ + 1; i++)
        {

            if (i > 0)
            {
                cout << setw(ESPACIODEDIVISION) << i;
            }
            else
            {

                cout << setw(ESPACIODEDIVISION) << " ";
            }
        }
        cout << endl;
        for (int i = 0; i < ORDENMATRIZ; i++)
        {
            for (int j = 0; j < ORDENMATRIZ; j++)
            {
                if (j == 0)
                {
                    cout << setw(ESPACIODEDIVISION) << i + 1 << " ";
                }
                if (tableroPrincipalJugadorDOS[i][j] == 0)
                {
                    cambiarColorTexto('a');

                    cout << setw(ESPACIODEDIVISION) << "[ ]";
                    cambiarColorTexto('b');
                }
                else if (tableroPrincipalJugadorDOS[i][j] == 2)
                {
                    cambiarColorTexto('r');
                    cout << setw(ESPACIODEDIVISION) << "[*]";
                    cambiarColorTexto('b');
                }
                else if (tableroPrincipalJugadorDOS[i][j] == 3)
                {
                    cambiarColorTexto('m');
                    cout << setw(ESPACIODEDIVISION) << "[/]";
                    cambiarColorTexto('b');
                }
            }
            cout << endl;
        }
    }
}

void limpiaraPantalla()
{
    system("cls");
}

void mostrarDivision()
{
    cout << "\n------------------------------\n"
         << endl;
}

void turnoJugador(int indiceJugador)
{
    limpiaraPantalla();
    if (indiceJugador == 1)
    {
        cout << "Turno de: " << jugadorUNO.getNombre() << endl;
        mostrarMatrizPrincipal(2);
        seleccionarCoordenadas();
        realizarDisparo(indiceJugador);
        mostrarMatrizPrincipal(2);
    }
    else
    {
        cout << "Turno de: " << jugadorDOS.getNombre() << endl;
        mostrarMatrizPrincipal(1);
        seleccionarCoordenadas();
        realizarDisparo(indiceJugador);
        mostrarMatrizPrincipal(1);
    }
    system("pause");
}

void seleccionarCoordenadas()
{

    do
    {
        cout << "Seleccione la Columna donde quiere disparar: ";
        cin >> columnaSeleccionada;
        cout << "Seleccione la Fila donde quiere disparar: ";
        cin >> filaSeleccionada;

        if (columnaSeleccionada > 0)
            columnaSeleccionada--;
        if (filaSeleccionada > 0)
            filaSeleccionada--;

        if (!verificarCoordenadas())
        {
            cambiarColorTexto('r');
            cout << "La coordenada ingresada no es valida. No se realizara el disparo. " << endl;
            cout << "Ingresa otra coordenada" << endl;
            cambiarColorTexto('b');
        }
    } while (!verificarCoordenadas());
}

void realizarDisparo(int indiceJugador)
{
    if (indiceJugador == 1)
    {
        if (tableroBarcosJugadorDOS[filaSeleccionada][columnaSeleccionada] == 1)
        {
            cout << "Disparo acerto a un barco." << endl;
            cantidadEspaciosBarcosJugadorDOS--;
            jugadorUNO.setPuntos(3);

            tableroPrincipalJugadorDOS[filaSeleccionada][columnaSeleccionada] = 2;
        }
        else
        {
            cambiarColorTexto('m');

            cout << "El disparo no acerto a ningun barco" << endl;
            tableroPrincipalJugadorDOS[filaSeleccionada][columnaSeleccionada] = 3;
            cambiarColorTexto('b');
        }
    }
    else
    {
        if (tableroBarcosJugadorUNO[filaSeleccionada][columnaSeleccionada] == 1)
        {
            cout << "Disparo acerto a un barco." << endl;
            cantidadEspaciosBarcosJugadorUNO--;
            jugadorDOS.setPuntos(3);
            tableroPrincipalJugadorUNO[filaSeleccionada][columnaSeleccionada] = 2;
        }
        else
        {
            cambiarColorTexto('m');
            cout << "El disparo no acerto a ningun barco" << endl;
            tableroPrincipalJugadorUNO[filaSeleccionada][columnaSeleccionada] = 3;
            cambiarColorTexto('b');
        }
    }
    if (cantidadEspaciosBarcosJugadorUNO == 0 || cantidadEspaciosBarcosJugadorDOS == 0)
    {
        finJuego = true;
    }
}

bool verificarCoordenadas()
{
    coordenadaPermitida = true;
    if (columnaSeleccionada < 0 || columnaSeleccionada > ORDENMATRIZ || filaSeleccionada < 0 || filaSeleccionada > ORDENMATRIZ)
        coordenadaPermitida = false;
    return coordenadaPermitida;
}

bool ubicacionValidaParaColocarBarco(int fila, int columna, int orientacion, int cantidadBarcos, int indiceJugador)
{

    if ((fila < 0 || columna < 0) || (fila > ORDENMATRIZ || columna > ORDENMATRIZ))
        return false;

    if (orientacion == 1)
    {
        //Vertical
        if (fila <= ORDENMATRIZ - cantidadBarcos)
            disparoPermitido = true;
        else
            disparoPermitido = false;
    }
    else
    {

        //Horizontal
        if (columna <= ORDENMATRIZ - cantidadBarcos)
            disparoPermitido = true;
        else
            disparoPermitido = false;
    }

    cantidadDeEspaciosRecorrer = cantidadBarcos;
    if (indiceJugador == 1)
    {
        if (orientacion == 1)
        {
            do
            {
                if (tableroBarcosJugadorUNO[fila + cantidadDeEspaciosRecorrer][columna] == 1)
                {

                    disparoPermitido = false;
                }

                cantidadDeEspaciosRecorrer--;
            } while (cantidadDeEspaciosRecorrer >= 0);
        }
        else
        {
            do
            {
                if (tableroBarcosJugadorUNO[fila][columna + cantidadDeEspaciosRecorrer] == 1)
                {

                    disparoPermitido = false;
                }

                cantidadDeEspaciosRecorrer--;
            } while (cantidadDeEspaciosRecorrer >= 0);
        }
    }
    else
    {

        if (orientacion == 1)
        {
            do
            {
                if (tableroBarcosJugadorDOS[fila + cantidadDeEspaciosRecorrer][columna] == 1)
                {

                    disparoPermitido = false;
                }

                cantidadDeEspaciosRecorrer--;
            } while (cantidadDeEspaciosRecorrer >= 0);
        }
        else
        {
            do
            {
                if (tableroBarcosJugadorDOS[fila][columna + cantidadDeEspaciosRecorrer] == 1)
                {
                    disparoPermitido = false;
                }

                cantidadDeEspaciosRecorrer--;
            } while (cantidadDeEspaciosRecorrer >= 0);
        }
    }

    return disparoPermitido;
}

void cambiarColorTexto(char inicialColor)

    switch (inicialColor)
    {
    case 'a':
        SetConsoleTextAttribute(hConsole, 9);

        break;
    case 'r':
        SetConsoleTextAttribute(hConsole, 12);

        break;
    case 'v':
        SetConsoleTextAttribute(hConsole, 10);

        break;
    case 'm':
        SetConsoleTextAttribute(hConsole, 14);

        break;

    default:
        SetConsoleTextAttribute(hConsole, 15);
        break;
    }
}
