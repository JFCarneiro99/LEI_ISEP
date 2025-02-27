lista = []
for c in range(5):
    n = int(input('Insira um valor: '))
    if c == 0 or n > lista[len(lista)-1]:
        lista.append(n)
    else:
        pos = 0
        while pos < len(lista):
            if n <= lista[pos]:
                lista.insert(pos, n)
                break
            pos += 1

print('-=' * 30)
print(f'Os valores da lista em ordem crescente são {lista}')