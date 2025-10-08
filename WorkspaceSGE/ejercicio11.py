numAlcanzar = int(input("Introduce un número el cual vamos a alcanzar: "))
listaNum = []
suma = 0

while suma!= numAlcanzar or suma<=numAlcanzar:
    numLeido = int(input("Introduce un entero: "))
    listaNum.append(numLeido)
    suma+=numLeido
    
    if suma>numAlcanzar:
        print("Te pasaste.")
    elif suma == numAlcanzar:

        print("Lo conseguiste")
        print("Los números introducidos son: ", listaNum)