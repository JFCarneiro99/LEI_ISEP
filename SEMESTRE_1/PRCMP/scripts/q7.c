#include <stdio.h>
 
int main (){
int positivo = 15;
int negativo = -3;
 
char *pchar=(char *)&positivo;

printf("Variável positivo \n i: %d \n ii: %u \n %x \n", positivo, positivo, positivo);
printf("Variável negativo \n i: %d \n ii: %u \n %x \n", negativo, negativo, negativo);

printf("\nEndereços e conteúdos da variável 'positivo':\n");
for (size_t i=0; i < sizeof(positivo); i++){
printf(" Endereço: %p, Conteúdo:0x%02x\n", pchar, *pchar);
pchar++;
}
 
return 0;
 
}
