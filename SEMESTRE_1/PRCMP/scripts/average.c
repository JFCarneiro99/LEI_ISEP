#include <stdio.h>

int average(int v1, int v2);

int average(int v1, int v2) {
	return (v1 + v2) / 2;
}

int main() {
	int a, b, avg;
	
	printf("Insira o primeiro número: ");
	scanf("%d", &a);
	printf("Insira o segundo número: ");
	scanf("%d", &b);
	
	avg = average(a, b);
	
	printf("A média dos números %d e %d é: %d\n", a, b, avg);

	return 0;
}
