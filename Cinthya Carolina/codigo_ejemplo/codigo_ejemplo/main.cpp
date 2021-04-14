#include <iostream>
#include <string.h>
#include <chrono>
#include <random>

using namespace std;

int main()
{
//Cadena,C:ARREGLO QUE CONTIENE CARACTERES

    // char nombre[100] = {}, nombre2[] = {'j','o','s','e',' ','e','v','e','r','\0'};



    //std::cin >> nombre;

    //std::cout << nombre;

    // std::cout << nombre2<<std::endl;

    //std::cin.getline(nombre,99);

    //std:cout << nombre;



    // string a = { "hola " }, b = { "mundo" }, d{};//c++

    // std::cout << a+b<<std::endl;//concatenar

    // string c = { a + b };



    // std::cout << c<<std::endl;//copiar



    // std::cin >> d;



    // std::cout << d<<std::endl;

    // char p[] = "Hoy es jueves ocho de abril";
    // char delimitacio[] = "z";
    // auto r = strtok(p, delimitacio);

    // while(r!=NULL)
    // {
    //     std::cout<<r<<std::endl;
    //     r = strtok(NULL, delimitacio);
    // }

//manejo de cadenas al estilo C
    //arreglo de caracteres en memoria ram

    const char* p = "Es, pues, de saber que este sobredicho hidalgo, ";
    std::cout << p << std::endl;
    std::cout << strlen(p) << std::endl;//longitud de la cadena

	//argumento es un puntero
	//retorna: entero(no toma en cuenta al caracter de fin de linea)

	//char j[]="ghvs";
	//char *ptrj=&j[strlen(j)-1];
	//C++
	string q = "Es, pues, de saber que este sobredicho hidalgo, los ratos que estaba ocioso  con tanta y gusto, que casi de todo punto el ejercicio de la caza y aun la  de su hacienda";
	std::cout << q << std::endl;
	std::cout << q.length();
	std::cout << std::endl;



	char a[260] = "";
	strcpy(a, "Hola ");
	strcat(a, " ");//concatenar, unir, soldar, juntar...
	strcat(a, "mundo");
	strcat(a, " a todos");
	std::cout << a << std::endl;

	std::string d = "Hola "; string e = "mundo "; string f = "a todos";
	string todo = d + e + f;
	std::cout << todo << std::endl;

	char* pch=NULL;
	char cadena[] = "El rico se impresiono mucho, porque era un hombre muy .";
	pch = strtok(cadena, "o");//fijo
	while (pch != NULL)//fijo
	{
		std::cout << pch << std::endl;

		pch = strtok(NULL, "z");//fijo
	}

	string fr = "El rico se impresiono mucho, porque era un hombre muy.";
	std::cout << fr.substr(2, 12);
	std::cout << std::endl << std::endl;



	char pop[] = "Casa";
	if (isupper(pop[0])) { std::cout << "es"; }
	else { if (islower(pop[0])) { std::cout << "no es"; } }
	//toupper()
		//tolower()


	char arbol[100];
	std::cin.getline(arbol, 12);
	std::cout << arbol;
    return 0;
}
