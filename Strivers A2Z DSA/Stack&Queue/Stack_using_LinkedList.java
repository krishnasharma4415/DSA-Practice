class Node 
{
    int data;
    Node next;

    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

public class Stack_using_LinkedList 
{
    Node top;
    int size;

    public Stack_using_LinkedList() 
    {
        this.top = null;
        this.size = 0;
    }
    
    int isEmpty() 
    {
        if(top == null) 
            return 1; 
        else 
            return 0;
    }
    int isFull() 
    {
        return 0;
    }

    void push(int data)
    {
        if(isFull() == 1)
        {
            System.out.println("Stack is full");
            return;
        }
        Node ptr = new Node(data);
        ptr.next = top;
        top = ptr;
    }
    int pop() 
    {
        if(isEmpty() == 1) 
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        int x = top.data;
        top = top.next;
        size--;
        return x;
    }

    int peek(int index) 
    {
        Node ptr = top;
        for(int i = 0; i < index; i++) 
        {
            ptr = ptr.next;
        }
        return ptr.data;
    }

    void display() 
    {
        Node ptr = top;
        while(ptr != null) 
        {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
