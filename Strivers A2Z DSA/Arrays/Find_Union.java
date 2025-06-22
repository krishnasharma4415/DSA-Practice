import java.util.Scanner;

public class Find_Union 
{
    int[] find(int a[], int b[])
    {
        int n = a.length;
        int m = b.length;
        int[] union = new int[n + m];
        int k = 0;

        for (int i = 0; i < n; i++)
            union[k++] = a[i];

        for (int j = 0; j < m; j++) 
        {
            boolean found = false;
            for (int i = 0; i < n; i++) 
            {
                if (b[j] == a[i]) 
                {
                    found = true;
                    break;
                }
            }
            if (!found)
                union[k++] = b[j];
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = union[i];
        
        return result;
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Enter the size of second array:");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        Find_Union fu = new Find_Union();
        int[] unionResult = fu.find(a, b);

        System.out.println("Union of the two arrays:");
        for (int num : unionResult)
            System.out.print(num + " ");

        sc.close();
    }
}
