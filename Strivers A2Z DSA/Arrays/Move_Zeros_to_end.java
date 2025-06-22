import java.util.Scanner;

public class Move_Zeros_to_end 
{
    void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void moveZerosToEnd(int[] arr) 
    {
        int n = arr.length;
        int j = 0; 

        for (int i = 0; i < n; i++) 
        {
            if (arr[i] != 0) 
            {
                swap(arr, i, j);
                j++;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }
        
        Move_Zeros_to_end obj = new Move_Zeros_to_end();
        obj.moveZerosToEnd(arr);
        
        System.out.println("Array after moving zeros to the end:");
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
        
        sc.close();
    }
}
