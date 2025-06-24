import java.util.Scanner;

public class Stock_Buy_and_Sell 
{
    public static int maxProfit(int[] prices) 
    {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) 
        {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else 
            {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the stock prices for each day:");
        for (int i = 0; i < n; i++) 
            prices[i] = scanner.nextInt();

        int result = maxProfit(prices);
        System.out.println("Maximum profit that can be achieved: " + result);
        
        scanner.close();
    }
}
