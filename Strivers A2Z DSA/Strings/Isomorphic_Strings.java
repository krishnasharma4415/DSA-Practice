import java.util.Scanner;

public class Isomorphic_Strings 
{
    public static boolean isIsomorphic(String s, String t) 
    {
        if (s.length() != t.length())
            return false; 

        return true;       
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String s2 = scanner.nextLine();
        
        if (isIsomorphic(s1, s2)) {
            System.out.println("The strings are isomorphic.");
        } else {
            System.out.println("The strings are not isomorphic.");
        }
        
        scanner.close();
    }   
}
