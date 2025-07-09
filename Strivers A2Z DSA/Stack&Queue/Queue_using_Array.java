public class Queue_using_Array 
{
    int queue[];
    int front, rear;
    int size;

    public Queue_using_Array(int capacity)
    {
        size = capacity;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    boolean isFull()
    {
        if(rear == size-1)
            return true;
        else
            return false;
    }
    boolean isEmpty()
    {
        if(front == rear)
            return true;
        else
            return false;
    }

    void enqueue(int val)
    {
        if(isFull())
        {
            System.out.println("Queue is Full");
            return;
        }
        rear++;
        queue[rear] = val;
    }
    int dequeue()
    {
        if(isEmpty())
        {   
            System.out.println("Queue is Empty");
            return -1;
        }
        front++;
        int x = queue[front];
        return x;
    }
}
