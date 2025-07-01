import java.util.Scanner;

public class Roman_to_Integer 
{
    public static int romanToInt(String s) 
    {
        int num = 0;
    
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            switch(ch)
            {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
            if(i > 0 && (ch == 'V' || ch == 'X') && s.charAt(i-1) == 'I') 
                num -= 2;
            else if(i > 0 && (ch == 'L' || ch == 'C') && s.charAt(i-1) == 'X') 
                num -= 20; 
            else if(i > 0 && (ch == 'D' || ch == 'M') && s.charAt(i-1) == 'C') 
                num -= 200; 
        }
        return num;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String roman = sc.nextLine();
        int result = romanToInt(roman);
        System.out.println("The integer value is: " + result);
        sc.close();
    }
}
