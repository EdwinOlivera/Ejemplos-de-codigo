/*******************************************************************************
                               JUEGO BUSCAMINAS
                               ================
Autor:
       - César Velásquez Haro
         Ingeniero Informático
         Universidad Nacional de Trujillo

Copyright:

Esta Proyecto es gratuito. La única restricción es que no debes borrar los 
créditos del autor de la cabecera de este archivo.
*******************************************************************************/

#include <conio.h>
#include <iostream>
#include "Buscaminas.h"
#include "CONSOLA.H"
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

using namespace std;
/*FUNCION PARA MOSTRAR EL NOMBRE
  DEL PROGRAMA EN PANTALLA*/

void nombrePrograma() {   
     cout<<"JUEGO BUSCAMINAS"<<endl;
}
 
/*FUNCION PARA LIMPIAR UNA
  MATRIZ DE ENTEROS*/

void limpiarMatriz(int Matriz[][30],int N) {
    int i;
    int j;
    for(i=0;i<N;i++) {
        for(j=0;j<N;j++) {
            Matriz[i][j]=0;
        }
    }
}

/*FUNCION PARA COLOCAR POSICION
  DE LAS COLUMNAS*/

void colocarDigitoHorizontal(int N) {
    int i=0;
    for(i=1;i<=N;i++) {
        if(i<10) {  
            cout<<i<<"  ";
        }else {
            cout<<i<<" ";
        }
    }
}

/*FUNCION PARA COLOCAR POSICION
  DE LAS FILAS*/

void colocarDigitoVertical(int N) {
    int i=0;
    gotoxy(0,3);
    for(i=1;i<=N;i++) {
        cout<<i<<"\n\n";
    }
}

/*FUNCION PARA VALIDAR LAS 
  DIMENSIONES DEL BUSCAMINAS*/

int validarDimensionBuscaminas() {
    int N,M;
    do {
        gotoxy(33,0);
        nombrePrograma();
        gotoxy(16,4);
		cout<<"Ingrese numero de columnas del buscaminas: ";
		cin>>N;
		gotoxy(16,7);
		cout<<"Ingrese el numero de filas del buscaminas: ";
		cin>>M;
		if((M!=N)||(M+N<18)||(M+N>40)) {
            gotoxy(11,10);
            cout<<"la matriz debe ser cuadrada, dimensiones(min=9 y max=20)\n\n";
            getch();
        }
        system("cls");
    } while((M!=N)||(M+N<18)||(M+N>40));
	return(N);
}

/*FUNCION QUE PERMITE VALIDAR EL NUMERO DE MINAS*/

/////////////////////////////////////////////////////////
//                 MINIMO "20" MINAS                   //
//  MAXIMO NUMERO DE CASILLEROS ENTRE ENTRE DOS(N*N/2) //
/////////////////////////////////////////////////////////

int validarNumeroMinas(int N) {
    int minas=0;
    do {
        gotoxy(33,0); 
        nombrePrograma();
        gotoxy(29,3);
        cout<<"ingrese numero de minas: ";
        cin>>minas;
        if(minas<=9 ||minas>N*N/2) {
            gotoxy(13,5);
            cout<<"Valor no aceptado(min=10 minas y max=#casillas/2 minas)"<<endl;
            getch();
        }
        system("cls");
    } while(minas<=9 || minas>N*N/2);
    return(minas);
}

/*FUNCION PARA GENERAR BUSCAMINAS*/

void generarBuscaminas(char A[][30],int N,int m) {
    int i;
    int j;
    int k;
    int a;
    int b;
    k=0;
    srand((unsigned) time(NULL));
    while(k<m) {
        A[rand()%N][rand()%N]='*';
        k=0;
        for(i=0;i<N;i++) {
            for(j=0;j<N;j++) {
                if(A[i][j]=='*') {
                    k=k+1;
                }else {
                    A[i][j]='0';
                }
            }
        }
    }
}

