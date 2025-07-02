import java.util.Scanner;

public class Rotate_Matrix_by_90_degrees 
{
    public static void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n / 2; j++) 
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }

        rotate(matrix);

        System.out.println("Rotated Matrix:");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}
