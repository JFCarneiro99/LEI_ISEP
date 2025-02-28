import numpy as np

################################################################
### método maior() #############################################
def maior(num):
    maiorValor = max(num)
    return maiorValor
################################################################
### dá assign num número entre 1-5 (qnt de números) ############
qntNumeros = np.random.randint(1,6)
################################################################
### cria uma lista com qntNumeros de 1 a 10 ####################
numeros = [np.random.randint(1,11) for i in range(qntNumeros)]
print(numeros)
################################################################
### print ######################################################
maiorNumInserido = maior(numeros)
print(f'O maior número inserido é {maiorNumInserido}')