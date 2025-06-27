import java.util.Arrays;
import java.util.Scanner;

public class Find_Repeat_and_Missing_Number 
{
    int[] find(int arr[])
    {
        int[] result = new int[2];

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length - 1];

        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i] == arr[i+1])
            {
                result[0] = arr[i];
                break;
            }
        }

        for(int i=min;i<max;i++)
        {
            boolean found = false;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]==i)
                {
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                result[1] = i;
                break;
            }
        }
        return result;
    }    

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        
        Find_Repeat_and_Missing_Number obj = new Find_Repeat_and_Missing_Number();
        int[] result = obj.find(arr);
        
        System.out.println("Repeated Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
        
        sc.close();
    }
}
