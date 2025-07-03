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

public class Reverse_LL 
{
    public Node reverseList(Node head) 
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) 
        {
            next = current.next; 
            current.next = prev; 
            prev = current;      
            current = next;       
        }
        return prev;
    }
}
