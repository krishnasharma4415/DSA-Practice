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

public class Delete_Middle_Node 
{
    public Node deleteMiddle(Node head) 
    {
        if (head.next == null)
            return null;

        Node slow = head;
        Node fast = head.next.next;

        while(fast != null && fast.next != null) 
        {
            slow = slow.next; 
            fast = fast.next.next; 
        }    
        slow.next = slow.next.next;
        return head;
    }    
}
