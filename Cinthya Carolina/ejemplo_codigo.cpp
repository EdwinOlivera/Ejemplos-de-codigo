#include <iostream>

#include <chrono>

#include <random>

#include <iomanip>



using namespace std;

//semilla

//srand

//rand

//forma 1

auto semilla = std::chrono::steady_clock::now().time_since_epoch().count();

std::default_random_engine aleatorio(semilla);




//forma 2

std::random_device rd;

std::mt19937 gen(rd());

std::uniform_int_distribution<> distrib(2, 9);




#define alea distrib(gen)

#define peque const unsigned short

#define entero unsigned short

#define colum 3

#define fila  3

#define entero2 unsigned int




void llenar(entero*);

void desplegar(entero*);

void sumar(entero*, entero2*);

void desplegar(entero2*);//función sobrecargada



int main() {

	entero x[fila][colum] = {};

	entero2 temp{};

	entero* ptrx = &x[0][0];

	entero2* ptrtemp{&temp};



	llenar(ptrx);

	desplegar(ptrx);

	sumar(ptrx,ptrtemp);

	desplegar(ptrtemp);



	return 0;



}





void llenar(entero* x) {



	for (size_t i = 0; i < fila*colum; i++)

	{

		*x = alea;

		++x;

	}

}



void desplegar(entero* x) {



	for (size_t i = 0; i < fila * colum; i++)

	{

		std::cout<<setw(4)<<*(x+i);



		if (i % colum == 0) {

			std::cout << std::endl;

		}

	}

	std::cout << std::endl;

}



void sumar(entero* x, entero2* t) {

	for (size_t i = 0; i < fila * colum; i++)
	{
		*t += *(x + i);
	}

}



void desplegar(entero2* x) {



	std::cout << "El promedio del conjunto es " << *x / (float(fila) * colum);//casting



}
