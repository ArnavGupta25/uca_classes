#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "queue.h"

struct Node {
    int item;
    struct Node* next;
};

typedef struct Node Node;
Node* head = NULL;
Node* tail = NULL;
int N = 0;

void enqueue(int item) {
    Node* oldTail = tail;
    tail = (Node*) malloc(sizeof(Node));
    tail->item = item;
    tail->next = NULL;
    if (isEmpty()) {
        head = tail;
    } else {
        oldTail->next = tail;
    }
    N++;
}

int dequeue() {
    if (isEmpty()) return INT_MIN;

    int item = head->item;
    Node* oldHead = head;
    head = head->next;
    if (isEmpty()) tail = NULL;
    free(oldHead);
    N--;
    return item;
}

bool isEmpty() {
    return head == NULL;
}

int size() {
    return N;
}

void testQueue() {
    enqueue(3);
    enqueue(10);
    enqueue(19);

    assert(size() == 3);
    assert(isEmpty() == false);

    assert(dequeue() == 3);
    assert(size() == 2);
    assert(isEmpty() == false);

    assert(dequeue() == 10);
    assert(size() == 1);
    assert(isEmpty() == false);

    assert(dequeue() == 19);
    assert(size() == 0);
    assert(isEmpty());
}

int main() {
    testQueue();
    return 0;
}
