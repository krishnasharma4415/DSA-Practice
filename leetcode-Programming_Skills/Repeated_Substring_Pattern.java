import java.util.Scanner;

public class Repeated_Substring_Pattern 
{
    boolean check(String s) 
    {
        int n = s.length();
        if (n < 2)
            return false;

        for (int i = 1; i <= n / 2; i++) 
        {
            if (n % i == 0) 
            {
                boolean isPattern = true;
                for (int j = i; j < n; j++) 
                {
                    if (s.charAt(j) != s.charAt(j % i)) 
                    {
                        isPattern = false;
                        break;
                    }
                }
                if (isPattern)
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Repeated_Substring_Pattern obj = new Repeated_Substring_Pattern();
        boolean result = obj.check(str);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
