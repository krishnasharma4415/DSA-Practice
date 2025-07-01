import java.util.Scanner;

public class Pow_xn
{
    double myPow(double x, int n)
    {
        if(n==0)
            return 1.0;
        if(n < 0)
        {
            x = 1 / x;
            n = -n;
        }
        double result = 1.0;
        for(int i = 0; i < n; i++)
            result *= x;
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();
        
        Pow_xn powCalculator = new Pow_xn();
        double result = powCalculator.myPow(x, n);
        
        System.out.println("Result: " + result);
        sc.close();
    }
}