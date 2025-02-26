#include <stdio.h>

int main() 
{
    printf("char: %lu bytes\n", sizeof(char));
    printf("short: %lu bytes\n", sizeof(short));
    printf("int: %lu bytes\n", sizeof(int));
    printf("long: %lu bytes\n", sizeof(long));
    printf("long long: %lu bytes\n", sizeof(long long));
    printf("float: %lu bytes\n", sizeof(float));
    printf("double: %lu bytes\n", sizeof(double));
    printf("long double: %lu bytes\n", sizeof(long double));
    return 0;
}
