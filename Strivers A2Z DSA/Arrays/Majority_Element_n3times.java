import java.util.Scanner;

public class Majority_Element_n3times 
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
        for(int i=0; i < nums.length; i++) 
        {
            if(nums[i] == candidate)
                count++;
        }

        if(count> nums.length / 3)
            return candidate;
        else
            return -1;
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
        
        Majority_Element_n3times me = new Majority_Element_n3times();
        int result = me.majorityElement(nums);
        
        if(result != -1)
            System.out.println("The majority element is: " + result);
        else
            System.out.println("No majority element found.");
        
        sc.close();
    }
}
