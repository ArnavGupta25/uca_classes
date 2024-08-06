#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

int* array;
int N = 0;
int max_size = 1;

void resize_array(int new_size)
{
  int * new_array = (int *) malloc(new_size * sizeof(int));

  for(int i = 0; i < N; i++)
    new_array[i] = array[i];
  
  int* temp=array;
  array = new_array;
  free(temp);
}


void push(int item)
{
  if(N ==0)
   {
     resize_array(max_size);
   }
  else if(N == max_size)
   {
     resize_array(2*max_size);
     max_size *= 2;
   }
  array[N++] = item;
}

int pop()
{
  if(isEmpty()) return INT_MIN;	
  int item = array[--N];
  if (size() > 0 && size() == max_size/4)
   {
     resize_array(N/2);
     max_size /= 2;
   } 

  return item;
}

bool isEmpty()
{
  return N == 0;
}

int size()
{
  return N;
}

void testStack()
{
  push(3);
  push(5);
  push(7);

  assert(size() == 3);
  assert(isEmpty() == false);
  
  assert(pop() == 7);
  assert(size() == 2);
  assert(isEmpty() == false);

  assert(pop() == 5);
  assert(size() == 1);
  assert(isEmpty() == false);

  assert(pop() == 3);
  assert(size() == 0);
  assert(isEmpty() == true);
}

int main()
{
  testStack();
  return 0;
}
