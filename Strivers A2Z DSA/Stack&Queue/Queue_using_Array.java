public class Queue_using_Array 
{
    int front, rear, size;
    int capacity;
    int array[];
    
    public Queue_using_Array(int capacity) 
    {
        this.capacity = capacity;
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
        this.array = new int[capacity];
    }
    
}
