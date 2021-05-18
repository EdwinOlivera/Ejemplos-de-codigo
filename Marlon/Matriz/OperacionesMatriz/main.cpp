#include <iostream>
#include <cmath>
#include <ctime>
#include <iomanip>

#define MAX 100
using namespace std;
class Matriz
{
public:
    Matriz(int dim);
    ~Matriz();
    int dimensionMatriz;
    float determinanteMatriz(double matrizGenerada[][MAX], int orden);
    void valorPropioMatriz(double matrizGenerada[][MAX]);
    void matrizInversa(double matrizGenerada[][MAX]);
    void formaTriangular(double matrizGenerada[][MAX]);
    void operacionesMatriz(double matrizGenerada[][MAX]);

    void gaussjordan(double  A[][MAX]);
    void identidad(double Ma[][MAX]);
    void cambiarFilas(double Matr[][MAX], int r1, int r2);
    void multiplarFilaConstante(double Matr[][MAX], int r, float c);
    void sumarFila(double Matr[][MAX], int r1, int r2, float c);

    void    convertirFormaTriangular(double matrizGenerada[][MAX], double  matrizGeneradaInversa[][MAX]);

private:
    float cofactor(double matrizGenerada[][MAX], int orden, int fila, int columna);
    float determinanteCalculado = 0;
    void matrizTranspuesta(double matrizGenerada[][MAX], double matrizGeneradaTranspuesta[][MAX]);
};
Matriz::Matriz(int dim)
{
    dimensionMatriz = dim;
}
Matriz::~Matriz()
{
    cout<<"Fin del programa."<<endl;
}
float Matriz::determinanteMatriz(double matrizGenerada[][MAX], int orden)
{
    float det = 0.0;

    if (orden == 1)
    {
        det = matrizGenerada[0][0];
    }
    else
    {
        for (int j = 0; j < orden; j++)
        {
            det = det + matrizGenerada[0][j] * cofactor(matrizGenerada, orden, 0, j);
        }
    }

    return det;
}

float Matriz::cofactor(double matriz[][MAX], int orden, int fila, int columna)
{
    double submatriz[MAX][MAX];
    int n = orden - 1;

    int x = 0;
    int y = 0;
    for (int i = 0; i < orden; i++)
    {
        for (int j = 0; j < orden; j++)
        {
            if (i != fila && j != columna)
            {
                submatriz[x][y] = matriz[i][j];
                y++;
                if (y >= n)
                {
                    x++;
                    y = 0;
                }
            }
        }
    }

    return pow(-1.0, fila + columna) * Matriz::determinanteMatriz(submatriz, n);
}


void Matriz::valorPropioMatriz(double matrizGenerada[][MAX])
{
}
void Matriz::matrizInversa(double matrizGenerada[][MAX])
{
    gaussjordan(matrizGenerada);
}
void Matriz::formaTriangular(double matrizGenerada[][MAX])
{
}
void Matriz::operacionesMatriz(double matrizGenerada[][MAX])
{
}

void Matriz::gaussjordan(double matrizGenerada[][MAX])
{

    double Inv[MAX][MAX];
    identidad(Inv);
    for (int i = 0; i < dimensionMatriz; i++)
    {
        if (matrizGenerada[i][i] == 0)
        {
            int r = 0;
            while (r < dimensionMatriz && (matrizGenerada[i][r] == 0 || matrizGenerada[r][i] == 0))
            {
                r++;
            }
            cambiarFilas(matrizGenerada,i,r);
        }
        double c = 1.0 / matrizGenerada[i][i];

        multiplarFilaConstante(matrizGenerada, i, c);
        multiplarFilaConstante(Inv, i, c);
        for (int j = 0; j < dimensionMatriz; j++)
        {
            if (i != j)
            {
                c = -matrizGenerada[j][i];
                sumarFila(matrizGenerada, j, i, c);
                sumarFila(Inv, j, i, c);
            }
        }
    }
    // volvemos los valores a la matriz original para mostrar la matriz inversa.
    for(int i=0; i<dimensionMatriz; i++)
    {
        for(int j = 0; j<dimensionMatriz; j++)
        {
            matrizGenerada[i][j] = Inv[i][j];
        }

    }
}


