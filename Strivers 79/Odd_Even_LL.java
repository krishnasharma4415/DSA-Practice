/*
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
*/

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

public class Odd_Even_LL
{
    public Node oddEvenList(Node head) 
    {
        Node odd = head;        
        Node even = head.next;  
        Node evenHead = even;   
        
        while (even != null && even.next != null) 
        {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}