#include <iostream>
#include <cstdlib>
#include <cstring>
#include <stdio.h>
using namespace std;

int main(){
	char oracion[100];
    int i, contPalabras = 1;
    cout<<"Ingrese una oracion: "<<endl;

//Esta funcion "fgets" permite almacenar cadenas, incluyendo espacios en blancos
	fgets(oracion, 100, stdin);

	for(i = 0; i < strlen(oracion); i++){
//Este if verifica si hay un espacio en blanco en el incio. Pero no tiene que estar al inicio el espacio, y no tiene que ver dos seguidos
		if(oracion[i] == ' ' && i > 0 && oracion[i - 1] != ' '){
    //En caso que solo este bien, se sumara la variable en 1
    //este contador, cuenta el numero de palabras que hay en una oracion
			contPalabras++;
		}
	}
	cout<<"Cantidad de palabras: "<<contPalabras<<endl;//Aqui se muestra el numero de palabras que tiene la oracion/parrafo
	system("pause");//Realiza una pausa en el sistema, para que no termine adbrutamente
    return 0;
}
