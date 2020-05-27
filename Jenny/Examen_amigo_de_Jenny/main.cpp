/*#include <iostream>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX 1000


void substring(char *Texto, char *subTexto, int inicio, int longitud);
void centrar_linea(char *linea, int ancho);
void derecha_linea(char *linea, int ancho);
void Centrar_oracion(char *Texto, int ancho);
void Texto_Derecha(char *Texto, int ancho);
void Justificar_Texto(char *Texto, int ancho);


using namespace std;
int main()
{
    char Texto[MAX];
    int Opcion =-1;
    cout<<"Ingrese un Texto: "<<endl;
    cin>>(Texto);

    do
    {
        cout<<"\nEscoga una opcion para alinear el texto:"<<endl;
        cout<<" 0 - Justificar Texto"<<endl;
        cout<<" 1 - Alinear Texto al Centro"<<endl;
        cout<<" 2 - Alinear Texto a la Derecha"<<endl;
        cout<<" 3 - Todas las alineaciones"<<endl;
        cin>>Opcion;

        if(Opcion<0 || Opcion>3)
        {
            cout<<"\nLa opcion ingresada no existe"<<endl;
            cout<<"Ingrese una opcion valida"<<endl;
        }
        else
        {
            switch(Opcion)
            {
            case 0:
                cout<<"\nTexto alineada a la Justificado:"<<endl;

                Justificar_Texto(Texto, 80);
                break;
            case 1:
                cout<<"\nTexto centrada:"<<endl;
                Centrar_oracion(Texto, 80);
                break;
            case 2:
                cout<<"\nTexto alineada a la derecha:"<<endl;
                Texto_Derecha(Texto, 80);
                break;
            case 3:
                cout<<"\nTexto alineada a la Justificado:"<<endl;
                cout<<"   "<<Texto<<endl;
                cout<<"\nTexto centrada:"<<endl;
                Centrar_oracion(Texto, 80);
                cout<<"\nTexto alineada a la derecha:"<<endl;
                Texto_Derecha(Texto, 80);
                break;
            }
        }
    }
    while(Opcion<0 || Opcion>3);



    cout<<"\n"<<endl;
    cout<<"Fin del programa"<<endl;

    return 0;
}

void Justificar_Texto(char *Texto, int ancho)
{
    int espacios, letraActual;
    espacios = ancho - strlen(Texto);
    int LimiteDeCadena = strlen(Texto);
    do
    {

        for(int i=0; i<strlen(Texto)+5; i++)
        {
            letraActual++;
            cout<<*Texto++;
            if(i == espacios-1)
            {
                cout<<endl;
            }
        }
    }
    while(letraActual == strlen(Texto));
}
void substring(char *Texto, char *subTexto, int inicio, int longitud)
{
    int i;

    for(i=0; i < longitud && inicio+i < strlen(Texto); i++)
        subTexto[ i ] = Texto[ inicio+i ];

    subTexto[ i ] = '\0';
}

void centrar_linea(char *linea, int ancho)
{
    int i, espacios;
    espacios = (ancho - strlen(linea)) / 2;

    for(i=0; i < espacios; i++)
        cout<<" ";

    cout<<linea<<endl;
}

void derecha_linea(char *linea, int ancho)
{
    int i, espacios;
    espacios = ancho - strlen(linea);

    for(i=0; i < espacios; i++)
        cout<<" ";

    cout<<linea<<endl;
}

void Centrar_oracion(char *Texto, int ancho)
{
    char subTexto[MAX];
    int i, total;

    total = (int)ceil((float)strlen(Texto) / ancho);

    for(i=0; i < total; i++)
    {
        substring(Texto, subTexto, i*ancho, ancho);
        centrar_linea(subTexto, ancho);
    }
}

void Texto_Derecha(char *Texto, int ancho)
{
    char subTexto[MAX];
    int i, total;

    total = (int)ceil((float)strlen(Texto) / ancho);

    for(i=0; i < total; i++)
    {
        substring(Texto, subTexto, i*ancho, ancho);
        derecha_linea(subTexto, ancho);
    }
}
*/

#include <iostream>
using namespace std;

