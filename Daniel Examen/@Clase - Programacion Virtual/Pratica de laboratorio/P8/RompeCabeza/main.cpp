#include <iostream>
#include <math.h>
#include <stdlib.h>
using namespace std;
void Juego(int T[][4],char *Mov);
int main()
{
    int T[4][4];
    int nume = 1;
    char Mov[1000];

    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            T[i][j]= nume;
            nume++;
        }
    }
    T[3][3]=-1;

    cin.getline(Mov,99,'\n');
    Juego(T,Mov);

    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            if(T[i][j]!=-1)
                cout<<T[i][j];
        }
    }

    return 0;
}
void Juego(int T[][4],char *Mov)
{
    int paso = 0, turno = 0, tmpNum=0, fila = 3, columna= 3;
    string tmpString = "";
    int fEspac = 3,cEspac=3;

    while(Mov[turno]!='\0')
    {
        tmpString = Mov[turno];
        paso = atoi(tmpString.c_str());
        switch(paso)
        {
        case 0:
            if(columna >0)
            {

                if(turno==0)
                {

                    columna--;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }
                else
                {

                    columna--;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }
            }

            break;
        case 1:
            if(fila <3)
            {
                if(turno!=0)
                {
                    fila++;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }

            }
            break;
        case 2:
            if(columna <3)
            {

                if(turno!=0)
                {
                    columna++;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }
            }
            break;
        case 3:
            if(fila >0)
            {

                if(turno==0)
                {
                    fila--;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }
                else
                {
                    fila--;
                    tmpNum  = T[fila][columna];
                    T[fila][columna] = T[fEspac][cEspac];
                    T[fEspac][cEspac] = tmpNum;
                }
            }
            break;
        }
        fEspac = fila;
        cEspac = columna;
        turno++;

    }
}
