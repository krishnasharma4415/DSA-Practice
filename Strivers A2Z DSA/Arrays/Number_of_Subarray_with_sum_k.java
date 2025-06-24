import java.util.Scanner;

public class Number_of_Subarray_with_sum_k 
{
    int count(int nums[], int k)
    {
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) 
        {
            sum = 0;
            for (int j = i; j < nums.length; j++) 
            {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
            nums[i] = sc.nextInt();
        
        System.out.println("Enter the sum k:");
        int k = sc.nextInt();
        
        Number_of_Subarray_with_sum_k obj = new Number_of_Subarray_with_sum_k();
        int result = obj.count(nums, k);
        
        System.out.println("Number of subarrays with sum " + k + " is: " + result);
        
        sc.close();
    }
}