void BuscarNombreApellido(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, string TipoDeBusqueda);
void Order_Nombre_Letra(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, char Letra);
void Order_Apellid_Letra(char *texto, string Participantes[][MAXPARTICIPANTES]);
void Mostrar_Nombre_Apellido(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, char Letra);
int main()
{
#define MAXPARTICIPANTES 100
#define MAXCARACTERES 100
    string Participantes[MAXPARTICIPANTES][MAXPARTICIPANTES];
    int Opcion =-1;
    char ParticipanteBuscar[MAXCARACTERES];
    do
    {

        cout<<"Escoja una opcion: "<<endl;
        cout<<"1 - Buscar por Apellido"<<endl;
        cout<<"2 - Buscar por Nombre"<<endl;
        cout<<"3 - Order Alfabeticamente"<<endl;
        cin>>Opcion;
        switch(Opcion)
        {
        case 1:
            cout<<"Escriba apellido de la persona a buscar"<<endl;
            cin>>ParticipanteBuscar;
            string TipoBuqueda= "Apelleido";
            BuscarNombreApellido(ParticipanteBuscar, Participantes, MAXPARTICIPANTES, TipoBuqueda);
            break;
        case 2:
            cout<<"Escriba el nombre de la persona a buscar"<<endl;
            cin>>ParticipanteBuscar
            string TipoBuqueda= "Nombre";
            BuscarNombreApellido(ParticipanteBuscar,Participantes, MAXPARTICIPANTES, TipoBuqueda);
            break;
        case 3:
            cout<<"Ordenando alfabeticamente"<<endl;

            cin>>ParticipanteBuscar;
            char LETRAINCIAL='A';
            Mostrar_Nombre_Apellido(ParticipanteBuscar, Participantes, MAXPARTICIPANTES, LETRAINCIAL);
            break;

        }
        cout<<endl;
    }
    while(Opcion<0 ||Opcion>=4);

    return 0;
}

void BuscarNombreApellido(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, string TipoDeBusqueda)
{
    if(TipoDeBusqueda=="Apellido")
    {
        for(int i=0; i<  LargoDeArreglo,i++  )
        {
            if(texto==Participantes[i][1])
            {
                cout<<"Se ha encontrado al participante por medio del Apellid"<<endl;
                count<<"Su nombre completo es "<<Participantes[i][0]<<" "<<Participantes[i][1]<<endl;
                break;
            }
        }
    }
    else
    {
        for(int i=0; i<  LargoDeArreglo,i++  )
        {
            if(texto==Participantes[0][i])
            {
                cout<<"Se ha encontrado al participante por medio del Nombre"<<endl;
                count<<"Su nombre completo es "<<Participantes[i][0]<<" "<<Participantes[i][1]<<endl;
                break;
            }
        }
    }
}
void Order_Nombre_Letra(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, char Letra)
{
    string ListaDeApellido[MAXPARTICIPANTES];
    string ListaDeNombre[MAXPARTICIPANTES];
    for(int i = 0; i < LargoDeArreglo; i++)
    {

    }
}
void Order_Apellid_Letra(char *texto, string Participantes[][MAXPARTICIPANTES])
{
    char Letras[]= {'A','B','C','D','F','G','H','I','J','K','L','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char NombreActual = Participantes[0][0];
    Participantes=toupper(Participantes);
    for(int j = 0; j<LargoDeArreglo; i++)
    {
        char NombreActual = Participantes[1][j];
        for(int i=0; i<strlen(Letras); i++)
        {
            if(NombreActual == Letras)
            {
                cout<<NombreActual;
            }
            Letra++;
        }
    }
}
void Mostrar_Nombre_Apellido(char *texto, string Participantes[][MAXPARTICIPANTES], int LargoDeArreglo, char Letra)
{
    char Letras[]= {'A','B','C','D','F','G','H','I','J','K','L','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char NombreActual = Participantes[0][0];
    Participantes=toupper(Participantes);
    for(int j = 0; j<LargoDeArreglo; i++)
    {
        char NombreActual = Participantes[j][0];
        for(int i=0; i<strlen(Letras); i++)
        {
            if(NombreActual == Letras)
            {
                cout<<NombreActual;
            }
            Letra++;
        }
    }
}

