import java.util.Scanner;

public class Longest_Common_Prefix 
{
    public static String longestCommonPrefix(String strs[])
    {
        int n = strs.length;
        if (n == 0) return "";
        if (n == 1) return strs[0];

        String prefix = "";
        for(int i=0;i<strs[0].length();i++)
        {
            char ch = strs[0].charAt(i);
            for(int j=1;j<n;j++)
            {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) 
                {
                    return prefix;
                }
            }
            prefix += ch;
        }
        return prefix;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) 
        {
            strs[i] = scanner.nextLine();
        }

        String result = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
        scanner.close();
    }
}
