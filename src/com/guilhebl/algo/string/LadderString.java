package com.guilhebl.algo.string;

/**
 * 
 * given a number n generate a ladder based string as output, sample n = 6:
 * 
     #
    ##
   ###
  ####
 #####
######
 *
 */
public class LadderString {

	public static void main(String[] args) {
		stairCase(6);
	}
    public static void stairCase(int n) {        
        int j = 0;
        StringBuilder sb = null;
        for (int i = 1; i <= n; i++) {
            sb = new StringBuilder();
            j = n - i;
            while(j > 0) {
                sb.append(' ');
                j--;
            }
            j = i;
            while (j > 0) {
                sb.append('#');
                j--;
            }
            System.out.println(sb.toString());
        }
    }

}
