#include <stdio.h>

int main()
{
	int number;
	
	printf("Enter an integer: ");
	scanf("%d", &number);

	printf("You entered: %d\n", number);

	printf("The base adress of variable is: %p\n", (void*)&number);

	return 0;
}
