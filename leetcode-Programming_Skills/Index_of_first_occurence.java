import java.util.Scanner;

public class Index_of_first_occurence 
{
    public int strStr(String haystack, String needle) 
    {
        
    }   
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the haystack string:");
        String haystack = sc.nextLine();
        System.out.println("Enter the needle string:");
        String needle = sc.nextLine();
        
        Index_of_first_occurence obj = new Index_of_first_occurence();
        int result = obj.strStr(haystack, needle);
        
        if (result != -1)
            System.out.println("The first occurrence of '" + needle + "' in '" + haystack + "' is at index: " + result);
        else
            System.out.println("The string '" + needle + "' is not found in '" + haystack + "'.");
        
        sc.close();
    }
}
