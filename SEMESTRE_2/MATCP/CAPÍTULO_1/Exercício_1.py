valorDoEmprestimo = int(input('Escreva o valor do Empréstimo: '))
salarioDoComprador = int(input('Escreva o valor do salário do comprador: '))
duracaoDoEmprestimoEmAnos = int(input('Indique a duração do Empréstimo: '))

duracaoDoEmprestimoEmMeses = (duracaoDoEmprestimoEmAnos * 12)

valorAPagarMensalmente = valorDoEmprestimo / duracaoDoEmprestimoEmMeses

if valorAPagarMensalmente > salarioDoComprador * 0.30:
    print(f'Empréstimo Reprovado')
else:
    print(f'Empréstimo Aprovado')
    print(f'A prestação mensal vai ser de {valorAPagarMensalmente:.1f} euros, durante {duracaoDoEmprestimoEmAnos} anos.')