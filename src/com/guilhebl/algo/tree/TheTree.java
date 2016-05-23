package com.guilhebl.algo.tree;

import java.util.Arrays;

public class TheTree {
	public int maximumDiameter(int[] cnt) {
		int ans = 0;
		for (int root = 0; root < cnt.length; root++) {
			int[] cpy = Arrays.copyOf(cnt, cnt.length);
			int get = 0;
			for (int dep = 0; root + dep < cpy.length; dep++) {
				if (cpy[root + dep] == 0)
					break;
				cpy[root + dep]--;
				get++;
			}
			for (int dep = 0; root + dep < cpy.length; dep++) {
				if (cpy[root + dep] == 0)
					break;
				cpy[root + dep]--;
				get++;
			}
			ans = Math.max(ans, get);
		}
		return ans;
	}

	public static void main(String[] args) {
//		for (int i = 1; i < 10; i++) {
//			System.out.println(getSequence(i));	
//		}
		
		long[] d = {8, 5, 10};
		int[] p = {1, 1, 2};
		System.out.println(minimumPrice(d, p));		
		
		long[] d1 = {1, 2, 4, 1000000000};
		int[] p1 = {1, 1, 1, 2};
		System.out.println(minimumPrice(d1, p1));
		

		long[] d2 = {200, 107, 105, 206, 307, 400};
		int[] p2 = {1, 2, 1, 1, 1, 2};
		System.out.println(minimumPrice(d2, p2));

		long[] d3 = {5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333};
		int[] p3 = {2, 2, 1, 1, 1, 1, 2, 1, 2, 1};
		System.out.println(minimumPrice(d3, p3));

		
	}
	
	public static boolean isPalindrome(String s) {
		char a, b;
		int valA = 0, valB = 0;
		int i = 0, j = s.length() - 1;
		while(i < j) {
			a = Character.toLowerCase(s.charAt(i));
			b = Character.toLowerCase(s.charAt(j));
			valA = a - 'a';
			valB = b - 'a';
			
			if(valA < 0 || valA >= 26) {
				i++;
			}
			if(valB < 0 || valB >= 26) {
				j--;
			}			
						
			if((valA >= 0 && valA < 26) && (valB >= 0 && valB < 26) && a != b) {
				return false;
			} else if((valA >= 0 && valA < 26) && (valB >= 0 && valB < 26) && a == b) {
				i++;
				j--;
			}
		}
		return true;
	}
	
	public static String getSequence(int n) {
		
		String current = 1+"";
		for (int i = 1; i < n; i++) {

			current = analyzeInt(current);
		}

		return current;
	}

	public static String analyzeInt(String x) {
		
		if (x.length() == 1) {

			return 1+""+x;
		}

		int currentCount = 1;
		String output = "";

		int i = 0;

		for (i = 1; i <= x.length(); i++) {

			currentCount = 1;
			while (i < x.length() && x.charAt(i - 1) == x.charAt(i)) {
				i++;
				currentCount++;
				//System.out.println(currentCount);
			}

			output += currentCount+""+x.charAt(i - 1)+"";
		}


		return output;
	}
	
    public static int minimumPrice(long[] dread, int[] price){
        return f(0L, 0, dread, price);
    }

    public static int f(long sum, int idx, long[] dread, int[] price){
        if (idx >= dread.length) {
            return 0;
        }
        if (sum >= dread[idx]) {
            int m = Math.min(price[idx] + f(sum + dread[idx], idx + 1, dread, price), 
                f(sum, idx + 1, dread, price));    
            return m;
        } else {
            int m = price[idx] + f(sum + dread[idx], idx + 1, dread, price);
            return m; 
        }
    }
    
}