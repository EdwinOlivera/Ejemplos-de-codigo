#include <iostream>

using namespace std;
class horas
{
public:
    int hora;
    int minuto;
    int segundo;
    horas();
    horas(int _segundo, int _minuto, int _hora);
    ~horas();
    void mostrarHora();
    horas sumarHoras(horas primerHora, horas segundaHora);

    int getHoras();
    int getMinutos();
    int getSegundos();

    void setHoras(int _hora);
    void setMinutos(int _minutos);
    void setSegundos(int _segundos);
};

horas::horas()
{
    hora = 0;
    minuto = 0;
    segundo = 0;
}

horas::horas(int _segundo, int _minuto, int _hora)
{
    hora = _hora;
    minuto = _minuto;
    segundo = _segundo;
}

int horas::getHoras()
{
    return hora;
}
int horas::getMinutos()
{
    return minuto;
}
int horas::getSegundos()
{
    return segundo;
}
void horas::setHoras(int _hora)
{
    hora = _hora;
}
void horas::setMinutos(int _minutos)
{
    minuto = _minutos;
}
void horas::setSegundos(int _segundos)
{
    segundo = _segundos;
}

void horas::mostrarHora()
{
    if (hora < 10)
    {
        if (minuto < 10)
        {
            if (segundo < 10)
            {
                cout << "0" << hora << ":0" << minuto << ":0" << segundo << endl;
            }
            else
            {
                cout << "0" << hora << ":0" << minuto << ":" << segundo << endl;
            }
        }
        else
        {
            if (segundo < 10)
            {
                cout << "0" << hora << ":" << minuto << ":0" << segundo << endl;
            }
            else
            {
                cout << "0" << hora << ":" << minuto << ":" << segundo << endl;
            }
        }
    }
    else
    {
        if (minuto < 10)
        {
            if (segundo < 10)
            {
                cout << hora << ":0" << minuto << ":0" << segundo << endl;
            }
            else
            {
                cout << hora << ":0" << minuto << ":" << segundo << endl;
            }
        }
        else
        {
            if (segundo < 10)
            {
                cout << hora << ":" << minuto << ":0" << segundo << endl;
            }
            else
            {
                cout << hora << ":" << minuto << ":" << segundo << endl;
            }
        }
    }
}

horas horas::sumarHoras(horas primerHora, horas segundaHora)
{
    int horaResultante, minutosResultante, segundosResultante;
    horaResultante = primerHora.getHoras() + segundaHora.getHoras();
    minutosResultante = primerHora.getMinutos() + segundaHora.getMinutos();
    segundosResultante = primerHora.getSegundos() + segundaHora.getSegundos();
    if (horaResultante > 24)
    {
        horaResultante -= 24;
    }

    if (minutosResultante > 60)
    {
        minutosResultante -= 60;
    }
    if (segundosResultante > 60)
    {
        segundosResultante -= 60;
    }
    horas objHoraNuevo(segundosResultante, minutosResultante, horaResultante); //segundos, minutos, hora
    return objHoraNuevo;
}
horas::~horas()
{
    //    cout << "----------------- Destruyendo objeto hora -----------------" << endl;
}
int main()
{
    int horaUNO, minutosUNO, segundosUNO;
    int horaDOS, minutosDOS, segundosDOS;
    cout << "Ingrese la primera hora" << endl;
    cin >> horaUNO;
    while (horaUNO > 12)
    {
        cin >> horaUNO;
    }

    cout << "Ingrese los primeros minutos " << endl;
    cin >> minutosUNO;
    while (minutosUNO > 60)
    {
        cin >> minutosUNO;
    }

    cout << "Ingrese los primeros segundos" << endl;
    cin >> segundosUNO;
    while (segundosUNO > 60)
    {
        cin >> segundosUNO;
    }

    cout << "\n<----------------------------->\n";

    cout << "Ingrese la hora de la segunda hora" << endl;
    cin >> horaDOS;
    while (horaDOS > 12)
    {
        cin >> horaDOS;
    }

    cout << "Ingrese los minutos de la segunda hora  " << endl;
    cin >> minutosDOS;
    while (minutosDOS > 60)
    {
        cin >> minutosDOS;
    }

    cout << "Ingrese los segundos de la segunda hora" << endl;
    cin >> segundosDOS;
    while (segundosDOS > 60)
    {
        cin >> segundosDOS;
    }

    horas objHoraUNO = horas(segundosUNO, minutosUNO, horaUNO); // segundos, minutos, horas
    horas objHoraDOS = horas(segundosDOS, minutosDOS, horaDOS);
    horas objHoraVacia;
    cout << "\n<----------------------------->\n";
    cout << "La primera hora ingresada es: " << endl;
    objHoraUNO.mostrarHora();
    cout << "La segunda hora ingresada es: " << endl;
    objHoraDOS.mostrarHora();
    cout << "\n<----------------------------->\n";

    objHoraVacia = objHoraUNO.sumarHoras(objHoraUNO, objHoraDOS);
    cout << "La sumatoria de horas es: " << endl;
    objHoraVacia.mostrarHora();

    return 0;
}
