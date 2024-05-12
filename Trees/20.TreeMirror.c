#include <stdio.h>
#include <stdlib.h>

// Structure for a binary tree node
struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};

// Function to create a new node
struct Node *createNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to mirror a binary tree
void mirrorBinaryTree(struct Node *node)
{
    if (node == NULL)
    {
        return;
    }
    else
    {
        struct Node *temp;

        // Mirror the left and right subtrees
        mirrorBinaryTree(node->left);
        mirrorBinaryTree(node->right);

        // Swap the left and right pointers
        temp = node->left;
        node->left = node->right;
        node->right = temp;
    }
}

// Function to print the binary tree in in-order traversal
void printInOrder(struct Node *node)
{
    if (node == NULL)
    {
        return;
    }

    printInOrder(node->left);
    printf("%d ", node->data);
    printInOrder(node->right);
}

int main()
{
    // Create the binary tree
    struct Node *root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);

    printf("Original Binary Tree: ");
    printInOrder(root);
    printf("\n");

    // Mirror the binary tree
    mirrorBinaryTree(root);

    printf("Mirrored Binary Tree: ");
    printInOrder(root);
    printf("\n");

    return 0;
}
