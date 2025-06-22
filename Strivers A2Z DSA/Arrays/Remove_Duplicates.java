import java.util.Scanner;

public class Remove_Duplicates 
{
    void removeDuplicates(int arr[], int n) 
    {
        int j = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            if (arr[i] != arr[i + 1]) 
            {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];

        for (int i = 0; i < j; i++) 
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();

        java.util.Arrays.sort(arr);
        System.out.println("Array after removing duplicates:");
        Remove_Duplicates obj = new Remove_Duplicates();
        obj.removeDuplicates(arr, n);
        
        sc.close();
    }
}
