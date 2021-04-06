#include <conio.h>
#include <cstdlib>
#include <iostream>
#include "Buscaminas.h"
#include "CONSOLA.H"
using namespace std;

int main(int argc, char *argv[]) {
    IniciarConsola("BUSCAMINAS (KERNEL INFORMATICO 1.0)  ",100,100);
    system("color 70");
	char A[30][30];
	int B[30][30];
	int N=0;
    int minas=0;
    int cont=0;
    int X=0;
    int Y=0;
	N=validarDimensionBuscaminas();
	minas=validarNumeroMinas(N);
	generarBuscaminas(A,N,minas);
	contarMinasBuscamicas(A,N);
	generarMarcoBuscaminas(N);
	gotoxy(3,1);
	colocarDigitoHorizontal(N);
	gotoxy(3,3);
	reportarBuscaminasSinSolucion(A,N);
	colocarDigitoVertical(N);
	gotoxy(N+(N+3)*2,2);
    nombrePrograma();
   	matrizBanderaAuxiliar(B,A,N);
	cout<<endl<<endl;
	do {
        gotoxy(N+(N+3)*2,4);
        cout<<"Existen "<<minas<<" minas."<<endl<<endl;
        do {
            gotoxy(N+(N+3)*2,6);
            cout<<"ingrese posicion fila: ";
            cin>>X;
            gotoxy(N+(N+3)*2,8);
            cout<<"ingrese posicion columna: ";
            cin>>Y;
            if(X>N || Y>N ||X<=0||Y<=0) {
                gotoxy(N+(N+3)*2,10);
                cout<<"posicion no valida"<<endl;
            }  
        }while(X>N || Y>N ||X<=0||Y<=0);
        system("cls");
        reportarBuscaminasCasillaDestapada(N,X,Y,B,A);
        generarMarcoBuscaminas(N);
        gotoxy(3,1);
        colocarDigitoHorizontal(N);
        gotoxy(3,3);
        mostrarContenidoCasillaDestapada(B,A,N);
        colocarDigitoVertical(N);
        gotoxy(N+(N+3)*2,2);
        nombrePrograma();
        cont=ContarMinasSinDestapar(N,B);
        cout<<endl<<endl;
        if(verificarCasillaDestapada(A,X,Y,N)!=1) {
            gotoxy(N+(N+3)*2,4);
            cout<<"PERDISTE!!!"<<endl;
        }
        if(cont==minas && verificarCasillaDestapada(A,X,Y,N)==1) {
            gotoxy(N+(N+3)*2,4);
            cout<<"GANASTE!!!"<<endl;
        }
    }while(verificarCasillaDestapada(A,X,Y,N)==1 && cont!=minas);
    getch();
    CerrarConsola();
    return EXIT_SUCCESS;
}
