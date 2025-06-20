import java.util.Scanner;

public class Print_all_Divisors 
{   
    void printDivisors(int n)
    {
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
                System.out.print(i + " ");
        }
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("Divisors of " + n + " are:");
        Print_all_Divisors obj = new Print_all_Divisors();
        obj.printDivisors(n);
    }    
}
