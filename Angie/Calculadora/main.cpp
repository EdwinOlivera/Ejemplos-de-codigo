#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <string>

float IngresarDatos();

//Operaciones basicas
void Sumar(float *num1, float *num2, float *resultado);
void Restar(float *num1, float *num2, float *resultado);
void Dividir(float *num1, float *num2, float *resultado);
void Multiplicar(float *num1, float *num2, float *resultado);
void Potencia(float *valor, float *resultado);
void RaizCuadrada(float *valor, float *resultado);

//Operaciones Avanzadas
void FuncionExponencial(float *valor, float *resultado);
void Logaritmo(float *valor, float *resultado);
void Redondeo(float *valor, float *resultado);
void ValorAbsoluto(float *valor, float *resultado);

//Operaciones Especiales
void NumeroPrimo(float *valor, float *resultado);
void FactorizarNumero(float *valor);
void ValorEnCadena(float *valor);
void Modulo(float *valor, float *resultado);


int main()
{
    //Calculadora que utiliza apuntadores para hacer sus operaciones matematicas
    int opcion;


    float num1,num2;
    float resultado = 0;
    float *apuGen;
    float *apuNum1, *apuNum2;


    //Apuntando a las variables
    apuGen = &resultado;
    apuNum1  = apuGen;
    apuNum1 = &num1;
    apuNum2 = &num2;
    std::cout<<"Ingrese el primer valor"<<std::endl;
    num1 = IngresarDatos();//

    std::cout<<"Ingrese el Segundo valor"<<std::endl;
    num2 = IngresarDatos();



    do
    {

        std::cout<<"Menu principal"<<std::endl;

        std::cout<<"----->Operaciones Basicas<-----"<<std::endl;
        std::cout<<"1 = Sumar ("<<*apuNum1<<"+"<<*apuNum2<<")"<<std::endl;
        std::cout<<"2 = Restar ("<<*apuNum1<<"-"<<*apuNum2<<")"<<std::endl;
        std::cout<<"3 = Multiplicar ("<<*apuNum1<<"*"<<*apuNum2<<")"<<std::endl;
        std::cout<<"4 = Dividir ("<<*apuNum1<<"/"<<*apuNum2<<")"<<std::endl;
        std::cout<<"5 = Potencia de "<<*apuNum1<<"("<<*apuNum1<<"^n)"<<std::endl;
        std::cout<<"6 = Potencia de "<<*apuNum2<<"("<<*apuNum2<<"^n)"<<std::endl;
        std::cout<<"7 = Raiz cuadrada de "<<*apuNum1 <<"(sqrt("<<*apuNum1<<"))"<<std::endl;
        std::cout<<"8 = Raiz cuadrada de "<<*apuNum2 <<"(sqrt("<<*apuNum2<<"))"<<std::endl;


        std::cout<<"----->Operaciones Avanzadas<-----"<<std::endl;
        std::cout<<"9 = Funcion Exponencial de F(x) = e^"<<*apuNum1<<std::endl;
        std::cout<<"10 = Logaritmo Neperiamo de "<<*apuNum1<<std::endl;
        std::cout<<"11 = Redondeo al entero mas cercano de "<<*apuNum1<<std::endl;
        std::cout<<"12 = Valor absoluto de "<<*apuNum1<<std::endl;


        std::cout<<"----->Operaciones Especiales<-----"<<std::endl;
        std::cout<<"13 = Determinar numero primo a: "<<*apuNum1<<std::endl;
        std::cout<<"14 = Factores primos de: "<<*apuNum1<<std::endl;
        std::cout<<"15 = Valor en cadena de: "<<*apuNum1<<std::endl;
        std::cout<<"16 = Calculo de Modulo de: "<<*apuNum1<<std::endl;

        std::cout<<"----->Acciones del sistema<-----"<<std::endl;
        std::cout<<"98 = Reaccinar el Primer valor"<<std::endl;
        std::cout<<"99 = Reaccinar el Segundo valor"<<std::endl;
        std::cout<<"0 = Salir del sistema"<<std::endl;
        std::cout<<"Ingrese [0 - 16, 98,99] -> ";
        std::cin>>opcion;
        std::cout<<std::endl;
        switch(opcion)
        {
        //Operaciones Basicas
        case 98:
            std::cout<<"Ingrese el nuevo Primer valor"<<std::endl;
            num1 = IngresarDatos();//No se sabe porque es necesario usar 2 veces la misma funcion para que funcione
            num1 = IngresarDatos();
            break;
        case 99:
            std::cout<<"Ingrese el nuevo Segundo valor"<<std::endl;
            num2 = IngresarDatos();//No se sabe porque es necesario usar 2 veces la misma funcion para que funcione
            num2 = IngresarDatos();
            break;
        case 1:
            Sumar(apuNum1,apuNum2,apuGen);

            std::cout<<"La suma es: "<<resultado<<std::endl;

            break;
        case 2:

            Restar(apuNum1,apuNum2,apuGen);

            std::cout<<"La resta es: "<<resultado<<std::endl;

            break;
        case 3:
            Multiplicar(apuNum1,apuNum2,apuGen);

            std::cout<<"La mulplicacion es: "<<resultado<<std::endl;

            break;
        case 4:
            Dividir(apuNum1,apuNum2,apuGen);

            std::cout<<"La division es: "<<resultado<<std::endl;

            break;
        case 5:
            Potencia(apuNum1,apuGen);

            std::cout<<"La Potencia de "<<num1<<" es: "<<resultado<<std::endl;

            break;
        case 6:
            Potencia(apuNum2,apuGen);

            std::cout<<"La Potencia de "<<num2<<" es: "<<resultado<<std::endl;
            break;
        case 7:
            RaizCuadrada(apuNum1,apuGen);

            std::cout<<"La Raiz cuadrad de  "<<num1<<" es: "<<resultado<<std::endl;
            break;
        case 8:
            RaizCuadrada(apuNum2,apuGen);

            std::cout<<"La Raiz cuadrad de  "<<num2<<" es: "<<resultado<<std::endl;
            break;
        //Operaciones Avanzadas
        case 9:
            FuncionExponencial(apuNum1,apuGen);
            std::cout<<"Funcion exponencial de e^x evaluado x = "<<num1<<" es: "<<resultado<<std::endl;
            break;
        case 10:
            Logaritmo(apuNum1, apuGen);
            std::cout<<"El logaritmo neperiano de "<<num1<<" es: "<<resultado<<std::endl;
            break;
        case 11:
            Redondeo(apuNum1, apuGen);
            std::cout<<"El Redondeo de "<<num1<<" es: "<<resultado<<std::endl;
            break;
        case 12:
            ValorAbsoluto(apuNum1,apuGen);
            std::cout<<"El valor absoluto de "<<num1<<" es: "<<resultado<<std::endl;
            break;
        case 13:
            NumeroPrimo(apuNum1, apuGen);

            break;
        case 14:
            FactorizarNumero(apuNum1);
            break;
        case 15:

            ValorEnCadena(apuNum1);
            break;
        case 16:

            Modulo(apuNum1,apuGen);


            break;
        case 0:
            std::cout<<"Saliendo del sistema"<<std::endl;
            break;

        }
        std::cout<<std::endl;
    }
    while(opcion!=0);
    return 0;
}
float IngresarDatos()
{
    int posicionDecimal=-1;// 31212 . 12121, 12.1223
    float tmpNumero = 0, auxNum = 1;
    float numero = 0.0;
    float pi = 3.1416, euler = 2.7118;
    char textoIngresado[12];
    std::string decimales, tmpString ;
    std::cin.getline(textoIngresado,12);// 3.455
    //Pone en minuscula la cadena ingregasa= PI == pi
    while(textoIngresado[(int)tmpNumero]!='\0' )
    {

        textoIngresado[(int)tmpNumero] =  tolower(textoIngresado[(int)tmpNumero]);
        tmpString +=  textoIngresado[(int)tmpNumero];

        tmpNumero++;

    }

    tmpNumero=0;

    if(tmpString == "pi")
    {

        numero = pi;
    }
    else if(tmpString == "e")
    {

        numero = euler;
    }
    else
    {

        while(textoIngresado[(int)tmpNumero]!='\0' )
        {
            if(textoIngresado[(int)tmpNumero] == '.')
            {
                posicionDecimal = tmpNumero;
            }

            //3.1234
            // 1234// 323.412 // 4 / 10 = 0.4// 40 /100 = 0.40// 412/1000 = 0.412
            if(posicionDecimal !=-1 && textoIngresado[posicionDecimal+1] !='\0' )
            {
                tmpNumero = posicionDecimal+1;
                while(textoIngresado[(int)tmpNumero]!='\0' )
                {
                    decimales +=  textoIngresado[(int)tmpNumero];

                    auxNum*=10;
                    tmpNumero++;
                }
                posicionDecimal=-1;
            }
            tmpNumero++;
        }
//ABC = ['A', 'B', 'C'] "656" = 656/1000 = 0.656
        tmpNumero = atoi(decimales.c_str());

        tmpNumero = (tmpNumero/auxNum);
        if(atoi(textoIngresado)<0)
        {
            // -3 + 0.12 = -2.88// -3.12
            numero = atoi(textoIngresado) - tmpNumero;
        }
        else
        {
            // +3 + 0.12 = 3.12
            numero = atoi(textoIngresado) + tmpNumero;
        }

    }
    return numero;
}

