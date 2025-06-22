import java.util.Scanner;

public class Check_SortedAndRotated
{
    boolean isCheck_SortedAndRotated(int nums[])
    {
        int n = nums.length;
        
        int rotationPoint = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            if (nums[i] > nums[i + 1]) 
            {
                rotationPoint = i + 1;
                break;
            }
        }
        
        for (int i = rotationPoint; i < n - 1; i++) 
        {
            if (nums[i] > nums[i + 1]) 
                return false;
        }
        
        for (int i = 0; i < rotationPoint - 1; i++) 
        {
            if (nums[i] > nums[i + 1])
                return false;
        }
        
        if (rotationPoint > 0 && nums[n - 1] > nums[0])
            return false;
        
        return true;
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
        
        Check_SortedAndRotated check = new Check_SortedAndRotated();
        boolean result = check.isCheck_SortedAndRotated(nums);
        
        if (result)
            System.out.println("The array is sorted and rotated.");
        else
            System.out.println("The array is not sorted and rotated.");
        
        sc.close();
    }
}