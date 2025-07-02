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

public class Detect_Cycle_Start 
{
    public Node detectCycle(Node head) 
    {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) 
            {
                Node start = head;
                while(start != slow) 
                {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
