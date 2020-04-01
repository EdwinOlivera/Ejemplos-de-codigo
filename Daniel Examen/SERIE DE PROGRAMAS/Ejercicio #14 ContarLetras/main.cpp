#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    char LetrasConsonantes[]="bcdfghjklmnpqrstvwxyz", LetrasVocales[] = "aeiou";
    char Cadena[1400], Texto[]="El hombre piso blanduzco, y en seguida sintio la mordedura en el pie. Salto adelante, y al volverse con un juramento vio una yararacusu que arrollada sobre si misma esperaba otro ataque. El hombre echo una veloz ojeada a su pie, donde dos gotitas de sangre engrosaban dificultosamente, y saco el machete de la cintura. La vibora vio la amenaza, y hundio mas la cabeza en el centro mismo de su espiral; pero el machete cayo de lomo, dislocandole las vertebras. El hombre se bajo hasta la mordedura, quito las gotitas de sangre, y durante un instante contemplo. Un dolor agudo nacia de los dos puntitos violetas, y comenzaba a invadir todo el pie. Apresuradamente se ligo el tobillo con su pañuelo y siguio por la picada hacia su rancho. El dolor en el pie aumentaba, con sensacion de tirante abultamiento, y de pronto el hombre sintio dos o tres fulgurantes puntadas que como relampagos habian irradiado desde la herida hasta la mitad de la pantorrilla. Movia la pierna con dificultad; una metalica sequedad de garganta, seguida de sed quemante, le arranco un nuevo juramento. Llego por fin al rancho, y se echo de brazos sobre la rueda de un trapiche. Los dos puntitos violeta desaparecian ahora en la monstruosa hinchazon del pie entero. La piel parecia adelgazada y a punto de ceder, de tensa. Quiso llamar a su mujer, y la voz se quebro en un ronco arrastre de garganta reseca. La sed lo devoraba";
    int TotalCaracteres=0, TotalVocales=0, totalConsonantes=0;
    int VocalesEncontradas=0, ConsonantesEncontradas=0, PalabrasConVocales=0, PalabrasConConsonantes=0, PalabrasIgual=0;
    TotalCaracteres=strlen(Texto);
    totalConsonantes = strlen(LetrasConsonantes);
    TotalVocales = strlen(LetrasVocales);
    for(int i=0; i<= TotalCaracteres; i++) //Trasladando una cadena a otra
    {
        Cadena[i]=Texto[i];
    }
    cout<<"Acontinuacion se imprimira la cadena de "<<TotalCaracteres<<" caracteres"<<endl;
    cout<<"\n"<<Cadena<<endl;
    for(int i=0; i<= TotalCaracteres; i++) //Convierte la cadena en minuscula TODA
    {
        Cadena[i]=tolower(Texto[i]);
    }

    for(int j=0; j<= TotalCaracteres; j++)
    {


            for(int C=0; C < totalConsonantes; C++)
            {
                if(Cadena[j]== LetrasConsonantes[C])
                {
                    ConsonantesEncontradas++;
                }
            }

            for(int V=0; V < TotalVocales; V++)
            {
                if(Cadena[j]== LetrasVocales[V])
                {
                    VocalesEncontradas++;
                }
            }

        if(Cadena[j]==' ' || Cadena[j]== Cadena[TotalCaracteres])
        {

            if(VocalesEncontradas>ConsonantesEncontradas)
            {
                PalabrasConVocales++;
            }
            if(VocalesEncontradas<ConsonantesEncontradas)
            {
                PalabrasConConsonantes++;
            }
            if(VocalesEncontradas==ConsonantesEncontradas)
            {
                PalabrasIgual++;
            }
            ConsonantesEncontradas=0;
            VocalesEncontradas=0;
        }


    }
    cout<<"\nEl numero de Palabras con mas CONSONANTES QUE VOCALES son:"<<PalabrasConConsonantes<<endl;
    cout<<"\nEl numero de Palabras con mas VOCALES QUE CONSONANTES son:"<<PalabrasConVocales<<endl;
    cout<<"\nEl numero de Palabras con IGUAL DE CONSONANTES Y VOCALES son:"<<PalabrasIgual<<endl;
    cout << "Final del Programa" << endl;
    return 0;
}
