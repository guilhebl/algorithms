package com.guilhebl.algo.bit;

public class CheckByteAtLeastNBitsSetToX {

public static void main(String[] args) {
	System.out.println(hasAtLeastNBitsSetToX((byte)7, 3, true));
}


public static boolean hasAtLeastNBitsSetToX(byte n, int k, boolean isSet) {
  int n1 = n;
  int countOnes = 0, countZeros = 0;
  while (n1 > 0) {
   if ((n1 & 1) > 0) {
     countOnes++;
   } else {
	 countZeros++;
   }      
   n1 = n1 >> 1;
  }
  
  return isSet? (countOnes >= k) : (countZeros >= k);
}

}