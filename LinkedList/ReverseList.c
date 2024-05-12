#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node
{
    int data;
    struct Node *next;
};

// Function to insert a new node at the beginning of the linked list
void insertAtBeginning(struct Node **head, int newData)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = newData;
    newNode->next = *head;
    *head = newNode;
}

// Function to reverse the linked list
void reverseLinkedList(struct Node **head)
{
    struct Node *prev = NULL;
    struct Node *current = *head;
    struct Node *nextNode = NULL;

    while (current != NULL)
    {
        nextNode = current->next; // Save the next node
        current->next = prev;     // Reverse the link
        prev = current;           // Move prev to the current node
        current = nextNode;       // Move current to the next node
    }

    *head = prev; // Update the head to point to the new first node
}

// Function to print the linked list
void printLinkedList(struct Node *head)
{
    while (head != NULL)
    {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

// Main function to test the linked list reversal
int main()
{
    struct Node *head = NULL;

    // Insert some elements at the beginning
    insertAtBeginning(&head, 5);
    insertAtBeginning(&head, 4);
    insertAtBeginning(&head, 3);
    insertAtBeginning(&head, 2);
    insertAtBeginning(&head, 1);

    printf("Original Linked List: ");
    printLinkedList(head);

    // Reverse the linked list
    reverseLinkedList(&head);

    printf("Reversed Linked List: ");
    printLinkedList(head);

    return 0;
}
