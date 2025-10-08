numLeido=int(input("Introduzca un entero"))

for i in range(1, numLeido+1):
    print("*"*i)
for i in range(numLeido-1, 0, -1):
    print("*"*i)