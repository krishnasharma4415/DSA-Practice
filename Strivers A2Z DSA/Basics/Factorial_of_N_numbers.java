import java.util.Scanner;

public class Factorial_of_N_numbers 
{
    int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        Factorial_of_N_numbers obj = new Factorial_of_N_numbers();
        int result = obj.factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}