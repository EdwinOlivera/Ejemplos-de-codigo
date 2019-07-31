#include <iostream>
#include <cstdlib>

using namespace std;
int CrearPromedio(int, int,int, float);
int main ()
{
    cout<<"presione 0 para  promediar  "<<endl;
    cout<<" "<<endl;
    int i=1,c=0, promedio=0;
    float s=0;

    cout<<"promedio   "<<CrearPromedio(i,c,promedio,s)<<endl;
    return 0;
}
int CrearPromedio(int i, int c, int promedio, float s)
{
    while(i!=0)
    {
        cout<<"numero  "<<endl;
        cin>>i;
        s=s+i;
        if( i!=0)
        {
            c=c+1;
        }
    }
    promedio = s/c;
    return promedio;
}
