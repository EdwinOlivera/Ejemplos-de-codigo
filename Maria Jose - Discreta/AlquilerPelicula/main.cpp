#include <iostream>

using namespace std;

// Estructuras Creadas ***************************************************
struct cliente
{
    string nombre;
    string *peliculAlaquilada;
    string *peliculaDevuelta;
    int CantidadAlquiladas = 0;

};

struct Pelicula
{
    string NombreDePelicula;
    string *ClienteApuntado;
    bool disponible = true;
};
// Estructuras Creadas ***************************************************


// Variables Creadas ***************************************************
int cantidadDeClientes = 10;
int cantidadDePelicula = 10;

string PeliculaABuscar;
string ClienteABuscar;

bool PeliculaEncontrada = false;
bool ClienteEncontrado = false;

int CantidadARegistrar = 1;

int opcion;          // La opcion del menu que elija el usuario

// Variables Creadas ***************************************************



int main()
{

    Cliente *Clientes = new cliente[100];
    Pelicula *Peliculas = new Pelicula[100];

    //Ingreso de Datos
    Clientes[0].nombre = "Edwin";
    Clientes[1].nombre = "Roberto";
    Clientes[2].nombre = "Mario";
    Clientes[3].nombre = "Miriam";
    Clientes[4].nombre = "Josue";
    Clientes[5].nombre = "Alan";
    Clientes[6].nombre = "Karen";
    Clientes[7].nombre = "Marlen";
    Clientes[8].nombre = "Isabela";
    Clientes[9].nombre = "Susan";

    Peliculas[0].NombreDePelicula = "Titanic";
    Peliculas[0].disponible = true;
    Peliculas[1].NombreDePelicula = "Avatar";
    Peliculas[1].disponible = true;
    Peliculas[2].NombreDePelicula = "Thor";
    Peliculas[2].disponible = true;
    Peliculas[3].NombreDePelicula = "Aquaman";
    Peliculas[3].disponible = true;
    Peliculas[4].NombreDePelicula = "Ironman";
    Peliculas[4].disponible = true;
    Peliculas[5].NombreDePelicula = "Up";
    Peliculas[5].disponible = true;
    Peliculas[6].NombreDePelicula = "Minions";
    Peliculas[6].disponible = true;
    Peliculas[7].NombreDePelicula = "Frozen";
    Peliculas[7].disponible = true;
    Peliculas[8].NombreDePelicula = "Cats";
    Peliculas[8].disponible = true;
    Peliculas[9].NombreDePelicula = "Zonic";
    Peliculas[9].disponible = true;

    cout<<"A continuacion se muestran las peliculas registradas"<<endl;

    for(int i =0; i< cantidadDePelicula; i++)
    {
        cout<<i+1 <<" - "<<Peliculas[i].NombreDePelicula<<endl;

    }
    cout<<endl;
    cout<<"A continuacion se muestra Los clientes Abonados"<<endl;
    for(int i = 0; i< cantidadDeClientes; i++)
    {
        cout<< i+1 << " - "<<Clientes[i].nombre<<endl;
    }
    do
    {
        PeliculaEncontrada = false;
        ClienteEncontrado = false;//Con esto aseguramos que se reinicien las variables y comprueben si existen o no los datos solicitados
        cout << endl;
        cout << "Escoja una opcion:" << endl;
        cout << "1.- Registrar Cliente" << endl;
        cout << "2.- Registrar Pelicula" << endl;
        cout << "3.- Alquilar Pelicula" << endl;
        cout << "4.- Retorno de Pelicula" << endl;
        cout << "5.- Salir" << endl;
        cin>>opcion;

        switch(opcion)
        {
        case 1://Para Registrar un cliente nuevo

            cout<<"Cuantos clientes quiere Registrar?"<<endl;
            cin>>CantidadARegistrar;
            for(int i=0; i< CantidadARegistrar; i++)
            {
                if(cantidadDeClientes<100)
                {
                    do
                    {
                        cout<<"Ingrese el nombre del cliente"<<endl;
                        cin >> Clientes[cantidadDeClientes].nombre;

                        for(int j = 0; j< cantidadDeClientes; j++)
                        {
                            if(Clientes[cantidadDeClientes].nombre == Clientes[j].nombre)
                            {
                                cout<<"El cliente ya esta registrado, ingrese otro"<<endl;
                                Clientes[cantidadDeClientes].nombre ="Repetido";
                            }
                        }
                    }
                    while(Clientes[cantidadDeClientes].nombre =="Repetido");
                    cantidadDeClientes++;
                }
            }
            break;
        case 2://Resgistrar Pelicula
            cout<<"Cuantas peliculas quiere Registrar?"<<endl;
            cin>>CantidadARegistrar;
            for(int i = 0; i< CantidadARegistrar; i++)
            {

                if(cantidadDePelicula<100)
                {
                    cout<<"Ingrese el nombre de la Pelicula"<<endl;
                    cin >> Peliculas[cantidadDePelicula].NombreDePelicula;

                    for(int j = 0; j< cantidadDePelicula; j++)
                    {
                        if(Peliculas[cantidadDePelicula].NombreDePelicula == Peliculas[j].NombreDePelicula)
                        {
                            cout<<"Ese titulo de la pelicual ya esta repetido y registrado. Ingrese otro titulo"<<endl;
                            Peliculas[cantidadDePelicula].NombreDePelicula ="Repetido";
                        }
                    }
                }
                while(Peliculas[cantidadDePelicula].NombreDePelicula =="Repetido");
                Peliculas[cantidadDePelicula].disponible = true;
                cantidadDePelicula++;
            }

            break;
        case 3://Para Alquilar Pelicula


                cout<<"Ingrese el nombre de la pelicula que desea Alquilar"<<endl;
                cin>>PeliculaABuscar;

                for(int i=0; i < cantidadDePelicula; i++)
                {
                    if( PeliculaABuscar == Peliculas[i].NombreDePelicula)
                    {
                        PeliculaEncontrada = true;

                        if(Peliculas[i].disponible == false){
                            cout<<"La pelicula no esta disponible. Intente con otra."<<endl;
                        }else{
                        do
                        {
                            cout<<"Asignar cliente"<<endl;
                            cin>>ClienteABuscar;
                            for(int j=0; j< cantidadDeClientes; j++)
                            {
                                if(ClienteABuscar == Clientes[j].nombre)
                                {

                                    ClienteEncontrado = true;
                                    Peliculas[i].disponible = false;//Con esto de designa que la Pelicula no se encuentra disponible mas adelante.

                                    //operaciones de Asignaciones de Apuntadores
                                    Clientes[j].CantidadAlquiladas++; //Aumentar la cantidad de Peliculas alquiladas para este cliente
                                    Clientes[j].peliculAlaquilada = &Peliculas[i].NombreDePelicula; //Asigna el apuntador del Cliente a la Pelicula Designada
                                    Peliculas[i].ClienteApuntado = &Clientes[j].nombre; // Asigna el apuntador de la Pelicula al cliente Designado

                                    cout<<"El cliente "<<ClienteABuscar<<" a alquilado la pelicula "<< PeliculaABuscar<<endl;

                                }
                            }
                            if(ClienteEncontrado == false)// Esto se ejecuta siempre que no se encuentre el cliente a Buscar
                            {
                                cout<<"No se encontro el cliente con ese nombre. Intente con otro"<<endl;
                                ClienteABuscar = "No encontrado";
                            }

                        }
                        while(ClienteABuscar == "No encontrado");


                    }

                }
                }
                if(!PeliculaEncontrada)// en caso de que la pelicula no se encuentre registrada previamente
                {
                    cout<<"La pelicula Solicitada no esta resgistrada"<<endl;
                    if(cantidadDePelicula<100)
                    {
                        cout<<"Registre el nombre de la pelicula"<<endl;
                        cin >> Peliculas[cantidadDePelicula].NombreDePelicula;
                        Peliculas[cantidadDePelicula].disponible = true;
                        cantidadDePelicula++;
                    }
                }

            break;
        case 4://Para Retornar una pelicula
                cout<<"Ingrese el nombre de la pelicula que se Retorna"<<endl;
                cin>>PeliculaABuscar;

                for(int i=0; i < cantidadDePelicula; i++)
                {
                    if( PeliculaABuscar == Peliculas[i].NombreDePelicula)
                    {
                        PeliculaEncontrada = true;

                        if(Peliculas[i].disponible == true){
                            cout<<"La pelicula no ha sido alquilada."<<endl;
                        }else{
                        do
                        {

                            ClienteABuscar = *Peliculas[i].ClienteApuntado;
                            cout<<"Esta pelicula fue alquilada por : "<<ClienteABuscar<<endl;

                            for(int j=0; j< cantidadDeClientes; j++)
                            {
                                if(ClienteABuscar == Clientes[j].nombre)
                                {

                                    ClienteEncontrado = true;
                                    Peliculas[i].disponible = true;//Con esto se designa que la Pelicula ya esta disponible.

                                    //operaciones de Asignaciones de Apuntadores
                                    Clientes[j].CantidadAlquiladas--; //Aumentar la cantidad de Peliculas alquiladas para este cliente
                                    Clientes[j].peliculAlaquilada = NULL; // Se desvincula el puntero
                                    Peliculas[i].ClienteApuntado = NULL; // Se desvincula el puntero

                                    cout<<"El cliente "<<ClienteABuscar<<" a Retornado la pelicula "<< PeliculaABuscar<<endl;

                                }
                            }
                            if(ClienteEncontrado == false)// Esto se ejecuta siempre que no se encuentre el cliente a Buscar
                            {
                                cout<<"No se encontro el cliente con ese nombre. Intente con otro"<<endl;
                                ClienteABuscar = "No encontrado";
                            }

                        }
                        while(ClienteABuscar == "No encontrado");
                    }

                }
                }
                if(!PeliculaEncontrada)// en caso de que la pelicula no se encuentre registrada previamente
                {
                    cout<<"La pelicula que se retorna no esta registrada"<<endl;
                }

            break;
        case 5: // Se sale de la ejecucion del programa
            cout << "Fin del programa" << endl;
            break;

        default: // Para caulquier dijito no valido
            cout << "Opcion desconocida" << endl;
            break;
        }
    }
    while(opcion !=5);

    return 0;
}
