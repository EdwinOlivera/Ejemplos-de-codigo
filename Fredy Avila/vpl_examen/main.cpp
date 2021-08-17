
#include <iostream>

#include <string.h>

using namespace std;

void noEntiendo(char *s) {

      char *t = s;

     while (*t)  t++;

     t--;

    while(s < t) {

        char Temp = *s;

       *s++ = *t;

       *t-- = Temp;

    }



}

int main() {

     char s[50]; char s1[50], s2[50];

     char sNueva[50];

     char *m = s;

    int i;

    cout << "Escriba una frase: " << endl;

    cin.getline(s,49);

    int n = strlen(s);

    strncpy(s1, s, n/2);

    s1[n/2] = '\0';

    for(i =0; i< n/2; i++)

                *m++;

    for(i=0; i<n/2;i++)

                s2[i] = *(m+i);

    s2[i] = '\0';

    noEntiendo(s1);

    noEntiendo(s2);

    strcat(s1, s2);

    strcpy(sNueva, s1);

    cout << sNueva;

    return 0;

}
