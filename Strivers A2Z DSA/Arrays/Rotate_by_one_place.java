import java.util.Scanner;

public class Rotate_by_one_place
{
    void rotate(int arr[], int n)
    {
        if(n<=1)
            return;
        
        int temp = arr[n-1];
        for(int i=n-1;i>1;i--)
            arr[i] = arr[i-1];
        arr[0] = temp;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        Rotate_by_one_place obj = new Rotate_by_one_place();
        obj.rotate(arr, n);
        
        System.out.println("Array after rotation:");
        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}