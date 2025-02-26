#!/usr/bin/python3

# Program to transpose a matrix using a nested loop

A = [[12,7],
	[4 ,5],
	[3 ,8]]

At = [[0,0,0],
	[0,0,0]]

# Print matrix
print('A = ')
for r in A:
	print(r)

# Iterate through rows
for i in range (len(A)):
	# iterate through columns
	for j in range (len(A[0])):
		At[j][i] = A[i][j]

# Print transposed matrix
print('\nAt = ')
for r in At:
	print(r)
