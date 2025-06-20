import java.util.Scanner;

public class Print_name_N_times
{
    void print(String name, int n)
    {
        if(n <= 0)
            return;
        System.out.println(name);
        print(name, n - 1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter the number of times to print your name: ");
        int n = sc.nextInt();
        Print_name_N_times obj = new Print_name_N_times();
        obj.print(name, n);
    }
}