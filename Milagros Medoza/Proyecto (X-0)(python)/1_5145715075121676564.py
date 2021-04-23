# VALERIA CABRERA 20181000868

cuadrado = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

def main():
    player = 1
    estado = -1

    while estado == -1:
        tablero()

        if player % 2 == 1:
            player = 1
        else:
            player = 2
        print('\nPlayer', player)
        eleccion  = int(input('Ingrese un número:'))

        if player == 1:
            marque = 'X'
        else:
            marque = 'O'

        if eleccion == 1 and cuadrado[1] == 1:
           cuadrado[1] = marque
        elif eleccion == 2 and cuadrado[2] == 2:
            cuadrado[2] = marque
        elif eleccion == 3 and cuadrado[3] == 3:
            cuadrado[3] = marque
        elif eleccion == 4 and cuadrado[4] == 4:
            cuadrado[4] = marque
        elif eleccion == 5 and  cuadrado[5] == 5:
          cuadrado[5] = marque
        elif eleccion == 6 and cuadrado[6] == 6:
           cuadrado[6] = marque
        elif eleccion == 7 and cuadrado[7] == 7:
            cuadrado[7] = marque
        elif eleccion == 8 and cuadrado[8] == 8:
            cuadrado[8] = marque
        elif eleccion == 9 and cuadrado[9] == 9:
            cuadrado[9] = marque
        else:
            print('movimiento inválido ')
            player -= 1

        estado = estado_juego()
        player += 1

    print('RESULTADO')
    if estado == 1:
        print('Player', player - 1, 'GANA')
    else:
        print('Sorteo del juego')


###############################################
#    función para regresar el estado del juego
#    1 El juego ha terminado con un resultado
#    -1 El juego esta en curso
#    O El juego terminó y no hay resultado
###############################################

def estado_juego():
    if cuadrado[1] != 1 and cuadrado[2] != 2 and cuadrado[3] != 3 and cuadrado[4] != 4 and cuadrado[5] != 5 and cuadrado[
        6] != 6 and cuadrado[7] != 7 and cuadrado[8] != 8:
        if cuadrado[9] != 9:
            return 1
        elif cuadrado[4] ==cuadrado[5] and cuadrado[5] == cuadrado[6]:
            return 1
        elif cuadrado[7] == cuadrado[8] and cuadrado[8] == cuadrado[9]:
            return 1
        elif cuadrado[1] == cuadrado[4] and cuadrado[4] == cuadrado[7]:
            return 1
        elif cuadrado[2] == cuadrado[5] and cuadrado[5] == cuadrado[8]:
            return 1
        elif cuadrado[3] == cuadrado[6] and cuadrado[6] == cuadrado[9]:
            return 1
        elif cuadrado[1] == cuadrado[5] and cuadrado[5] == cuadrado[9]:
            return 1
        elif cuadrado[3] == cuadrado[5] and cuadrado[5] == cuadrado[7]:
            return 1
        elif cuadrado[1] != 1 and cuadrado[2] != 2 and cuadrado[3] != 3 and cuadrado[4] != 4 and cuadrado[5] != 5 and cuadrado[
            6] != 6 and cuadrado[7] != 7 and cuadrado[8] != 8 and cuadrado[9] != 9:
            return 0
        else:
            return -1
    elif cuadrado[4] ==cuadrado[5] and cuadrado[5] == cuadrado[6]:
        return 1
    elif cuadrado[7] == cuadrado[8] and cuadrado[8] == cuadrado[9]:
        return 1
    elif cuadrado[1] == cuadrado[4] and cuadrado[4] == cuadrado[7]:
        return 1
    elif cuadrado[2] == cuadrado[5] and cuadrado[5] == cuadrado[8]:
        return 1
    elif cuadrado[3] == cuadrado[6] and cuadrado[6] == cuadrado[9]:
        return 1
    elif cuadrado[1] == cuadrado[5] and cuadrado[5] == cuadrado[9]:
        return 1
    elif cuadrado[3] == cuadrado[5] and cuadrado[5] == cuadrado[7]:
        return 1
    elif cuadrado[1] != 1 and cuadrado[2] != 2 and cuadrado[3] != 3 and cuadrado[4] != 4 and cuadrado[5] != 5 and cuadrado[
        6] != 6 and cuadrado[7] != 7 and cuadrado[8] != 8 and cuadrado[9] != 9:
        return 0
    else:
        return -1


########################################################
#    Función  para dibujar el tablero                  #
#    de TIC TAC TOE con las marcas de los jugadores    #
########################################################


def tablero():
    print('\n\n\tTic Tac Toe\n\n')

    print('Player 1 (X)  -  Player 2 (O)')
    print()

    print('     |     |     ')
    print(' ', cuadrado[1], ' | ', cuadrado[2], ' |  ', cuadrado[3])

    print('_____|_____|_____')
    print('     |     |     ')

    print(' ', cuadrado[4], ' | ', cuadrado[5], ' |  ', cuadrado[6])

    print('_____|_____|_____')
    print('     |     |     ')

    print(' ', cuadrado[7], ' | ', cuadrado[8], ' |  ', cuadrado[9])

    print('     |     |     ')


main()
