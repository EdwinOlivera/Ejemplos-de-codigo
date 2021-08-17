import random


tablero = []

for x in range(0, 5):
    tablero.append(["o"] * 5)


def print_tablero(tablero):
    for row in tablero:
        print(" ".join(row))


jugador_1 = input("Primer Jugador : ")
jugador_2 = input("Segundo Jugador: ")
Jugadores = [jugador_1, jugador_2]


def seleccionarJugador(Jugadores):
    return random.choice(Jugadores)


def random_row(tablero):
    return random.randint(0, len(tablero)-1)


def random_col(tablero):
    return random.randint(0, len(tablero[0])-1)


if seleccionarJugador(Jugadores) == jugador_1:
    print(jugador_1, " iniciara el juego.")
else:
    print(jugador_2, " Iniciara el juego.")

fila_barco_1 = random_row(tablero)
columna_barco_1 = random_col(tablero)


fila_barco_2 = random_row(tablero)
columna_barco_2 = random_col(tablero)


print_tablero(tablero)

player_start = seleccionarJugador(Jugadores)


hit_count = 0
turno = 0
while hit_count < 2:
    turno + 1
    fila_seleccionada = int(
        input("Selecciona Fila: (Valores permitidos 0 - 4) "))
    columna_seleccionada = int(
        input("Selecciona Columna: (Valores permitidos 0 - 4) "))

    if (fila_seleccionada == fila_barco_1 and columna_seleccionada == columna_barco_1) or (fila_seleccionada == fila_barco_2 and columna_seleccionada == columna_barco_2):
        hit_count = hit_count + 1
        tablero[fila_seleccionada][columna_seleccionada] = "*"
        print("Felicidades ")
        if hit_count == 1:
            print("¡Has hundido el primer barco!")
        elif hit_count == 2:
            print("¡Has hundido el segundo barco! ¡Has ganado!")
            print_tablero(tablero)
            break
    else:
        if (fila_seleccionada < 0 or fila_seleccionada > 4) or (columna_seleccionada < 0 or columna_seleccionada > 4):
            print("Esa es una ubicación no permitida.")
        elif(tablero[fila_seleccionada][columna_seleccionada] == "X"):
            print("Ya le has pegado a este barco.")
        else:
            print("Has fallado el disparo!")
            tablero[fila_seleccionada][columna_seleccionada] = "X"
        print("Turno #", turno)
    print_tablero(tablero)

print("El Primer barco estaba escondido en:")
print(fila_barco_1)
print(columna_barco_1)

print("El Segundo barco estaba escondido en:")
print(fila_barco_2)
print(columna_barco_2)
