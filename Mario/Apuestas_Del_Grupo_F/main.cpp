#include <iostream>
#include <cstdlib>
#include <time.h>

using namespace std;

int main()
{
    srand(time(NULL));

    //funciones
    void ResultadosEsperados(string[]);
    void RealizarApuestas(int [][3], string [][4]);
    void RealizarJornadas(int [][4], int [], int, string[][4], int [][3], string []);

    //Resultados posibles
    string terminado[] = {"Empate", "Pierde", "Gana"};

    //Variables acumuladoras
    int puntos[3][4];
    int goles[4];

    //Variables de apuesta
    int puntosGanados = 0;
    int apuesta[4][3];

    //Paises

    string paises[3][4] = {{"Alemania", "Mexico", "Suecia", "Corea del Sur"},
                          {"Corea del Sur", "Mexico", "Alemania", "Suecia"},
                          {"Mexico", "Suecia", "Corea del Sur", "Alemania"}};

    cout<<endl;

    //Menu de posibilidades
    ResultadosEsperados(terminado);
    //control de jornadas
    RealizarApuestas(apuesta, paises);
    RealizarJornadas(puntos, goles, puntosGanados, paises,apuesta, terminado);


    return 0;
}

void RealizarJornadas(int puntos[][4], int goles[], int puntosGanados, string paises[][4], int apuesta[][3], string terminado[]){
    for (int jornada=0; jornada<3; jornada++){
    for (int i=0; i<4; i++){
        goles[i] = rand()%6;
    }
    cout<<"Los Resultados de la #"<< (jornada+1) <<" Ronda son: "<<"////////-----------/////////////"<<endl;
    cout <<endl;
    for (int resultado = 0; resultado <4; resultado++){
        cout<< paises[jornada][resultado]<<" = ";
        cout<< goles[resultado];
        cout <<endl;
        if (resultado==1){
            cout <<endl;
            cout <<"-----------------------------"<<endl;
            if (goles[resultado]< goles[resultado-1]){
                cout<<"El equipo ganador es: "<<paises[jornada][resultado-1]<<endl;
                puntos[jornada][resultado-1] = 3;
                puntos[jornada][resultado] = 2;
            }
            if (goles[resultado] > goles[resultado-1]){
                cout<<"El equipo ganador es: "<<paises[jornada][resultado]<<endl;
                 puntos[jornada][resultado] = 3;
                  puntos[jornada][resultado-1] = 2;

            }
            if(goles[resultado] == goles[resultado-1]){
            cout<<"El partido termino en un empate, con: "<<goles[resultado]<< "Ambos equipos"<<endl;
             puntos[jornada][resultado-1] = 1;
             puntos[jornada][resultado] = 1;
            }
            cout <<"-----------------------------"<<endl;

            if(apuesta[jornada][resultado-1] == puntos[jornada][resultado-1]){
                puntosGanados += (3* goles[resultado-1]) + 3;
                cout <<"**********************************"<<endl;
                cout<<"Logro atinar en su apuesta. Su apuesta era \""<<terminado[resultado-1]<<"\" para el equipo "<<paises[jornada][resultado-1]<<endl;
                cout <<"**********************************"<<endl;
                cout<<endl;
            }
            if (apuesta[jornada][resultado] == puntos[jornada][resultado]){
                puntosGanados += (3* goles[resultado-1]) + 3;

                cout <<"**********************************"<<endl;
                cout<<"Logro atinar en su apuesta. Su apuesta era \""<<terminado[resultado]<<"\" para el equipo "<<paises[jornada][resultado]<<endl;
                cout <<"**********************************"<<endl;
                cout<<endl;
            }

        }
           if (resultado==3){

            cout <<"-----------------------------"<<endl;
            if (goles[resultado]< goles[resultado-1]){
                cout<<"El equipo ganador es: "<<paises[jornada][resultado-1]<<endl;
                 puntos[jornada][resultado-1] = 3;
                puntos[jornada][resultado] = 2;

            }
            if (goles[resultado] > goles[resultado-1]){
                cout<<"El equipo ganador es: "<<paises[jornada][resultado]<<endl;
                 puntos[jornada][resultado] = 3;
                  puntos[jornada][resultado-1] = 2;

            }
            if(goles[resultado] == goles[resultado-1]){
            cout<<"El partido termino en un empate, con: "<<goles[resultado]<< " Ambos equipos"<<endl;
              puntos[jornada][resultado-1] = 1;
             puntos[jornada][resultado] = 1;

            }
            cout <<"-----------------------------"<<endl;

              if(apuesta[jornada][resultado-1] == puntos[jornada][resultado-1]){
                puntosGanados += (3* goles[resultado-1]) + 3;
                cout <<"**********************************"<<endl;
                cout<<"Logro atinar en su apuesta. Su apuesta era \""<<terminado[resultado-1]<<"\" para el equipo "<<paises[jornada][resultado-1]<<endl;
                cout <<"**********************************"<<endl;
                cout<<endl;
            }

            if (apuesta[jornada][resultado] == puntos[jornada][resultado]){
                puntosGanados += (3* goles[resultado-1]) + 3;
                cout <<"**********************************"<<endl;
                cout<<"Logro atinar en su apuesta. Su apuesta era \""<<terminado[resultado]<<"\" para el equipo "<<paises[jornada][resultado]<<endl;
                cout <<"**********************************"<<endl;
                cout<<endl;
                }
            }
        }
    }
     cout<<"Sus puntos finales son = "<<puntosGanados<<"----- ;)"<<endl;
     }

void RealizarApuestas(int apuesta[][3], string paises[][4]){
    for (int jornada=0; jornada<3; jornada++){
        cout<<endl;
        cout<<"ingrese sus apuestas, de la jornada #"<<(jornada + 1)<<endl;
        cout<<endl;
        for (int i=0; i<4;i++){
        do{
            cout<<paises[jornada][i]<<"------> ";
            cin>>apuesta[jornada][i];
            cout<<"-----------------------"<<endl;
            if(apuesta[jornada][i] < 1 || apuesta[jornada][i]>3){
                cout<<"Escriba un numero entre 1 al 3"<<endl;
              }
        }while(apuesta[jornada][i] < 1 || apuesta[jornada][i]>3);
    }
     cout<<"////////--------------//////////////-----------///////////-----------/////////////"<<endl;
     cout<<"////////--------------//////////////-----------///////////-----------/////////////"<<endl;
    }
    }

void ResultadosEsperados(string terminado[]){


    cout<<"De estas formas pueden terminar los partidos, de seleccionar la opcion escribiendo el numero: "<<endl;
    cout<<endl;
    for(int terminar=0; terminar < 3; terminar++){
        cout<<(terminar+1) <<") "<<terminado[terminar]<<endl;
    }
    cout<<endl;
    }
