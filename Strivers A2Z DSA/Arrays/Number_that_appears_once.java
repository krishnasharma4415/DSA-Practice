import java.util.Scanner;

public class Number_that_appears_once 
{
    public static int findUnique(int[] arr) 
    {
        int unique = 0;
        for (int num : arr) 
        {
            unique ^= num;
        }
        return unique;
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
        
        int result = findUnique(arr);
        System.out.println("The number that appears only once is: " + result);
        
        scanner.close();
    }
}
