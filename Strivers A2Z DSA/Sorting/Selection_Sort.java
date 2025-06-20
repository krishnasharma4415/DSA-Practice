import java.util.Scanner;

public class Selection_Sort 
{
    public static void selectionSort(int arr[])
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            int minIndex = i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        selectionSort(arr);
        System.out.println("Sorted array:");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }    
}
