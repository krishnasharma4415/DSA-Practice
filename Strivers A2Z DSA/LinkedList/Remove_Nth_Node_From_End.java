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

public class Remove_Nth_Node_From_End
{
    public Node removeNthFromEnd(Node head, int n) 
    {
        Node ptr = head;
        int len = 0;
        while (ptr != null) 
        {  
            len++;
            ptr = ptr.next;
        }
        
        if (len == n)
            return head.next;
        
        Node temp = head;
        for (int i = 0; i < len - n - 1; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        
        return head;
    }
}