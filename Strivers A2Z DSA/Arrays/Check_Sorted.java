import java.util.Scanner;

public class Check_Sorted 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        boolean isSorted = true;
        for(int i = 0; i < n - 1; i++)
        {
            if(arr[i] > arr[i + 1])
            {
                isSorted = false;
                break;
            }
        }
        if(isSorted)
            System.out.println("The array is sorted in non-decreasing order.");
        else
            System.out.println("The array is not sorted in non-decreasing order.");
        
        sc.close();
    }
}
