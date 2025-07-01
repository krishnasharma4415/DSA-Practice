import java.util.Scanner;

public class Search_2D_Matrix
{
    public boolean search(int matrix[][], int target)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            
            if (midValue == target)
                return true;
            else if (midValue < target) 
                left = mid + 1; 
            else
                right = mid - 1;
        }
        
        return false;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int m, n, target;
        
        System.out.print("Enter number of rows: ");
        m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        n = scanner.nextInt();
        
        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter the target value to search: ");
        target = scanner.nextInt();
        
        Search_2D_Matrix search2DMatrix = new Search_2D_Matrix();
        boolean result = search2DMatrix.search(matrix, target);
        
        if (result) 
            System.out.println("Target found in the matrix.");
        else 
            System.out.println("Target not found in the matrix.");
        
        scanner.close();
    }
}