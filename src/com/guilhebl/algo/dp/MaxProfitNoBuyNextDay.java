package com.guilhebl.algo.dp;

public class MaxProfitNoBuyNextDay {

	public static void main(String[] args) {
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		System.out.println(maxProfit(price));
		System.out.println(stockBuySell(price));
	}
	
	
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int i = 0;
        int min = prices[0];
        int maxDiff = 0, diff = 0;
        
        for(i = 1; i < prices.length; i++) {                    	
        	diff = prices[i] - min;
        	if (diff > maxDiff) {
            	maxDiff = diff;
            }
        	if (prices[i] < min) {
        		min = prices[i];
        	}        	
        }
        
        return maxDiff;
    }
    
	// This function finds the buy sell schedule for maximum profit
	public static int stockBuySell(int price[])
	{
		int n = price.length;
	    // Prices must be given for at least two days
	    if (n == 1)
	        return 0;
	 
	    int count = 0; // count of solution pairs
	 
	    // solution vector
	    Interval[] sol = new Interval[n/2 + 1];
	 
	    // Traverse through given price array
	    int i = 0;
	    while (i < n-1)
	    {
	        // Find Local Minima. Note that the limit is (n-2) as we are
	        // comparing present element to the next element. 
	        while ((i < n-1) && (price[i+1] <= price[i]))
	            i++;
	 
	        // If we reached the end, break as no further solution possible
	        if (i == n-1)
	            break;
	 
	        // Store the index of minima
	        sol[count] = new Interval();
	        sol[count].buy = i++;
	 
	        // Find Local Maxima.  Note that the limit is (n-1) as we are
	        // comparing to previous element
	        while ((i < n) && (price[i] >= price[i-1]))
	            i++;
	 
	        // Store the index of maxima
	        sol[count].sell = i-1;
	 
	        // Increment count of buy/sell pairs
	        count++;
	    }
	 
	    // print solution
	    if (count == 0) {
	    	System.out.println("There is no day when buying the stock will make profit\n");
	    	return 0;
	    }
	        
	    int buy = 0;
	    int sell = 0;
	    for (i = 0; i < count; i++) {
	      buy += price[sol[i].buy];
	      sell += price[sol[i].sell];
	      System.out.println("Buy on day: " + sol[i].buy + ",sell on day: " + sol[i].sell);
	    }
	    return sell - buy;	 	    
	}
	
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		  int count = 0; // count of solution pairs
			 
		    // solution vector
		    Interval[] sol = new Interval[n/2 + 1];
		    
        int sell = 0, prev_sell = 0;
        int buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}

class Interval
{
    int buy;
    int sell;
};
