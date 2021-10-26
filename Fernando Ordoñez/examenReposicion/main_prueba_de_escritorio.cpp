#include <iostream>
#include <cstring>

using namespace std;
void interesante(char *, char *, char *, int clave);
void codificar(char *cadena, int clave);
int main()
{

    char cadena1[10] = "hola";
    char cadena2[10];
    char caden1[10];
    int n1;

    cout << "Ingrese una cadena: ";
    cin.getline(cadena2, 10);
    cout << "Ingrese otra cadena: ";
    cin.getline(cadena3, 10);
    cout << "\nIngrse un numero entero (1 0 2)";
    cin >> n1;
    interesante(cadena1, cadena2, cadena3, n1);
    cout << cadena1, << endl
                     << endl;
    return 0;
}

void interesante(char *cadena1, char *cadena2, char *cadena3, in n)
{
    if (n == 1)
    {
        strcat(cadena1, " ");
        strcat(cadena1, cadena2);
        strcat(cadena1, " ");
        strcat(cadena1, cadena3);
    }
    else
    {
        strcat(cadena1, " ");
        strcat(cadena1, cadena3);
        strcat(cadena1, " ");
        strcat(cadena1, cadena2);
    }
}
void codificar(char *cadena, int clave)
{
    int letraActual = 0;
    int cantidadAvanzar = 1;
    char letrasMayusculas[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char letraACambiar[] = "";
    //cadena[1] ='g';
    while (cadena[letraActual] != '\0')
    {
        for (int i = 0; i < 26; i++)
        {
            if (letrasMayusculas[i] == cadena[letraActual])
            {
                if (i + clave >= 25)
                {
                    cantidadAvanzar = (i + clave);
                    cantidadAvanzar = cantidadAvanzar - 25;
                }
                else
                {

                    cantidadAvanzar = i + clave;
                }
                letraACambiar[0] = letrasMayusculas[cantidadAvanzar];
                cadena[letraActual] = letraACambiar[0];

                break;
            }
        }
        letraActual++;
    }
}
