import java.util.Scanner;

public class Merge_Sorted_Array 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int len=m+n;
        int merged[] = new int[len];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n)
        {
            if (nums1[i] <= nums2[j]) 
                merged[k++] = nums1[i++];
            else 
                merged[k++] = nums2[j++];
        }
        while (i < m) 
        {
            merged[k++] = nums1[i++];
        }
        while (j < n) 
        {
            merged[k++] = nums2[j++];
        }
        for (int l = 0; l < len; l++) 
            nums1[l] = merged[l];
    }    

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of first array:");
        int m = sc.nextInt();
        System.out.println("Enter size of second array:");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < m; i++)
            nums1[i] = sc.nextInt();

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n; i++)
            nums2[i] = sc.nextInt();

        Merge_Sorted_Array msa = new Merge_Sorted_Array();
        msa.merge(nums1, m, nums2, n);

        System.out.println("Merged array:");
        for (int i = 0; i < m + n; i++)
            System.out.print(nums1[i] + " ");

        sc.close();
    }
}
