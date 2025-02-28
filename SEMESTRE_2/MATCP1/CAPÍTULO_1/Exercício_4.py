numero = int(input('Número'))
listaNumeros = list()
if numero < 0:
    print(f'O primeiro número inserido é menor que 0')
else:
    while numero >=0:
        if numero not in listaNumeros:
            listaNumeros.append(numero)
        numero = int(input('Número'))
    qntNumeros = len(listaNumeros)
    maiorNum = max(listaNumeros)
    menorNum = min(listaNumeros)
    indexMaiorNum = listaNumeros.index(maiorNum)
    indexMenorNum = listaNumeros.index(menorNum)
    print(f'O maior número da lista é {maiorNum} e o menor é {menorNum}. As posições são respetivamente {indexMaiorNum} e {indexMenorNum}')