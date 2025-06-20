import java.util.Scanner;

public class Check_for_Prime 
{
    public static void isPrime(int n) 
    {
        if (n <= 1) 
            System.out.println(n + " is not a prime number.");
        for(int i = 2; i <= Math.sqrt(n); i++) 
        {
            if (n % i == 0)
            { 
                System.out.println(n + " is not a prime number.");
                System.out.println("It is divisible by " + i);
                return;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it is prime: ");
        int number = scanner.nextInt();
        Check_for_Prime.isPrime(number);
    }
}