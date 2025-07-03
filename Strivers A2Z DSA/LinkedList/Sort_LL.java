import java.util.Arrays;

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

public class Sort_LL 
{
    public Node sortList(Node head) 
    {
        if (head == null) 
            return null;
        
        Node ptr = head;
        int n = 0;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }

        int[] arr = new int[n];
        Node current = head;
        for (int i = 0; i < n; i++) 
        {
            arr[i] = current.data;
            current = current.next;
        }

        Arrays.sort(arr);

        Node result = new Node(arr[0]);
        Node temp = result;
        for (int i = 1; i < n; i++) 
        {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        
        return result;   
    }    
}
