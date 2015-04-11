package com.guilhebl.algo;
import java.util.Arrays;

/**
 * 
 * You are given heights of n candles.
First day you lit one candle  
second day you need to lit two candles 
Third day you need to lit three candles
..........
........
till possible.
After lighting candles the height of candles deduced by 1 each day.You can also extinguish any candle you want but only at the end of day.
So you need to tell the maximum number number of days , you can carry on lighting the candles.
Example : there are three candles of heights {2 , 2 ,2 }
Answer : 3
1.You light first candle on day one.  heights - {1,2,2}
2.You light second and third and extinguish first one .  heights - {1, 1,1}
3.You light all the candles.  heights -{0,0,0}
 *
 */
public class CandlesDecrement {
	public static void main(String[] args) {

		int n = 3;
		int[] a = new int[n];
		a[0] = 2;
		a[1] = 2;
		a[2] = 2;
		
		System.out.println("days: " + daysFromCandles(a, 3));		
	}


	public static int daysFromCandles(int[] a, int daysMax) {
		if(a == null || a.length == 0) {
			// Error
			return -1;
		}
		
		int limit = daysMax;
		int candles = 0; 
		int days = 0; 		
			
		Arrays.sort(a);			
		
		int currentIndex = a.length-1; 	
		boolean stillCandles = true;	
			
		while (stillCandles) {
			// day cycle
			for (int i = 0; i < limit && stillCandles; i++) {
				candles = i + 1;
				
				// starting lit from highest
				int j = currentIndex;
				for (;candles>0 && j>0 && stillCandles; j--,candles--) {										
					if (a[j] > 0) {
						a[j]--;						
					} 
					
					if (j == 0) {
						if (a[j] > 0) {													
							currentIndex--;	
						} else if (a[j] == 0) {
							stillCandles = false;
						} 											
					}
				}
				currentIndex = j;				
				
				if (currentIndex == 0) {					
					int top = a.length-1; 
					while (a[top] == 0 && top > 0) {
						top--;	
					}					 
					if (top == 0) {
						stillCandles = false;
					}
					currentIndex = top;
				}
								
				days++;
			}			
		}
		
		return days;		
	}

}

