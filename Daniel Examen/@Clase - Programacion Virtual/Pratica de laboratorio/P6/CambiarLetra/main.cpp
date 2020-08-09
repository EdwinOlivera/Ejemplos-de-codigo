#include <iostream>

using namespace std;

int main()
{
    char cadenaA[1000];
    cin.getline(cadenaA,1000);
    for(int iterador = 0; iterador<1000; iterador++)
    {

        if(cadenaA[iterador] == 'o'  && cadenaA[iterador+1] != 's')
        {
            if(cadenaA[iterador+1] == '\0')
                cadenaA[iterador] =  'a';
            else if(cadenaA[iterador+1] == ' ' || (int)cadenaA[iterador+1] <65)
                cadenaA[iterador] =  'a';

        }
        else if(cadenaA[iterador] == 'o' && cadenaA[iterador+1] == 's')
        {
            if(cadenaA[iterador+2] == '\0')
                cadenaA[iterador] =  'a';
            else if(cadenaA[iterador+2] == ' ' || (int)cadenaA[iterador+2] <65)
                cadenaA[iterador] =  'a';

        }
    }
    cout<<cadenaA<<endl;

    return 0;
}