//Operaciones Basica
void Sumar(float *num1, float *num2, float *resultado)
{
    *resultado = *num1 + *num2;
}
void Restar(float *x, float *num2, float *resultado)
{
    *resultado = *x - *num2;
}

void Dividir(float *x, float *num2, float *resultado)
{
    *resultado  = 0;
    if(*num2 !=0)
        *resultado = *x / *num2;
    else
        std::cout<<"No se puede hacer la division"<<std::endl;
}
void Multiplicar(float *x, float *num2, float *resultado)
{
    *resultado = *x * *num2;
}
void Potencia(float *valor, float *resultado)
{
    int potenciaSelec = 0;
    std::cout<<"Ingrese la potencia a elevar a "<<*valor<<std::endl;
    std::cin>>potenciaSelec;
    *resultado = pow(*valor,potenciaSelec);
}
void RaizCuadrada(float *valor, float *resultado)
{
    *resultado = 0;
    if(*valor>=0)
    {
        *resultado = sqrt(*valor);
    }
    else
        std::cout<<"No se puede calcular la Raiz cuadrada"<<std::endl;

}

//Operaciones Avanzadas
void FuncionExponencial(float *valor, float *resultado)
{
    float euler = 2.718281828;
    *resultado = pow(euler, *valor);

}
void Logaritmo(float *valor, float *resultado)
{
    if(*valor >=0)
        *resultado = log(*valor);
    else
        std::cout<<"No se puede calcular el logaritmo neperiano"<<std::endl;
}
void Redondeo(float *valor, float *resultado)
{

//3.14 =3, 3.6 = 4
    if(*valor-floor(*valor)>ceil(*valor)-*valor)
        *resultado = ceil(*valor);
    else
        *resultado = floor(*valor);
}
void ValorAbsoluto(float *valor, float *resultado)
{
    *resultado = abs((int)*valor);
}

