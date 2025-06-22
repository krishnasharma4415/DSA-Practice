import java.util.Scanner;

public class Linear_Search 
{
    public static int linearSearch(int[] arr, int target) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        
        System.out.print("Enter the element to search for: ");
        int target = sc.nextInt();
        int result = linearSearch(arr, target);
        
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else 
            System.out.println("Element not found in the array.");

        sc.close();
    }    
}
