import java.util.Scanner;

public class Majority_Element 
{
    int majorityElement(int nums[])
    {
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) 
        {
            if(nums[i] == candidate)
                count++;
            else 
            {
                count--;
                if(count == 0) 
                {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        
        count = 0;
        for(int num : nums) 
        {
            if(num == candidate)
                count++;
        }
        
        return count > nums.length / 2 ? candidate : -1;
    }   
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        Majority_Element me = new Majority_Element();
        int result = me.majorityElement(nums);
        
        if(result != 0)
            System.out.println("The majority element is: " + result);
        else
            System.out.println("No majority element found.");
        
        sc.close();
    }
}
