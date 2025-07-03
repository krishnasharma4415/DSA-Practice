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

public class Middle_of_LL 
{
    public Node middleNode(Node head) 
    {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
