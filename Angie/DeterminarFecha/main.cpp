// Copyright 2020 LesterV
#include <iostream>
#include <string.h>

// Prototipo de funciones
void MostrarFecha (int *);

int main()
{
// ************* Delarar cadenas y variables*****************
    char cFecha[11];
    char tmpCadena[5];
    bool fechaCorrecta = true;
    int fecha[3];
    int *apFecha;

    apFecha = &fecha[0];

// Solicitar al usuario ingresar una fecha e formato 'dd-mm-aaaa'
    std::cout << "Introduce la Fecha (dd-mm-aaaa): " << std::endl;
    std::cin.getline(cFecha,11);



    tmpCadena[0] = cFecha[6];
    tmpCadena[1] = cFecha[7];
    tmpCadena[2] = cFecha[8];
    tmpCadena[3] = cFecha[9];

    if(atoi(tmpCadena)>0)
    {
        fecha[2]=atoi(tmpCadena);
//Con esto se vacia quitan los datos anteriores
        tmpCadena[2] = '.';
        tmpCadena[3]= '.';
//Se hace la comprobacion de si se es un año bisiestos
        if((atoi(tmpCadena) % 4 == 0 && atoi(tmpCadena)% 100 != 0 )|| atoi(tmpCadena)% 400 == 0 )
        {
//Aqui es para los años bisiestos
            //Determinare el mes
            tmpCadena[0] = cFecha[3];
            tmpCadena[1] = cFecha[4];
            if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=13)
            {
                fechaCorrecta = false;
                std::cout<<"La fecha no es adecuada. Se ha ingresado un mes equivocado"<<std::endl;
            }
            else
            {
                fecha[1]=atoi(tmpCadena);//aqui se guarda el mes
                if(atoi(tmpCadena)==2)
                {
                    //esto es en caso del mes de Febrero

                    //Determinar el dia
                    tmpCadena[0] = cFecha[0];
                    tmpCadena[1] = cFecha[1];
                    if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=30)
                    {
                        std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en el mes de febrero."<<std::endl;
                    }
                    else
                    {
                        fechaCorrecta = false;
                        fecha[0]=atoi(tmpCadena);//Aqui se guarda el dia
                    }

                }
                else
                {
                    //Seleccionamos los meses que tengan 31 dias
                    if(atoi(tmpCadena)==1 || atoi(tmpCadena)==3 || atoi(tmpCadena)==5 || atoi(tmpCadena)==7 || atoi(tmpCadena)==8 ||atoi(tmpCadena)==10 || atoi(tmpCadena)==12  )
                    {
                        //Determinar el dia
                        tmpCadena[0] = cFecha[0];
                        tmpCadena[1] = cFecha[1];
                        if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=32)
                        {
                            fechaCorrecta = false;
                            std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en un mes con maximo de 31 dias"<<std::endl;
                        }
                        else
                        {
                            fecha[0]=atoi(tmpCadena);
                        }


                    }
                    else
                    {
                        //Aca es para todos los meses que no tienen 31 dias exceptuando Febrero
                        //Determinar el dia
                        tmpCadena[0] = cFecha[0];
                        tmpCadena[1] = cFecha[1];
                        if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=31)
                        {
                            fechaCorrecta = false;
                            std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en un mes con maximo 30 dias"<<std::endl;
                        }
                        else
                        {
                            fecha[0]=atoi(tmpCadena);

                        }

                    }

                }
            }


        }
        else
        {
//Aqui es para los años NO bisiestos
            //Determinare el mes
            tmpCadena[0] = cFecha[3];
            tmpCadena[1] = cFecha[4];
            if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=13)
            {
                fechaCorrecta = false;
                std::cout<<"La fecha no es adecuada. Se ha ingresado un mes equivocado"<<std::endl;
            }
            else
            {
                fecha[1]=atoi(tmpCadena);//aqui se guarda el mes
                if(atoi(tmpCadena)==2)
                {
                    //esto es en caso del mes de Febrero

                    //Determinar el dia
                    tmpCadena[0] = cFecha[0];
                    tmpCadena[1] = cFecha[1];
                    if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=29)
                    {
                        fechaCorrecta = false;
                        std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en el mes de febrero."<<std::endl;
                    }
                    else
                    {
                        fecha[0]=atoi(tmpCadena);//Aqui se guarda el dia
                    }

                }
                else
                {
                    //Seleccionamos los meses que tengan 31 dias
                    if(atoi(tmpCadena)==1|| atoi(tmpCadena)==3|| atoi(tmpCadena)==5|| atoi(tmpCadena)==7||atoi(tmpCadena)==8||atoi(tmpCadena)==10||atoi(tmpCadena)==12 )
                    {
                        //Determinar el dia
                        tmpCadena[0] = cFecha[0];
                        tmpCadena[1] = cFecha[1];
                        if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=32)
                        {
                            fechaCorrecta = false;
                            std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en un mes con maximo de 31 dias"<<std::endl;
                        }
                        else
                        {
                            fecha[0]=atoi(tmpCadena);
                        }


                    }
                    else
                    {
                        //Aca es para todos los meses que no tienen 31 dias exceptuando Febrero
                        //Determinar el dia
                        tmpCadena[0] = cFecha[0];
                        tmpCadena[1] = cFecha[1];
                        if(atoi(tmpCadena)<=0 || atoi(tmpCadena)>=31)
                        {
                            fechaCorrecta = false;
                            std::cout<<"La fecha no es adecuada. Se ingreso un dia incorrecto en un mes con maximo 30 dias"<<std::endl;
                        }
                        else
                        {
                            fecha[0]=atoi(tmpCadena);
                            MostrarFecha(apFecha);
                        }

                    }

                }
            }


        }

    }
    else
    {
        fechaCorrecta = false;
    }
    if(fechaCorrecta)
    {
        MostrarFecha(apFecha);
    }
    else
    {
        std::cout<<"No se determino  La fecha exacta"<<std::endl;

    }

    return 0;
}


// Aquí se define la función 'MostrarFecha()'
void MostrarFecha (int *fecha)
{

    int anio= fecha[2], mes =fecha[1], dia=fecha[0];


    switch(mes)
    {
    case 01:
        std::cout<<dia<<" de enero"<<" del "<<anio;
        break;

    case 02:
        std::cout<<dia<<" de febrero"<<" del "<<anio;
        break;
    case 03:
        std::cout<<dia<<" de marzo"<<" del "<<anio;
        break;
    case 04:
        std::cout<<dia<<" de abril"<<" del "<<anio;
        break;
    case 05:
        std::cout<<dia<<" de mayo"<<" del "<<anio;
        break;
    case 06:
        std::cout<<dia<<" de junio"<<" del "<<anio;
        break;
    case 07:
        std::cout<<dia<<" de julio"<<" del "<<anio;
        break;
    case 07+01:
        std::cout<<dia<<" de agosto"<<" del "<<anio;
        break;
    case 07+02:
        std::cout<<dia<<" de septiembre"<<" del "<<anio;
        break;
    case 10:
        std::cout<<dia<<" de octubre"<<" del "<<anio;
        break;
    case 11:
        std::cout<<dia<<" de noviembre"<<" del "<<anio;
        break;
    case 12:
        std::cout<<dia<<" de diciembre"<<" del "<<anio;
        break;
    default:
        std::cout<<"No se determino  La fecha exacta"<<std::endl;

    }


}
