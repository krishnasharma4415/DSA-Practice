/*
Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
*/

import java.util.Scanner;

public class Remove_outermost_Paranthesis
{
    public String removeOuterParentheses(String s)
    {
        String result = "";
        int balance = 0;
        
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (c == '(') 
            {
                if (balance > 0)
                    result += c;
                balance++;
            } 
            else if(c == ')')
            {
                balance--;
                if (balance > 0) 
                    result += c;
            }
        }
        
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with parentheses:");
        String input = sc.nextLine();
        
        Remove_outermost_Paranthesis obj = new Remove_outermost_Paranthesis();
        String result = obj.removeOuterParentheses(input);
        
        System.out.println("Result after removing outermost parentheses: " + result);
        sc.close();
    }
}