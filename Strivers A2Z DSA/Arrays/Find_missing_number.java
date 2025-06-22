import java.util.Scanner;

public class Find_missing_number 
{
    int find(int arr[], int n)
    {
        int total = (n * (n + 1)) / 2;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) 
            sum += arr[i];

        return total - sum;
    }    

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        System.out.println("Enter elements of the array (1 to " + n + ", missing one number):");
        for (int i = 0; i < n - 1; i++)
            arr[i] = sc.nextInt();

        Find_missing_number fmn = new Find_missing_number();
        int missingNumber = fmn.find(arr, n);

        System.out.println("The missing number is: " + missingNumber);

        sc.close();
    }
}