//Operacion Especiales
void NumeroPrimo(float *valor, float *resultado)
{
    int divisor = 1, divisores = 0;
// 2, 3, 5 , 7, 11, 13, 23,
    do
    {
        if((int)*valor % divisor == 0)
        {
            divisores++;
        }
        divisor++;
    }
    while(divisor <= *valor);

    if(divisores == 2)
    {
        std::cout<<"n-> El numero "<<*valor<<" es PRIMO.";
    }
    else
    {
        std::cout<<"n-> El numero "<<*valor<<" NO es PRIMO.";
    }
}

void FactorizarNumero(float *valor)
{
// 12 / 2 = 6 / 2 = 3 / 3 = 1
// -12 / 2 = -6 / 2 = -3 / 3 = -1
    int numer;
    numer = 2;
    float numeroRecibidio = *valor;
    while (numeroRecibidio!=1)
    {
        if ((int)numeroRecibidio%numer==0)
        {
            std::cout <<numer<<std::endl;
            numeroRecibidio = numeroRecibidio/numer;
            if(numeroRecibidio ==-1)
            {
                numeroRecibidio *=numeroRecibidio;
            }
        }
        else
            numer++;
    }

}

void ValorEnCadena(float *valor)
{
    // ASCII = A => 65, B =>66, C=>67
    char character;
    if(*valor>64 && *valor<91 )
    {
        character = *valor;
        std::cout<<character<<std::endl;

    }
    else if(*valor>96 && *valor<123)
    {
        character = *valor;
        std::cout<<character<<std::endl;
    }
    else
    {
        character = *valor;
        std::cout<<"El caracter no es una letra, sino que es "<<character<<std::endl;
    }
}

void Modulo(float *valor, float *resultado)
{
    int modulo = 1;
    std::cout<<"Ingrese el valor para sacar el modulo de "<<*valor<<" : ";
    std::cin>>modulo;
    *resultado = ((int)*valor)%modulo;
    std::cout<<"El modulo de "<<*valor<<" con "<<modulo<<" es: "<<*resultado<<std::endl;
}
