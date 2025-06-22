import java.util.Scanner;

public class Maximum_Consecutive_Ones 
{
    int find(int arr[])
    {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == 1) 
                currentCount++;
            else 
            {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements (0s and 1s only):");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        Maximum_Consecutive_Ones obj = new Maximum_Consecutive_Ones();
        int result = obj.find(arr);
        System.out.println("Maximum consecutive ones: " + result);
        
        sc.close();
    }
}
