public class Stack_using_Array
{
    int stack[];
    int top;
    int capacity;

    Stack_using_Array(int size)
    {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    int isEmpty()
    {
        if(top == -1)
            return 1; 
        else
            return 0;
    }
    int isFull()
    {
        if(top == capacity - 1)
            return 1; 
        else
            return 0;
    }

    void push(int x)
    {
        if (isFull() == 1) 
        {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
    }
    int pop()
    {
        if(isEmpty() == 1) 
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek(int index)
    {
        if (index < 0 || index > top) 
        {
            System.out.println("Invalid Index");
            return -1;
        }
        return stack[index];
    }

    void display()
    {
        if (isEmpty() == 1) 
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) 
        {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}