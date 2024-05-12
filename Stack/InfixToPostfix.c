#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Define a stack structure to hold operators
#define MAX_SIZE 100

struct Stack
{
    char items[MAX_SIZE];
    int top;
};

// Initialize the stack
void initialize(struct Stack *stack)
{
    stack->top = -1;
}

// Check if the stack is empty
bool isEmpty(struct Stack *stack)
{
    return stack->top == -1;
}

// Check if the character is an operator
bool isOperator(char c)
{
    return (c == '+' || c == '-' || c == '*' || c == '/');
}

// Get the precedence of an operator
int getPrecedence(char c)
{
    if (c == '+' || c == '-')
        return 1;
    else if (c == '*' || c == '/')
        return 2;
    else
        return 0; // If not an operator
}

// Push an item onto the stack
void push(struct Stack *stack, char item)
{
    if (stack->top >= MAX_SIZE - 1)
    {
        printf("Stack overflow\n");
        exit(1);
    }
    stack->items[++stack->top] = item;
}

// Pop an item from the stack
char pop(struct Stack *stack)
{
    if (isEmpty(stack))
    {
        printf("Stack underflow\n");
        exit(1);
    }
    return stack->items[stack->top--];
}

// Convert infix expression to postfix
void infixToPostfix(char infix[], char postfix[])
{
    struct Stack stack;
    initialize(&stack);
    int i, j;
    i = j = 0;

    while (infix[i] != '\0')
    {
        char token = infix[i];
        if (token >= '0' && token <= '9')
        {
            postfix[j++] = token; // Append operand to the postfix expression
        }
        else if (token == '(')
        {
            push(&stack, token);
        }
        else if (token == ')')
        {
            while (!isEmpty(&stack) && stack.items[stack.top] != '(')
            {
                postfix[j++] = pop(&stack); // Pop operators until '(' is encountered
            }
            if (!isEmpty(&stack) && stack.items[stack.top] == '(')
            {
                pop(&stack); // Pop '('
            }
            else
            {
                printf("Invalid expression: Mismatched parentheses\n");
                exit(1);
            }
        }
        else if (isOperator(token))
        {
            while (!isEmpty(&stack) && getPrecedence(token) <= getPrecedence(stack.items[stack.top]))
            {
                postfix[j++] = pop(&stack); // Pop operators with higher or equal precedence
            }
            push(&stack, token); // Push the current operator onto the stack
        }
        else
        {
            printf("Invalid character in expression: %c\n", token);
            exit(1);
        }
        i++;
    }

    // Pop any remaining operators from the stack
    while (!isEmpty(&stack))
    {
        if (stack.items[stack.top] == '(' || stack.items[stack.top] == ')')
        {
            printf("Invalid expression: Mismatched parentheses\n");
            exit(1);
        }
        postfix[j++] = pop(&stack);
    }

    postfix[j] = '\0'; // Null-terminate the postfix expression
}

int main()
{
    char infix[MAX_SIZE];
    char postfix[MAX_SIZE];

    printf("Enter an infix expression: ");
    scanf("%99s", infix);

    infixToPostfix(infix, postfix);

    printf("Postfix expression: %s\n", postfix);

    return 0;
}
