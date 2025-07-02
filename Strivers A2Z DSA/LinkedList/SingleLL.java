import java.util.Scanner;

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

public class SingleLL 
{
    Node head;
    int size;

    SingleLL() 
    {
        this.head = null;
        this.size = 0;
    }

   void insertAtBeginning(int data)
   {
        Node temp = new Node(data);
        if (head == null)
        {
            head = temp;
        } 
        else 
        {
            temp.next = head;
            head = temp;
        }
        size++;
   }
   
   void insertAtIndex(int data, int index)
   {
        Node temp = new Node(data);
        Node current = head;

        for(int i = 0; i < index - 1 && current != null; i++) 
        {
            current = current.next;
        }
        temp.data = data;
        temp.next = current.next;
        current.next = temp;
        size++;
   }

   void insertAtEnd(int data)
   {
        Node temp = new Node(data);
        temp.data = data;

        Node current = head;
        while(current != null && current.next != null) 
        {
            current = current.next;
        }
        current.next = temp;
        temp.next = null;
        size++;
   }

   int deleteAtBeginning()
   {
        int data = head.data;
        head = head.next;
        size--;
        return data;
   }

    int deleteAtIndex(int index)
    {
        Node p = head;
        Node q = head.next;
        
        for(int i = 0; i < index - 1 && q != null; i++) 
        {
            p = p.next;
            q = q.next;
        }
        p.next = q.next;
        size--;
        return q.data;
    }

    int deleteAtEnd()
    {
        Node p = head;
        Node q = head.next;

        while(q.next != null) 
        {
            p = p.next;
            q = q.next;
        }
        p.next = null;
        size--;
        return q.data;
    }

    int deleteByValue(int data)
    {
        Node p = head;
        Node q = head.next;

        while(q.data != data && q != null)
        {
            p = p.next;
            q = q.next;
        }
        if(q.data == data)
        {
            p.next = q.next;
            size--;
            return q.data;
        } 
        return -1;
    }

    void traverse()
    {
        Node current = head;
        while(current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        SingleLL list = new SingleLL();
        int choice, data, index;

        do 
        {
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at Index");
            System.out.println("3. Insert at End");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at Index");
            System.out.println("6. Delete at End");
            System.out.println("7. Delete by Value");
            System.out.println("8. Traverse");
            System.out.println("9. Exit");
            choice = sc.nextInt();

            switch(choice) 
            {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter index: ");
                    index = sc.nextInt();
                    list.insertAtIndex(data, index);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 4:
                    System.out.println("Deleted: " + list.deleteAtBeginning());
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    index = sc.nextInt();
                    System.out.println("Deleted: " + list.deleteAtIndex(index));
                    break;
                case 6:
                    System.out.println("Deleted: " + list.deleteAtEnd());
                    break;
                case 7:
                    System.out.print("Enter value to delete: ");
                    data = sc.nextInt();
                    int deletedValue = list.deleteByValue(data);
                    if(deletedValue != -1)
                        System.out.println("Deleted: " + deletedValue);
                    else
                        System.out.println("Value not found.");
                    break;
                case 8:
                    list.traverse();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while(choice != 9);

        sc.close();
    }
}
