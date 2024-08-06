#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

struct Node
{
  int item;
  struct Node* next;
};


typedef struct Node Node;
Node* head=NULL;
int N=0;

void push(int item)
{
  Node* oldHead = head;

  head = (Node*) malloc(sizeof(Node));
  head->item = item;
  head->next = oldHead;
  N++;
}

int pop()
{
  if(head == NULL) return INT_MIN;

  Node* temp = head;
  int item = head->item;
  head = head->next;
  N--;
  free(temp);


  return item;
}

int size()
{
  return N;
}

bool isEmpty()
{
  return head == NULL;
}

void testStack()
{
  push(3);
  push(10);
  push(19);

  assert(size() == 3);
  assert(isEmpty() == false);

  assert(pop() == 19);
  assert(size() == 2);
  assert(isEmpty() == false);

  assert(pop() == 10);
  assert(size() == 1);
  assert(isEmpty() == false);

  assert(pop() == 3);
  assert(size() == 0);
  assert(isEmpty());
}


int main()
{
  testStack();

  return 0;
}








