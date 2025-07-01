import java.util.*;

public class Pascals_Triangle
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) 
        {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) 
            {
                if (j == 0 || j == i) 
                    row.add(1);
                else 
                {
                    List<Integer> previousRow = triangle.get(i - 1);
                    int sum = previousRow.get(j - 1) + previousRow.get(j);
                    row.add(sum);
                }
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();
        
        Pascals_Triangle pt = new Pascals_Triangle();
        List<List<Integer>> result = pt.generate(numRows);
        
        for (List<Integer> row : result) 
        {
            System.out.println(row);
        }
        
        scanner.close();
    }
}