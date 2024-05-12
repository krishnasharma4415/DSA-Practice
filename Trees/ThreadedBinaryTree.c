#include <stdio.h>
#include <stdlib.h>

// Structure for a threaded binary tree node
struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
    int leftThread;
    int rightThread;
};

// Function to create a new node
struct Node *createNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL)
    {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->leftThread = 0;
    newNode->rightThread = 0;
    return newNode;
}

// Function to find the leftmost node in the tree
struct Node *leftMost(struct Node *node)
{
    while (node != NULL && node->leftThread == 0)
        node = node->left;
    return node;
}

// Function to perform in-order traversal of threaded binary tree
void inOrderTraversal(struct Node *root)
{
    struct Node *current = leftMost(root);

    while (current != NULL)
    {
        // Process current node
        printf("%d ", current->data);

        // Move to the in-order successor
        if (current->rightThread)
            current = current->right;
        else
            current = leftMost(current->right);
    }
}

// Function to insert a node into the threaded binary tree
struct Node *insert(struct Node *root, int data)
{
    struct Node *newNode = createNode(data);

    if (root == NULL)
    {
        // If the tree is empty, make the new node the root
        root = newNode;
    }
    else
    {
        // Find the position to insert the new node
        struct Node *current = root;
        struct Node *parent = NULL;

        while (current != NULL)
        {
            parent = current;

            // Move to the left child
            if (data < current->data)
            {
                if (current->leftThread == 0)
                    current = current->left;
                else
                    break;
            }
            else if (data > current->data)
            {
                // Move to the right child
                if (current->rightThread == 0)
                    current = current->right;
                else
                    break;
            }
            else
            {
                // Duplicate data, ignore
                free(newNode);
                return root;
            }
        }

        // Insert the new node
        if (data < parent->data)
        {
            newNode->left = parent->left;
            newNode->right = parent;
            parent->leftThread = 1;
            parent->left = newNode;
        }
        else
        {
            newNode->left = parent;
            newNode->right = parent->right;
            parent->rightThread = 1;
            parent->right = newNode;
        }
    }

    return root;
}

// Example usage
int main()
{
    struct Node *root = NULL;

    // Insert some nodes into the threaded binary tree
    root = insert(root, 50);
    root = insert(root, 30);
    root = insert(root, 70);
    root = insert(root, 20);
    root = insert(root, 40);
    root = insert(root, 60);
    root = insert(root, 80);

    // Perform in-order traversal
    printf("In-order traversal: ");
    inOrderTraversal(root);
    printf("\n");

    return 0;
}
