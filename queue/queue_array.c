#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "queue.h"

int* array;
int N = 0;
int max_size = 1;
int front = 0;
int rear = 0;

void resize_array(int new_size) {
    int* new_array = (int*) malloc(new_size * sizeof(int));
    for (int i = 0; i < N; i++) {
        new_array[i] = array[(front + i) % max_size];
    }
    free(array);
    array = new_array;
    front = 0;
    rear = N;
    max_size = new_size;
}

void enqueue(int item) {
    if (N == 0) {
        resize_array(max_size);
    } else if (N == max_size) {
        resize_array(2 * max_size);
    }
    array[rear++] = item;
    rear %= max_size;
    N++;
}

int dequeue() {
    if (isEmpty()) return INT_MIN;
    int item = array[front++];
    front %= max_size;
    N--;
    if (size() > 0 && size() == max_size / 4) {
        resize_array(max_size / 2);
    }
    return item;
}

bool isEmpty() {
    return N == 0;
}

int size() {
    return N;
}

void testQueue() {
    enqueue(3);
    enqueue(5);
    enqueue(7);

    assert(size() == 3);
    assert(isEmpty() == false);

    assert(dequeue() == 3);
    assert(size() == 2);
    assert(isEmpty() == false);

    assert(dequeue() == 5);
    assert(size() == 1);
    assert(isEmpty() == false);

    assert(dequeue() == 7);
    assert(size() == 0);
    assert(isEmpty() == true);
}

int main() {
    testQueue();
    return 0;
}
