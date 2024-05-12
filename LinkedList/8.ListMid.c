
#include <stdio.h>
#include <stdlib.h>

struct Node {
    int val;
    struct Node* next;
};

struct Node* Create(int val) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->val = val;
    node->next = NULL;
    return node;
}

struct Node* FindMid(struct Node* head) {
    struct Node* slowPtr = head;
    struct Node* fastPtr = head;

    while (fastPtr != NULL && fastPtr->next != NULL) {
        slowPtr = slowPtr->next;
        fastPtr = fastPtr->next->next;
    }

    return slowPtr;
}

int main() 
{
    struct Node* head = Create(1);
    head->next = Create(2);
    head->next->next = Create(3);
    head->next->next->next = Create(4);
    head->next->next->next->next = Create(5);

    struct Node* middleNode = FindMid(head);
    printf("Middle Node: %d\n", middleNode->val);

    return 0;
}
