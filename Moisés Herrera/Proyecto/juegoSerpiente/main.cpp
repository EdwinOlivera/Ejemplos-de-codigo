#include <iostream>
#include <conio.h>
#include <ctime>
#include <windows.h>
#include <cstdio>
#include <vector>

#define anchoMapa 60
#define altoMapa 23

using namespace std;
class Snake
{
private:
    COORD pos;
    int velocidadGeneral;
    char direccionActual;
    int largoCuerpo;
    vector<COORD> cuerpoSerpiente;

public:
    Snake(COORD pos, int velocidadGeneral);

    void grow();
    int conseguirLargo();
    void moverSerpiente();
    void direccion(char direccionActual);
    char conseguirDireccion();

    vector<COORD> conseguirCuerpo();

    bool comprobarColision();
    bool comer(COORD objComida);

    COORD conseguirPosicion();
};
Snake::conseguirLargo()
{
    return largoCuerpo;
}
class Food
{
private:
    COORD pos;

public:
    void conseguirComida();
    COORD conseguirPosicion();
};




void Food::conseguirComida()
{

    pos.X = (rand() % 53  )+5 ;
    pos.Y = (rand() % 15  ) + 2 ;

}

COORD Food::conseguirPosicion()
{
    return pos;
}

Snake snake({anchoMapa/2, altoMapa/2}, 1);
Food objComida;

int puntos;

void mapa()
{
    COORD snake_pos = snake.conseguirPosicion();
    COORD posicionComida = objComida.conseguirPosicion();

    vector<COORD> serpiente = snake.conseguirCuerpo();

    cout << "PUNTOS : " << puntos << "\n\n";

    for(int i = 0; i < altoMapa; i++)
    {
        cout << "\t\t#";
        for(int j = 0; j < anchoMapa - 2; j++)
        {
            if(i == 0 || i == altoMapa-1)
                cout << '#';

            else if(i == snake_pos.Y && j+1 == snake_pos.X)
                cout << 'x';
            else if(i == posicionComida.Y && j+1 == posicionComida.X)
                cout << 'F';

            else
            {
                bool isBodyPart = false;
                for(int k = 0; k < serpiente.size()-1; k++)
                {
                    if(i == serpiente[k].Y && j+1 == serpiente[k].X)
                    {
                        cout << 'o';
                        isBodyPart = true;
                        break;
                    }
                }

                if(!isBodyPart)
                    cout << ' ';
            }
        }
        cout << "#\n";
    }
}

Snake::Snake(COORD pos, int velocidadGeneral)
{

    this->pos = pos;
    this->velocidadGeneral = velocidadGeneral;

    direccionActual = 'r';
    largoCuerpo = 1;
    cuerpoSerpiente.push_back(pos);
}

void Snake::direccion(char direccionActual)
{
    this->direccionActual = direccionActual;
}

char Snake::conseguirDireccion()
{
    return direccionActual;
}
void Snake::grow()
{
    largoCuerpo++;
}
COORD Snake::conseguirPosicion()
{
    return pos;
}

vector<COORD> Snake::conseguirCuerpo()
{
    return cuerpoSerpiente;
}

void Snake::moverSerpiente()
{
    switch(direccionActual)
    {
    case 'u':
        pos.Y -= velocidadGeneral;
        break;
    case 'd':
        pos.Y += velocidadGeneral;
        break;
    case 'l':
        pos.X -= velocidadGeneral;
        break;
    case 'r':
        pos.X += velocidadGeneral;
        break;
    }

    cuerpoSerpiente.push_back(pos);
    if(cuerpoSerpiente.size() > largoCuerpo)
        cuerpoSerpiente.erase(cuerpoSerpiente.begin());
}

bool Snake::comprobarColision()
{
    if(pos.X < 1 || pos.X > anchoMapa-2 || pos.Y < 1 || pos.Y > altoMapa-2)
        return true;

    if(largoCuerpo >3)
    {

        for(int i = 0; i < largoCuerpo-1; i++)
        {
            if(pos.X == cuerpoSerpiente[i].X && pos.Y == cuerpoSerpiente[i].Y)
                return true;
        }
    }
    return false;
}

bool Snake::comer(COORD objComida)
{
    if(pos.X == objComida.X && pos.Y == objComida.Y)
        return true;
    return false;
}
int main()
{
    CONSOLE_CURSOR_INFO codigoCurso = {100, FALSE};
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &codigoCurso);

    puntos = 0;
    srand(time(NULL));

    objComida.conseguirComida();

    bool game_over = false;

    while(!game_over)
    {
        mapa();

        if(kbhit())
        {

            switch(getch())
            {
            case 'w':
                if(snake.conseguirDireccion() != 'd')
                    snake.direccion('u');
                break;
            case 'a':
                if(snake.conseguirDireccion() != 'r')
                    snake.direccion('l');
                break;
            case 's':
                if(snake.conseguirDireccion() != 'u')
                    snake.direccion('d');
                break;
            case 'd':
                if(snake.conseguirDireccion() != 'l')
                    snake.direccion('r');
                break;

            case 'W':
                if(snake.conseguirDireccion() != 'd')
                    snake.direccion('u');
                break;
            case 'A':
                if(snake.conseguirDireccion() != 'r')
                    snake.direccion('l');
                break;
            case 'S':
                if(snake.conseguirDireccion() != 'u')
                    snake.direccion('d');
                break;
            case 'D':
                if(snake.conseguirDireccion() != 'l')
                    snake.direccion('r');
                break;
            }
        }

        if(snake.comprobarColision() )
            game_over = true;

        if(snake.comer(objComida.conseguirPosicion()))
        {
            objComida.conseguirComida();
            snake.grow();
            puntos = puntos + 10;
        }

        snake.moverSerpiente();
        if(snake.conseguirLargo() < 3)
        {
            snake.grow();
        }
        SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), {0, 0});
    }

}
