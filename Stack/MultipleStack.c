#include <stdio.h>
#include <malloc.h>
#define MAX 10

int stack[MAX], topA = -1, topB = MAX;

void push_stackA(int val)
{
    if (topA == topB - 1)
        printf("\n STACK OVERFLOW");
    else
    {
        topA += 1;
        stack[topA] = val;
    }
}
int pop_stackA()
{
    int val;
    if (topA == -1)
    {
        printf("\n STACK UNDERFLOW");
    }
    else
    {
        val = stack[topA];
        topA--;
    }
    return val;
}
void display_stackA()
{
    int i;
    if (topA == -1)
        printf("\n Empty STACK A");
    else
    {
        for (i = topA; i >= 0; i--)
            printf("\t %d", stack[i]);
    }
}
void push_stackB(int val)
{
    if (topB - 1 == topA)
        printf("\n STACK OVERFLOW");
    else
    {
        topB -= 1;
        stack[topB] = val;
    }
}
int pop_stackB()
{
    int val;
    if (topB == MAX)
    {
        printf("\n STACK UNDERFLOW");
    }
    else
    {
        val = stack[topB];
        topB++;
    }
}
void display_stackB()
{
    int i;
    if (topB == MAX)
        printf("\n Empty STACK B");
    else
    {
        for (i = topB; i < MAX; i++)
            printf("\t %d", stack[i]);
    }
}
int main()
{
    int option, val;
    do
    {
        printf("\n -----Menu----- ");
        printf("\n Enter 1 to PUSH a element into STACK A");
        printf("\n Enter 2 to PUSH a element into STACK B");
        printf("\n Enter 3 to POP a element from STACK A");
        printf("\n Enter 4 to POP a element from STACK B");
        printf("\n Enter 5 to display the STACK A");
        printf("\n Enter 6 to display the STACK B");
        printf("\n Press 7 to exit");
        printf("\n Enter your choice: ");
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            printf("\n Enter a value to PUSH on STACK A :");
            scanf("%d", &val);
            push_stackA(val);
            break;
        case 2:
            printf("\n Enter the value to PUSH on STACK B:");
            scanf("%d", &val);
            push_stackB(val);
            break;
        case 3:
            printf("\n The value POPPED from STACK A = %d", val);
            pop_stackA();
            break;
        case 4:
            printf("\n The value POPPED from STACK B = %d", val);
            pop_stackB();
            break;
        case 5:
            printf("\n The STACK A elements are :\n");
            display_stackA();
            break;
        case 6:
            printf("\n The STACK B elements are :\n");
            display_stackB();
            break;
        }
    } while (option != 7);
    return 0;
}