void Matriz::identidad(double Ma[][MAX])
{

    for (int i = 0; i < dimensionMatriz; i++)
    {
        for (int j = 0; j < dimensionMatriz; j++)
        {
            Ma[i][j] = 0.0;
        }
        Ma[i][i] = 1.0;
    }

}

void Matriz::cambiarFilas(double Matr[][MAX], int r1, int r2)
{
    double aux;
    for (int i = 0; i < dimensionMatriz; i++)
    {
        aux = Matr[r1][i];
        Matr[r1][i] = Matr[r2][i];
        Matr[r2][i] = aux;
    }

}



void Matriz::multiplarFilaConstante(double Matr[][MAX], int r, float c)
{
    for (int i = 0; i < dimensionMatriz; i++)
    {
        Matr[r][i] *= c;
    }
}

void Matriz::sumarFila(double Matr[][MAX], int r1, int r2, float c)
{
    for (int i = 0; i < dimensionMatriz; i++)
    {
        Matr[r1][i] += Matr[r2][i] * c;
    }
}
void Matriz::convertirFormaTriangular(double matrizGenerada[][MAX], double  matrizGeneradaInversa[][MAX])
{

    identidad(matrizGeneradaInversa);

    for(int i=0; i<dimensionMatriz; i++)
    {
        for(int j=0; j<dimensionMatriz; j++)
        {

            cout<<matrizGeneradaInversa[i][j]<<"    ";

        }
        cout<<" "<<endl;
    }
}




int main()
{
    srand(time(NULL));
    int dimencion=3;
    float deter = 0, numeroIngresadoParaOperaciones = 0;
    int numeroFilaColumna = 0;
    char operacion, filaColumna;
    double MatrizPrincipal[MAX][MAX], MatrizPrincipalCopia[MAX][MAX];
    cout<<"La Matriz generada es: "<<endl;
    for(int i=0; i<dimencion; i++)
    {
        for(int j=0; j<dimencion; j++)
        {
            MatrizPrincipal[i][j]= 1+ rand() %9;
            cout<<MatrizPrincipal[i][j]<<"    ";
            MatrizPrincipalCopia [i][j]=MatrizPrincipal[i][j];
        }
        cout<<" "<<endl;
    }

    Matriz mat = Matriz(dimencion);
    deter = mat.determinanteMatriz(MatrizPrincipal, dimencion);


    cout<<"\nDeterminante: "<<deter<<endl;
    if(deter!=0)
    {
        mat.matrizInversa(MatrizPrincipalCopia);


        cout<<"\nLa matriz Inversa es: "<<endl;
        for (int i = 0; i < dimencion; i++)
        {
            for (int j = 0; j < dimencion; j++)
            {
                cout<<setprecision(1)<<MatrizPrincipalCopia[i][j] <<" ";
            }
            cout<<endl;
        }


    }
    else
    {
        cout<<"El determinante es CERO (0), esta matriz no tiene inversa"<<endl;
    }

    cout<<"La matriz en su forma Trigular es: "<<endl;
    mat.convertirFormaTriangular(MatrizPrincipal, MatrizPrincipalCopia);

    cout<<"Que tipo de opreaciones quiere realizar? \n 1) multiplicar \n 2) sumar \n 3) dividir \n 4) restar"<<endl;
    cout<<"-> ";
    cin>>operacion;
    switch(operacion)
    {
    case'1':
            cout<<"Fila o columna? \n 1) fila \n 2) columna "<<endl;
        cout<<"-> ";
        cin>>filaColumna;
        switch(filaColumna)
        {
        case'1':
                cout<<"Ingrese el numero de la fila. \n -> ";
            cin>>numeroFilaColumna;
            if(numeroFilaColumna-1>dimencion)
            {
                cout<<"Ha ingresado el numero de fila no valido\n";
            }
            else
            {
                cout<<"Ingrse el numero con el cual se hara la multiplicacion:\n ->";
                cin>>numeroIngresadoParaOperaciones;
                for(int i = 0; i<dimencion; i++)
                {
                    MatrizPrincipal[numeroFilaColumna-1][i] *= numeroIngresadoParaOperaciones;
                }
            }
            break;
        case'2':
                cout<<"Ingrese el numero de columna. \n -> ";
            cin>>numeroFilaColumna;
            if(numeroFilaColumna-1>dimencion)
            {
                cout<<"Ha ingresado el numero de columna no valido\n";
            }
            else
            {
                cout<<"Ingrse el numero con el cual se hara la multiplicacion:\n ->";
                cin>>numeroIngresadoParaOperaciones;
                for(int i = 0; i<dimencion; i++)
                {
                    MatrizPrincipal[i][numeroFilaColumna-1] *= numeroIngresadoParaOperaciones;
                }
            }
        }
        break;



    break;
case'2':
        cout<<"Fila o columna? \n 1) fila \n 2) columna "<<endl;
    cout<<"-> ";
    cin>>filaColumna;
    switch(filaColumna)
    {
    case'1':
            cout<<"Ingrese el numero de la fila. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de fila no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la suma:\n ->";
            cin>>numeroIngresadoParaOperaciones;
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[numeroFilaColumna-1][i] += numeroIngresadoParaOperaciones;
            }
        }
        break;
    case'2':
            cout<<"Ingrese el numero de columna. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de columna no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la suma:\n ->";
            cin>>numeroIngresadoParaOperaciones;
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[i][numeroFilaColumna-1] += numeroIngresadoParaOperaciones;
            }
        }
        break;

    }
    break;

