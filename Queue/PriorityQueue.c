#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    int priority;
    struct node *next;
};

// Function to insert a new node with the given value and priority
struct node *insert(struct node *head, int val, int p)
{
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = val;
    newnode->priority = p;

    if (head == NULL || p < head->priority)
    {
        newnode->next = head;
        head = newnode;
    }
    else
    {
        struct node *ptr = head;
        while (ptr->next != NULL && ptr->next->priority <= p)
        {
            ptr = ptr->next;
        }
        newnode->next = ptr->next;
        ptr->next = newnode;
    }

    return head;
}

// Function to delete the node with the highest priority
struct node *delete(struct node *head)
{
    if (head == NULL)
    {
        printf("UNDERFLOW\n");
        return head;
    }
    else
    {
        struct node *ptr = head;
        int deleted_item = ptr->data;
        head = head->next;
        free(ptr);
        printf("Deleted item: %d\n", deleted_item);
    }
    return head;
}

// Function to display the elements in the priority queue
void display(struct node *head)
{
    struct node *current = head;
    printf("Priority Queue: ");
    while (current != NULL)
    {
        printf("(%d, %d) ", current->data, current->priority);
        current = current->next;
    }
    printf("\n");
}


int main()
{
    struct node *head = NULL;

    // Insert elements with priorities
    head = insert(head, 5, 2);
    head = insert(head, 10, 1);
    head = insert(head, 3, 3);

    // Display elements in the priority queue
    display(head);

    // Delete elements with the highest priority
    head = delete (head);
    head = delete (head);
    head = delete (head);

    return 0;
}
