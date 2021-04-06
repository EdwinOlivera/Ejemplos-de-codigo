#ifndef _BUSCAMINAS_H_
#define _BUSCAMINAS_H_

void nombrePrograma();
void limpiarMatriz(int Matriz[][30],int N);
void generarMarcoBuscaminas(int N);
void colocarDigitoHorizontal(int N);
void colocarDigitoVertical(int N);
int validarDimensionBuscaminas();
int validarNumeroMinas(int N);
void generarBuscaminas(char A[][30],int N,int m);
void contarMinasBuscamicas(char A[][30],int N);
void leerColocarDigitoBuscaminas(char A[][30],int i,int j,int n);
void reportarBuscaminasSinSolucion(char A[][30],int N);
void matrizBanderaAuxiliar(int B[][30],char A[][30],int N);
void reportarBuscaminasCasillaDestapada(int N,int X, int Y,int B[][30],char A[][30]);
int verificarCasillaDestapada(char[][30],int X,int Y,int M);
void mostrarContenidoCasillaDestapada(int B[][30],char A[][30],int N);
void verificarAdyacente(int B[][30],int i, int j);
int ContarMinasSinDestapar(int N,int B[][30]);

#endif