/*FUNCION QUE COLOCA EL DIGITO
  CORRESPONDIENTE EN UNA CASILLA*/

void leerColocarDigitoBuscaminas(char A[][30],int i,int j,int n) {
    if(n==1) {
        A[i][j]='1';
    }else {
        if(n==2) {
            A[i][j]='2';
        }else {
            if(n==3) {
                A[i][j]='3';
            }else {
                if(n==4) {
                    A[i][j]='4';
                }else {
                    if(n==5) {
                        A[i][j]='5';
                    }else {
                        if(n==6) {
                            A[i][j]='6';
                        }else {
                            if(n==7) {
                                A[i][j]='7';
                            }else {
                                if(n==8) {
                                    A[i][j]='8';
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/*FUNCION PARA COLOCAR LOS DIGITOS 
  EN EL INTERIOR DEL BUSCAMINAS*/
  
void contarMinasBuscamicas(char A[][30],int N) {
    int i;
    int j;
    int k;
    int n;
    k=0;
    n=0;
    for(i=0;i<N;i++) {
        for (j=0;j<N;j++) {
             if(A[i][j]!='*') {
                k=j-1;
                n=0;
                while(k<=j+1) {
                    if (A[i-1][k]=='*') {
                        n=n+1;
                    }
                    if(A[i][k]=='*' && k!=j) {
                        n=n+1;
                    }
                    if(A[i+1][k]=='*') {
                        n=n+1;
                    }
                    k=k+1;
                }
                if(n!=0) {
                    leerColocarDigitoBuscaminas(A,i,j,n);      
                }
            }
        }
    }
}

/*FUNCION QUE REPORTA EL BUSCAMINAS SIN SOLUCION*/

void reportarBuscaminasSinSolucion(char A[][30],int N) {
    int i=0,j=0,k=0;
    for(i=0;i<N;i++) {
        if(i<j) {
            cout<<endl<<endl;
            cout<<"  º";
        }
        for(j=0;j<N;j++) {
            cout<<"Û";
            if(j<N-1) {
                cout<<"  ";
            }
        }
    }
}

/*FUNCION QUE PERMITE LLENAR UNA MATRIZ AUXILIAR
  LA CUAL SERVIRA PARA MOSTRAR LAS CASILLAS
  DESTAPADAS DEL BUSCAMINAS*/

void matrizBanderaAuxiliar(int B[][30],char A[][30],int N) {
    limpiarMatriz(B,N);
    int i=0,j=0,k=0;
    for(i=0;i<N;i++) {
        for(j=0;j<N;j++) {
            if(A[i][j]=='0') {   
                k=j-1;
                while(k<=j+1) {
                    if(0<=k && k<N && i<N-1) {
                        B[i+1][k]=-1;
                    }
                    if(0<=k&&k<N) {
                        B[i][k]=-1;
                    }
                    if(0<=k && 0<i && k<N) {
                        B[i-1][k]=-1;
                    }
                    k=k+1;
                }   
            }else {
                if(B[i][j]!=-1) {
                    B[i][j]=1;
                }
            }          
        }
    }
}


/*FUNCION PARA ANALIZAR LAS CASILLAS
  ADYACENTES A UNA CASILLA VACIA*/

void verificarAdyacente(int B[][30],int i, int j) {
    B[i][j]=0;
    if(B[i][j-1]==-1) {
        verificarAdyacente(B,i,j-1);
    }
    if(B[i][j+1]==-1) {
        verificarAdyacente(B,i,j+1);
    }
    if(B[i-1][j]==-1) {
        verificarAdyacente(B,i-1,j);
    }
    if(B[i+1][j]==-1) {
        verificarAdyacente(B,i+1,j);
    }
}

/*FUNCION QUE REPOTRA EL BUSCAMINAS
  CON CASILLA DESTAPADA*/

void reportarBuscaminasCasillaDestapada(int N,int n,int m,int B[][30],char A[][30]) {
    int i=0,j=0;
	int X;
	int Y;
	X=n-1;
	Y=m-1;
	for(i=0;i<N;i++) {
        for(j=0;j<N;j++) {
            if(i==X && j==Y) {
                if(B[i][j]==-1 && A[i][j]=='0') {
                    verificarAdyacente(B,i,j);
                    i=N;
                }else {
                    B[i][j]=0;
                    i=N;
                }
            }
        }
    }
}

/* FUNCION QUE PERMITE SEGUIR JUGANDO MIENTRAS
   NO SE ENCUENTRE UNA MINA*/
   
//////////////////////////////////////////////////////////  
//    RETORNA 1 SI LA CASILLA NO CONTIENE UNA MINA      //
// RETORNA -1 SI LA CASILLA ESTA OCUPADA POR UNA MINA   //
//////////////////////////////////////////////////////////

int verificarCasillaDestapada(char A[][30],int n,int m,int N) {
    int i,j,X,Y;
    int digito=0;
    X=n-1;
    Y=m-1;
    for(i=0;i<N;i++) {
        for(j=0;j<N;j++) {
            if(i==X&&j==Y) {
                if(A[i][j]!='*') {
                    digito=1;
                    i=N;
                }else {
                    digito=-1;
                    i=N;
                }
            }
        }
    }
    return(digito);
}

/*FUNCION QUE PERMITE MOSTRAR
  LO QUE CONTIENE EN UNA CASILLA*/

void mostrarContenidoCasillaDestapada(int B[][30],char A[][30],int N) {
    int i=0,j=0;
    for(i=0;i<N;i++) {
        if(i<j) {
            cout<<endl<<endl;
            cout<<"  º";
        }
        for(j=0;j<N;j++) {
            if(B[i][j]==0) {
                cout<<A[i][j];
                if(j<N-1) {
                    cout<<"  ";
                }
            }else {
                cout<<"Û";
                if(j<N-1) {
                    cout<<"  ";
                }
            }
        }
    }
}

/*FUNCION QUE PERMITE VERIFICAR SI EL JUGAGOR A 
  GANADO CONTANDO LAS CASILLAS SIN DESTAPAR*/
  
  //////////////////////////////////////
  // SI EL NUMERO DE CASILLAS TAPADAS //
  //  ES IGUAL AL NUMERO DE MINAS EL  //
  //           JUGADOR A GANADO       //
  //////////////////////////////////////
  
int ContarMinasSinDestapar(int N,int B[][30]) {
    int i=0,j=0;
	int cont;
	cont = 0;
	for(i=0;i<N;i++) {
        for(j=0;j<N;j++) {
            if(B[i][j]==1) {
                cont=cont+1;
            }
        }
    }
    return(cont);
}

/*FUNCION QUE GENERARA EL MARCO DEL BUSCAMINAS*/

void generarMarcoBuscaminas(int N) {
    clrscr();
	gotoxy(2,2);
	cout<<"É";
	gotoxy(3,2);
	for(int i=0;i<(N+(N-1)*2)+1;i++) {
        cout<<"Í";
	}
	gotoxy(N+N*2+1,2);
	cout<<"»";
	gotoxy(N+N*2-1,3);
	for(int j=1;j<2*N;j++) {
        gotoxy(N+N*2+1,j+2);
		cout<<"º";
    }
    gotoxy(N+N*2+1,2*N+2);
	cout<<"¼";
	gotoxy(N,N-1);
	for(int k=N+N*2;k>1;k--) {
        gotoxy(k,2*N+2);
		cout<<"Í";
	}
	gotoxy(2,2*N+2);
	cout<<"È";
	gotoxy(1,2*N-1);
	for(int l=2*N+1;l>=3;l--) {
        gotoxy(2,l);
		cout<<"º";
    }
}
