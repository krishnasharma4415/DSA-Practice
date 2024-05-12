#include <stdio.h>
char stack[30];
int top = -1;
void push(char x);
char pop();
int isEmpty();

int main()
{
    char input[] = "{}a+(b-c)";
    int i = 0;
    char c;
    while (input[i] != '\0')
    {
        if ((input[i]!='(' && input[i]!='[' && input[i]!='{') && (input[i]!=')' && input[i]!=']' && input[i]!='}'))
        {
            i++;
            continue;
        }
        else
        {
            if (input[i] == '(' || input[i] == '[' || input[i] == '{')
            {
                push(input[i]);
                i++;
            }
            else if (input[i] == ')' || input[i] == ']' || input[i] == '}')
            {
                if (isEmpty())
                {
                    printf("Unbalanced");
                    return 0;
                }

                c = pop();
                if ((c == '(' && input[i] != ')') || (c == '[' && input[i] != ']') || (c == '{' && input[i] != '}'))
                {
                    printf("Unbalanced");
                    return 0;
                }

                i++;
            }
        }
    }

    if (isEmpty() == 1)
    {
        printf("Balanced");
    }
    else
    {
        printf("Unbalanced");
    }

    return 0;
}

int isEmpty()
{
    if (top == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void push(char x)
{
    if (top == 29)
    {
        printf("Stack Overflow");
    }
    else
    {
        top++;
        stack[top] = x;
    }
}

char pop()
{
    char x;

    if (isEmpty())
    {
        printf("Stack Underflow");
        return '\0';
    }
    else
    {
        x = stack[top];
        top--;
        return x;
    }
}
