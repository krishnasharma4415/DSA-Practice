import java.util.Scanner;

public class Longest_subarray_with_sum_K 
{
    int start=-1, end=-1;
    int find(int arr[], int k)
    {
        int n = arr.length;
        int length = 0;
        int sum;

        for(int i=0;i<n;i++)
        {
            sum = 0;
            for(int j=i;j<n;j++)
            {
                sum += arr[j];
                if(sum == k)
                {
                    if(length < j - i + 1)
                    {
                        length = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return length;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the sum K:");
        int k = sc.nextInt();

        Longest_subarray_with_sum_K obj = new Longest_subarray_with_sum_K();
        int length = obj.find(arr, k);
        
        if(length > 0)
        {           
            System.out.println("Longest subarray with sum " + k + " is from index " + obj.start + " to " + obj.end);
            System.out.println("Subarray: ");
            for(int i = obj.start; i <= obj.end; i++)
                System.out.print(arr[i] + " ");
        }
        else
            System.out.println("No subarray found with sum " + k);

        sc.close();
    }    
}
