#include <iostream> // Ya
#include <conio.h> //  Teclado
#include <time.h>

#ifdef _WIN32
#include<windows.h>
#endif

void limpiarPantalla();
void coordenadaJuego(int coordX, int coordY);
void mostrarCuerpo();
void ingresarMovimiento();
void colocarComida();
bool verificarPosicionComida();
bool finDelJuego();
bool capturarTeclaPrecionada(int vkey);
void dibujarBordes();

int largoCuerpo = 1, anchoCuerpo = 4, direccionMovimiento = 3; // 3: Derecha, 2: Arriba, 1: Izquierda, 4: Abajo

int coordComidaX = 30, coordComidaY = 10;
int velocidadMovimiento = 100;
int puntosGenerales = 0;
int coordX = 30, coordY = 5;

int serpiente[1000][2]; // 0x0x0x0x0x0x0x -- (x,y)

using namespace std;

int main()
{

    srand(time(NULL));
    string asignarVelocidad = "n";
    cout<<"Controles: \na: Derecha \nw: Arriba \nd: Izquierda \ns: Abajo"<<endl;
    cout<<"Asignar manualemente la velocidad?\ns = si \notro = no"<<endl;
    cin>>asignarVelocidad;
    if(asignarVelocidad == "s")
    {
        cout<<"Ingrese la velocidad del juego."<<endl;
        cout<<"OBSERVACION: Mientras mas grande el numero, mas lento el juego, recomendacion: 100"<<endl;
        cin>>velocidadMovimiento;
    }
    else
    {
        velocidadMovimiento=100;
    }
    limpiarPantalla();

    CONSOLE_CURSOR_INFO codigoCurso = {100, FALSE};

    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &codigoCurso);

    dibujarBordes();
    coordComidaX = rand() % 55 + 5; //  0 - 55
    coordComidaY = rand() % 15 + 5;
    coordenadaJuego(coordComidaX, coordComidaY);
    cout<<"F";


    while( !finDelJuego())
    {

        coordenadaJuego(serpiente[largoCuerpo][0], serpiente[largoCuerpo][1]);
        cout<<" ";

        serpiente[largoCuerpo][0] = coordX;
        serpiente[largoCuerpo][1] = coordY;
        largoCuerpo++;
        if(largoCuerpo == anchoCuerpo)
        {
            largoCuerpo = 1;
        }

        mostrarCuerpo();
        colocarComida();
        ingresarMovimiento();

        switch(direccionMovimiento)
        {
        case 1:
            coordX--;
            break;
        case 2:
            coordY--;
            break;
        case 3:
            coordX++;
            break;
        case 4:
            coordY++;
            break;
        }

        Sleep(velocidadMovimiento);
        coordenadaJuego(2,25);
        cout<<"Puntos: "<<puntosGenerales;
    }
    cout<<endl;
    system("pause");
    limpiarPantalla();
    dibujarBordes();
    mostrarCuerpo();
    coordenadaJuego(2,25);
    cout<<"Puntos: "<<puntosGenerales;
    return 0;
}


void coordenadaJuego(int coordX, int coordY)
{
    COORD posicionesCursor; // (x, y)
    posicionesCursor.X = coordX;
    posicionesCursor.Y = coordY;

    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),posicionesCursor);
}

void dibujarBordes()
{

    cout<<endl;
    cout<<"  ";
    for(int i=2; i < 60; i++)
    {
        cout<<"-";
    }
    cout<<endl;
    cout<<"  ";
    for(int i=0; i<22; i++)
    {
        for(int v=2; v <= 60; v++)
        {
            if(v==2 || v==60) // or = o
            {
                cout<<"|";

            }
            else
            {
                if(v < 60 && i == 21 && v >0 )// & (et)
                {
                    cout<<"-";
                }
                else
                {
                    cout<<" ";

                }
            }
        }
        cout<<endl;
        cout<<"  ";

    }
    coordenadaJuego (2,1);
    cout<<"*";
    coordenadaJuego (2,23);
    cout<<"*";
    coordenadaJuego (60,1);
    cout<<"*";
    coordenadaJuego(60,23);
    cout<<"*";
}

void mostrarCuerpo()
{

    for(int i = 1; i < anchoCuerpo; i++)
    {
        if(i%2==0)
        {
            coordenadaJuego(serpiente[i][0], serpiente[i][1]);
            cout<<"x";
        }
        else
        {
            coordenadaJuego(serpiente[i][0], serpiente[i][1]);
            cout<<"o";
        }

    }
}

void ingresarMovimiento()
{
    if(kbhit()) // Keyboard hit
    {
// Bufert input // 23 77 79
        if(capturarTeclaPrecionada(0x41)) //A - Izquierda
        {
            if(direccionMovimiento != 3) // Derecha  -> Izquierda
            {
                direccionMovimiento = 1;
            }
        }
        else if(capturarTeclaPrecionada(0x44)) //D - Derecha
        {
            if(direccionMovimiento != 1)
            {
                direccionMovimiento = 3;
            }
        }
        else if(capturarTeclaPrecionada(0x57)) //W - Arriba
        {
            if(direccionMovimiento != 4)
            {
                direccionMovimiento = 2;
            }
        }
        else if(capturarTeclaPrecionada(0x53)) //S - Abajo
        {
            if(direccionMovimiento != 2)
            {
                direccionMovimiento = 4;
            }
        }

    }
}
void colocarComida()
{
    if(verificarPosicionComida())
    {

        coordComidaX = rand() % 55 + 5;
        coordComidaY = rand() % 15 + 5;

        puntosGenerales += 4;
        anchoCuerpo++;
        coordenadaJuego(coordComidaX, coordComidaY);
        cout<<"F";
    }
}
bool verificarPosicionComida()
{
    if(coordX == coordComidaX && coordY == coordComidaY)
    {
        return true;
    }
    else
    {
        return false;
    }

}

bool capturarTeclaPrecionada(int vkey)
{
    // Preciona la tecla == -1.
    // Se libera la tecla ==  1
    // Mantener la tecla == 0

    return GetKeyState(vkey) < 0;
}

bool finDelJuego()
{
    if(coordY == 0 || coordY == 23 || coordX == 2 || coordX == 60)
        return true;
    for(int j = anchoCuerpo - 1; j > 0; j--)
    {
        if(serpiente[j][0] == coordX && serpiente[j][1] == coordY)
            return true;
    }
    return false;
}

void limpiarPantalla()
{
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

