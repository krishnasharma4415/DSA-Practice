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

public class Queue_using_LinkedList 
{
    Node front;
    Node rear;
    int size;

    Queue_using_LinkedList()
    {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    void enqueue(int val)
    {
        Node ptr = new Node(val);
        if(front == null)
        {
            front = ptr;
            rear = ptr;
        }
        else
        {
            rear.next = ptr;
            rear = ptr;
            size++;
        }
    }    

    int dequeue()
    {
        if(front == null)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        int x = front.data;
        front = front.next;
        return x;
    }
}
