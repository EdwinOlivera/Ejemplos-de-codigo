#include <iostream>

using namespace std;
void vendidoPorProducto(int mat[4][5]);
void vendidoPorVendedor(int mat[4][5]);
void vendidoPorProductoTOTAL(int mat[4][5]);
int main()
{
    int mat[4][5],  acumt=0, c, cod[15];
    cout<<"Introduzca datos de los productos: "<<endl;
    for(int i = 0; i<4; i++)
    {
        acumt = 0;
        cout<<"Vendedor #"<<i+1<<endl;
        do
        {
            for(int j = 0; j<5; j++)
            {
                cout<<"Producto #"<<j+1<<endl;
                cout<<"Ingrese el ID del producto"<<endl;
                cin>>cod[i];

                cout<<"Producto #"<<j+1<<endl;
                cout<<"Ingrese el monto total vendido del producto ID = "<<cod[i]<<endl;
                cin>>mat[i][j];
                acumt += mat[i][j];
                c++;
            }
            cout<<"El vendedor #"<<i+1<<"Vendio un total de "<<acumt<<endl;
            cout<<endl;
        }
        while(c<5);

    }
    vendidoPorProducto(mat);
    vendidoPorVendedor(mat);
    vendidoPorProductoTOTAL(mat);

    return 0;
}


void vendidoPorProducto(int mat[4][5])
{

    cout<<"Matriz que muestra cuanto se vendio de cada producto: "<<endl;
    for(int i = 0; i<4; i++)
    {
        cout<<endl;
        for(int j=0; j<5; j++)
        {
            cout<<" "<<mat[i][j];
        }
    }
}

void vendidoPorVendedor(int mat[4][5])
{
    cout<<endl<<"Matriz muestra total de cuanto vendieron los vendedores "<<endl;
    int vn[4];
    for(int i =0; i<4; i++)
    {
        vn[i]=0;
        for(int j = 0; j<5; j++)
        {
            vn[i] += mat[i][j];

        }
        cout<<"El vendedor #"<<i+1<<"Vendio: "<<vn[i]<<endl;
    }
}
void vendidoPorProductoTOTAL(int mat[4][5])
{

    cout<<endl<<"Matriz que muestra TOTAL de cuanto se vendio de cada Producto"<<endl;
    int vp[5];

    for(int i=0; i<5; i++)
    {
        vp[i]=0;
        for(int j=0; j<4; j++)
        {
            vp[i] = vp[i] + mat[j][i];
        }
        cout<<"Del Producto #"<<i+1<<" "<<" se vendio: "<<vp[i]<<" unidades"<<endl;
    }
}
