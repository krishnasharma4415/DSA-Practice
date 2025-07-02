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

public class Detect_Loop_in_LL 
{
    public boolean hasCycle(Node head) 
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) 
        {
            slow = slow.next; 
            fast = fast.next.next; 

            if (slow == fast) 
                return true;
        }
        return false;
    }
}