case'3':
        cout<<"Fila o columna? \n 1) fila \n 2) columna "<<endl;
    cout<<"-> ";
    cin>>filaColumna;
    switch(filaColumna)
    {
    case'1':
            cout<<"Ingrese el numero de la fila. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de fila no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la multiplicacion (n!=0) :\n ->";
            do
            {
                cin>>numeroIngresadoParaOperaciones;
                if(numeroIngresadoParaOperaciones == 0)
                {
                    cout<<"Ingrese un numero distinto de CERO"<<endl;
                }

            }
            while(numeroIngresadoParaOperaciones==0);
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[numeroFilaColumna-1][i] /= numeroIngresadoParaOperaciones;
            }
        }
        break;
    case'2':
            cout<<"Ingrese el numero de columna. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de columna no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la multiplicacion (n!=0) :\n ->";
            do
            {
                cin>>numeroIngresadoParaOperaciones;
                if(numeroIngresadoParaOperaciones == 0)
                {
                    cout<<"Ingrese un numero distinto de CERO"<<endl;
                }

            }
            while(numeroIngresadoParaOperaciones==0);
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[i][numeroFilaColumna-1] /= numeroIngresadoParaOperaciones;
            }
        }
        break;

    }
    break;

case'4':
        cout<<"Fila o columna? \n 1) fila \n 2) columna "<<endl;
    cout<<"-> ";
    cin>>filaColumna;
    switch(filaColumna)
    {
    case'1':
            cout<<"Ingrese el numero de la fila. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de fila no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la resta:\n ->";
            cin>>numeroIngresadoParaOperaciones;
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[numeroFilaColumna-1][i] -= numeroIngresadoParaOperaciones;
            }
        }
        break;
    case'2':
            cout<<"Ingrese el numero de columna. \n -> ";
        cin>>numeroFilaColumna;
        if(numeroFilaColumna-1>dimencion)
        {
            cout<<"Ha ingresado el numero de columna no valido\n";
        }
        else
        {
            cout<<"Ingrse el numero con el cual se hara la resta:\n ->";
            cin>>numeroIngresadoParaOperaciones;
            for(int i = 0; i<dimencion; i++)
            {
                MatrizPrincipal[i][numeroFilaColumna-1] -= numeroIngresadoParaOperaciones;
            }
        }
        break;

    }
    break;
default:
    cout<<"No se selecciono ninguna opcion"<<endl;
    break;

}

cout<<"La matriz despues de la operacion"<<endl;
for(int i=0; i<dimencion; i++)
{
    for(int j=0; j<dimencion; j++)
    {
        cout<<setprecision(1)<<MatrizPrincipal[i][j]<<"    ";

    }
    cout<<" "<<endl;
}

return 0;
}
