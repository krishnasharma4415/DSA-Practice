import java.util.Scanner;

public class Sort_array_of_012 
{
    void sort(int nums[])
    {
        int count0 = 0, count1 = 0, count2 = 0;
        
        for(int num : nums)
        {
            if(num == 0) count0++;
            else if(num == 1) count1++;
            else count2++;
        }
        
        int index = 0;
        
        for(int i = 0; i < count0; i++)
            nums[index++] = 0;
            
        for(int i = 0; i < count1; i++)
            nums[index++] = 1;
            
        for(int i = 0; i < count2; i++)
            nums[index++] = 2;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int nums[] = new int[n];
        System.out.println("Enter the elements of the array (0s, 1s, and 2s only):");
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        Sort_array_of_012 sorter = new Sort_array_of_012();
        sorter.sort(nums);

        System.out.println("Sorted array:");
        for(int num : nums)
            System.out.print(num + " ");
        
        sc.close();
    }
}   
