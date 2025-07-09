class Stack 
{
    private char[] arr;
    private int top;
    private int capacity;
    
    public Stack(int size) 
    {
        arr = new char[size];
        capacity = size;
        top = -1;
    }
    
    public void push(char item) 
    {
        if (isFull()) 
        {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = item;
    }
    
    public char pop() 
    {
        if (isEmpty()) 
        {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return arr[top--];
    }
    
    public boolean isEmpty() 
    {
        if(top == -1)
            return true;
        else
            return false;
    }
    
    public boolean isFull() 
    {
        if(top == capacity-1)
            return true;
        else
            return false;
    }
    
    public char peek() 
    {
        if (isEmpty()) 
        {
            System.out.println("Stack is empty");
            return '\0';
        }
        return arr[top];
    }
    
    public int size() 
    {
        return top + 1;
    }
}


public class Parenthesis_Checking
{
    public static boolean isBalanced(String expression) 
    {
        int n = expression.length();
        Stack stack = new Stack(n);
        
        for (int i = 0; i < n; i++) 
        {
            char ch = expression.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{')
            {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') 
            {
                if (stack.isEmpty())
                    return false;
                
                char top = stack.pop();
                
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}