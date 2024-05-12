#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
} *head;

void linkedListTraversal(struct Node *ptr)
{
    while (ptr != NULL)
    {
        printf("Element: %d\n", ptr->data);
        ptr = ptr->next;
    }
}

struct Node *createNode(int data)
{
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    ptr->data = data;
    ptr->next = NULL;
    return ptr;
}

// Case 1
struct Node *insertAtFirst(struct Node *head, int data)
{
    struct Node *ptr = createNode(data);
    ptr->next = head;
    return ptr;
}

// Case 2
struct Node *insertAtIndex(struct Node *head, int data, int index)
{
    struct Node *ptr = createNode(data);
    struct Node *p = head;
    int i = 0;

    while (i != index - 1)
    {
        p = p->next;
        i++;
    }
    ptr->next = p->next;
    p->next = ptr;
    return head;
}

// Case 3
struct Node *insertAtEnd(struct Node *head, int data)
{
    struct Node *ptr = createNode(data);
    struct Node *p = head;

    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = ptr;
    return head;
}

// Case 1: Deleting the first element from the linked list
struct Node *deleteFirst(struct Node *head)
{
    if (head == NULL)
    {
        printf("List is empty. Cannot delete.\n");
        return NULL;
    }

    struct Node *ptr = head;
    head = head->next;
    free(ptr);
    return head;
}

// Case 2: Deleting the element at a given index from the linked list
struct Node *deleteAtIndex(struct Node *head, int index)
{
    if (head == NULL)
    {
        printf("List is empty. Cannot delete.\n");
        return NULL;
    }

    struct Node *p = head;
    struct Node *q = head->next;

    for (int i = 0; i < index - 1; i++)
    {
        if (q == NULL)
        {
            printf("Index out of bounds. Cannot delete.\n");
            return head;
        }
        p = p->next;
        q = q->next;
    }

    p->next = q->next;
    free(q);
    return head;
}

// Case 3: Deleting the last element
struct Node *deleteAtLast(struct Node *head)
{
    if (head == NULL)
    {
        printf("List is empty. Cannot delete.\n");
        return NULL;
    }

    struct Node *p = head;
    struct Node *q = head->next;

    if (q == NULL)
    {
        free(p);
        return NULL;
    }

    while (q->next != NULL)
    {
        p = p->next;
        q = q->next;
    }

    p->next = NULL;
    free(q);
    return head;
}

int main()
{
    // Example usage of the linked list operations

    // Creating a linked list with elements 1, 2, and 3
    head = createNode(1);
    head->next = createNode(2);
    head->next->next = createNode(3);

    printf("Original Linked List:\n");
    linkedListTraversal(head);

    // Inserting 0 at the beginning
    head = insertAtFirst(head, 0);
    printf("\nLinked List after inserting 0 at the beginning:\n");
    linkedListTraversal(head);

    // Inserting 4 at index 3
    head = insertAtIndex(head, 4, 3);
    printf("\nLinked List after inserting 4 at index 3:\n");
    linkedListTraversal(head);

    // Inserting 5 at the end
    head = insertAtEnd(head, 5);
    printf("\nLinked List after inserting 5 at the end:\n");
    linkedListTraversal(head);

    // Deleting the first element
    head = deleteFirst(head);
    printf("\nLinked List after deleting the first element:\n");
    linkedListTraversal(head);

    // Deleting element at index 2
    head = deleteAtIndex(head, 2);
    printf("\nLinked List after deleting element at index 2:\n");
    linkedListTraversal(head);

    // Deleting the last element
    head = deleteAtLast(head);
    printf("\nLinked List after deleting the last element:\n");
    linkedListTraversal(head);

    return 0;
}
