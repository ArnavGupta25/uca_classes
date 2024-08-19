#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "list.h"

#define MAX_SIZE 100

int array[MAX_SIZE];   
int next[MAX_SIZE];   
int head = -1;       
int freeIndex = 0;     
int N = 0;            

void initialize_list() {
    for (int i = 0; i < MAX_SIZE - 1; i++) {
        next[i] = i + 1;
    }
    next[MAX_SIZE - 1] = -1;
}

void push(int value) {
    if (freeIndex == -1) {
        printf("List is full\n");
        return;
    }

    int newNodeIndex = freeIndex;
    freeIndex = next[freeIndex];
    
    array[newNodeIndex] = value;
    next[newNodeIndex] = -1;

    if (head == -1) {
        head = newNodeIndex;
    } else {
        int current = head;
        while (next[current] != -1) {
            current = next[current];
        }
        next[current] = newNodeIndex;
    }

    N++;
}

void pop(int index) {
    if (index < 0 || index >= N || head == -1) {
        printf("Invalid index\n");
        return;
    }

    int current = head;
    if (index == 0) {
        head = next[head];
        next[current] = freeIndex;
        freeIndex = current;
    } else {
        for (int i = 0; i < index - 1; i++) {
            current = next[current];
        }
        int nodeToDelete = next[current];
        next[current] = next[nodeToDelete];
        next[nodeToDelete] = freeIndex;
        freeIndex = nodeToDelete;
    }

    N--;
}

void insert(int index, int value) {
    if (index < 0 || index > N) {
        printf("Invalid index\n");
        return;
    }

    if (freeIndex == -1) {
        printf("List is full\n");
        return;
    }

    int newNodeIndex = freeIndex;
    freeIndex = next[freeIndex];

    array[newNodeIndex] = value;

    if (index == 0) {
        next[newNodeIndex] = head;
        head = newNodeIndex;
    } else {
        int current = head;
        for (int i = 0; i < index - 1; i++) {
            current = next[current];
        }
        next[newNodeIndex] = next[current];
        next[current] = newNodeIndex;
    }

    N++;
}

int get(int index) {
    if (index < 0 || index >= N) {
        return INT_MIN;
    }

    int current = head;
    for (int i = 0; i < index; i++) {
        current = next[current];
    }

    return array[current];
}

int size() {
    return N;
}

void display() {
    int current = head;
    while (current != -1) {
        printf("%d ", array[current]);
        current = next[current];
    }
    printf("\n");
}

void testList() {
    assert(size() == 0);

    assert(get(0) == INT_MIN);

    push(3);
    push(9);
    push(1);

    assert(size() == 3);

    assert(get(0) == 3);
    assert(get(1) == 9);
    assert(get(2) == 1);

    pop(1);

    assert(size() == 2);
    assert(get(0) == 3);
    assert(get(1) == 1);

    insert(1, 4);

    assert(size() == 3);
    assert(get(1) == 4);

    printf("All Test Cases Passed!\n");
}

int main() {
    initialize_list();
    testList();
    return 0;
}
