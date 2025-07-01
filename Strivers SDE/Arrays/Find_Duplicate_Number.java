import java.util.Scanner;

public class Find_Duplicate_Number 
{
    public int find(int[] nums) 
    {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] == nums[j])
                {
                    return nums[i];
                }
            }
        }
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
        {
            nums[i] = sc.nextInt();
        }
        
        Find_Duplicate_Number finder = new Find_Duplicate_Number();
        int duplicate = finder.find(nums);
        
        if(duplicate != -1) 
        {
            System.out.println("Duplicate number found: " + duplicate);
        } 
        else 
        {
            System.out.println("No duplicate number found.");
        }
        
        sc.close();
    }
}
