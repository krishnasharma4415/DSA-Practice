import java.util.Scanner;

public class Two_Sum
{
    public int[] twoSum(int nums[], int target)
    {
        int sum[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    sum[0] = i;
                    sum[1] = j;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int nums[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        
        Two_Sum ts = new Two_Sum();
        int result[] = ts.twoSum(nums, target);
        
        if(result[0] != 0 || result[1] != 0) 
            System.out.println("Indices of the two numbers that add up to the target: " + result[0] + ", " + result[1]);
        else
            System.out.println("No two numbers add up to the target.");

        sc.close();
    }
}