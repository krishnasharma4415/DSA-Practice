import java.util.Scanner;

public class Maximum_Subarray_Sum 
{
    public int maxSubarray(int[] nums) 
    {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
        {
            if(nums[i] > currentSum + nums[i])
                currentSum = nums[i];
            else
                currentSum += nums[i];
            
            if(currentSum > maxSum)
                maxSum = currentSum;
        }
        return maxSum;
    }    

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) 
            nums[i] = scanner.nextInt();
        
        Maximum_Subarray_Sum solution = new Maximum_Subarray_Sum();
        int result = solution.maxSubarray(nums);
        
        System.out.println("The maximum subarray sum is: " + result);
        scanner.close();
    }
}
