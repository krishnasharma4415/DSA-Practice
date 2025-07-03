class Node
{
    int data;
    Node next;

    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
    Node()
    {
        this.data = 0;
        this.next = null;
    }
}

public class Merge_LL 
{
    public Node mergeTwoLists(Node list1, Node list2) 
    {
        Node merged = new Node();
        Node temp = merged;

        Node p = list1;
        Node q = list2;

        while(p!=null && q!=null)
        {
            if(p.data<q.data)
            {
                temp.next = new Node(p.data);
                p = p.next;
                temp = temp.next;
            }
            else
            {
                temp.next = new Node(q.data);
                q = q.next;
                temp = temp.next;
            }
        }

        while(p != null)
        {
            temp.next = new Node(p.data);
            p = p.next;
            temp = temp.next;
        }
        
        while(q != null)
        {
            temp.next = new Node(q.data);
            q = q.next;
            temp = temp.next;
        }
        
        return merged.next;
    }    
}
