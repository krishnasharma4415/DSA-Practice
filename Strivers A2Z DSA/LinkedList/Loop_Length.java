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

public class Loop_Length 
{
    public int findLength(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                int length = 1;
                Node current = slow;

                while(current.next != slow) 
                {
                    current = current.next;
                    length++;
                }
                return length; 
            }
        }
        return 0;
    }
}
