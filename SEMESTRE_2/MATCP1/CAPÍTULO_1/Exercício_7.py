n = int(input("Introduza a dimensão n da matriz: "))

valores = []

print(f"Introduza os {n*n} valores da matriz:")

for i in range(n):
    linha = []
    for j in range(n):
        valor = int(input(f"Valor para a posição [{i+1}, {j+1}]: "))
        linha.append(valor)
    valores.append(linha)

import numpy as np

matriz = np.array(valores)

print("Matriz:")
for linha in matriz:
    print(" ".join(f"{valor:4d}" for valor in linha))

soma_pares = np.sum(matriz[matriz % 2 == 0])
print(f"Soma dos valores pares da matriz: {soma_pares}")

if n >= 3:
    soma_terceira_coluna = np.sum(matriz[:, 2])
    print(f"Soma dos valores da terceira coluna: {soma_terceira_coluna}")
else:
    print("A matriz não tem terceira coluna.")

if n >= 2:
    menor_segunda_linha = np.min(matriz[1, :])
    print(f"Menor valor da segunda linha: {menor_segunda_linha}")
else:
    print("A matriz não tem segunda linha.")