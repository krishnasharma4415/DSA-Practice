import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Spiral_Matrix 
{
    List<Integer> spiralOrder(int[][] matrix) 
    {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) 
        {
            for (int i = left; i <= right; i++) 
                result.add(matrix[top][i]);
            top++;

            for (int i = top; i <= bottom; i++) 
                result.add(matrix[i][right]);
            right--;

            if (top <= bottom) 
            {
                for (int i = right; i >= left; i--) 
                    result.add(matrix[bottom][i]);
                bottom--;
            }

            if (left <= right) 
            {
                for (int i = bottom; i >= top; i--) 
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
                matrix[i][j] = sc.nextInt();
        }

        Spiral_Matrix sm = new Spiral_Matrix();
        List<Integer> result = sm.spiralOrder(matrix);
        
        System.out.println("Spiral Order: " + result);
        sc.close();
    }    
}
