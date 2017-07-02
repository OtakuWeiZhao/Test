#Learn C Pointer

```
#include <stdio.h>
#include <string.h>

int main()
{
	char	string[15]	= "AragakiYuiGakki";
	char	c	= string[0];
	char	*pointer;

	pointer = &string[0];
	printf( "指向pointer的值是%p\n", pointer );

  int i;
	for ( i = 0; i < strlen( string ); i++ )
	{
		printf( "第%d个字符是:%c\n", i + 1, *(pointer + i) );
	}
	return(0);
}
```
  
![打印结果:](https://github.com/OtakuWeiZhao/LearnCplus/blob/master/learnPointer/picture/lcp1.PNG)
