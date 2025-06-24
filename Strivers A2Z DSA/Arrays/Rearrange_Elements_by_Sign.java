import java.util.Scanner;

public class Rearrange_Elements_by_Sign 
{
    public int[] rearrange(int nums[])
    {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) 
        {
            if (nums[i] >= 0) 
            {
                result[posIndex] = nums[i];
                posIndex += 2;
            } 
            else 
            {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        
        return result;        
    }    

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) 
            nums[i] = scanner.nextInt();

        Rearrange_Elements_by_Sign rearranger = new Rearrange_Elements_by_Sign();
        int[] result = rearranger.rearrange(nums);

        System.out.println("Rearranged array:");
        for (int num : result) 
        {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
}
