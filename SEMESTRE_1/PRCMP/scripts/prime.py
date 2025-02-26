#!/usr/bin/python3

#Take input from the user
num = int(input('Enter a number: '))

if num == 1:
	print('By definition, 1 is not a prime number.')
elif num > 1:
	#check for factors
	for i in range(2, num):
		if (num % i) == 0:
			print(num, 'is not a prime number:')
			print('	->', i, 'times', num//i, 'is', num, '.')
			break
	else:
		print(num, 'is a prime number.')
else:
	print(num, 'is not a prime number:')
	print('	-> Prime numbers are greater than 1, by definition.')
