import java.util.Scanner;

public class Find_missing_numbers 
{   
    void find(int arr[], int n)
    {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) 
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        for( int i = min; i <= max; i++) 
        {
            boolean found = false;
            for (int j = 0; j < n; j++) 
            {
                if (arr[j] == i) 
                {
                    found = true;
                    break;
                }
            }
            if (!found) 
            {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sc.close();
    }
}   
