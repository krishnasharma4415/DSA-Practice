import java.util.Scanner;

public class Second_Largest_Element 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int largest = arr[0];
        int second_largest = arr[0];
        for (int i = 1; i < n; i++) 
        {
            if(arr[i] > largest) 
            {
                second_largest = largest;
                largest = arr[i];
            } 
            else if(arr[i] > second_largest && arr[i] != largest)
                second_largest = arr[i];
        }
        System.out.println("The second largest element is: " + second_largest);
        sc.close();
    }
}
