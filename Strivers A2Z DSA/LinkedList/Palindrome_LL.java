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

public class Palindrome_LL 
{
    public boolean isPalindrome(Node head) 
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        Node next = null;
        while(current != null) 
        {
            next = current.next; 
            current.next = prev; 
            prev = current;      
            current = next;       
        }

        Node left = head;
        Node right = prev;
        while(right != null) 
        {
            if(left.data != right.data) 
            {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }    
}
