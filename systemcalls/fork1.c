#include<stdio.h>
#include<unistd.h>
int main(){
   if(fork()&&(!fork())){
	if(fork()||fork()){
            fork();
        };
    };
    printf("2 ");
    return 0;
}
