import java.util.Scanner;

public class Reverse_an_array 
{
    public static void reverse(int[] arr, int start, int end) 
    {
        if (start >= end)
            return;
        
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        
        reverse(arr, start + 1, end - 1);
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        
        System.out.print("Original array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        reverse(arr, 0, arr.length - 1);
        
        System.out.print("Reversed array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
