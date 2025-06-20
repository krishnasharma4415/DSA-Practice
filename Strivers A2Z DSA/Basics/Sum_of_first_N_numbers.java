import java.util.Scanner;

public class Sum_of_first_N_numbers 
{
    int sum(int n) 
    {
        if (n <= 0)
            return 0;
        return n + sum(n - 1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int n = sc.nextInt();
        Sum_of_first_N_numbers obj = new Sum_of_first_N_numbers();
        int result = obj.sum(n);
        System.out.println("The sum of the first " + n + " numbers is: " + result);
    }
}
