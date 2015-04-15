package com.guilhebl.algo.bit;

/**
 * Sparse number is an integer if there are no adjacent 1 in it's binary representation.
  Like: 5 - 101 (no adjacent 1)
        9 - 1001  (no adjacent 1)
  while 6 - 110  is not sparse number.
  Now you are given an integer find the NEXT BIGGER sparse number.Please mind 'it is next bigger'
  
 * @author root
 *
 */
public class NextBiggerBinarySparseNumber {

	public static void main(String args[]) {		
		int n = 10557;
		System.out.println(convertToBinaryString(n));
		int nextSparse = getNextBiggerSparseNumber(n);
		System.out.println(nextSparse);
		System.out.println(convertToBinaryString(nextSparse));		
	}
	
	public static int getNextBiggerSparseNumber(int n) {
		if(isSparseBinaryNumber(n)) {
			int i = getSparseIndexSeqZeros(n);			
			if (i != -1) {
				return fitInSeqZeros(n, i);
			} else {
				// if ends with 1
				if (!getBit(n, 0)) {
					return n + 1;					
				} else {
					return 1 << getLengthBits(n);
				}								
			}
		} else {
			int i = getHighestSeqOnes(n);			
			return incrementToNextSparseFromIndex(n, i);			
		}
					
	}
		
	public static int incrementToNextSparseFromIndex(int n, int index) {
		int i = 0;
		int n2 = n;
		boolean prev = false, current = false;
		
		while(i <= index) {
			n2 = setBit(n2, i, false);
			i++;			
		}
		n2 = setBit(n2,  i, true);
		prev = true;
		i++;
		current = getBit(n2,  i);
				
		while (current && prev && n2 > 0 || (n2 < n && n2 > 0)) {
			n2 = setBit(n2, i - 1, false);			
			i++;		
			prev = current;
			current = getBit(n2,  i);	
		} 	
		if (n2 == 0) {
			return 1 << getLengthBits(n);
		}
				
		return n2;
	}
	
	public static int getLengthBits(int n) {
		int count = 0;
		while (n > 0) {
		    count++;
		    n = n >> 1;
		}		
		return count;
	}
	
	public static int shiftLeftOne(int n) {
		return n << 1;
	}
	
	public static int fitInSeqZeros(int n, int i) {		
		return (n & 0) == 1 ? n + 1 : setBit(n, i - 1, true);
	}	

	/**
	 * Checks index of first seq. of 3 zeros. i.e: "10001 or more
	 * if no seq. found return -1, then number is represented in patterns: "10101" or "1001" 
	 * 
	 * @param n
	 * @return
	 */
	public static int getSparseIndexSeqZeros(int n) {
		// current and previous and previous of previous bit if set to 0 then true
		boolean cur, prev = false, prev2 = false;
		
		int i = 0;
		while(n > 0) {
		  if ( (n & 1) == 0) {
		    cur = true;
		  } else {
		    cur = false;
		  }
		  if (cur && prev && prev2) {
			  return i;
		  }
		  prev2 = prev;
		  prev = cur;		  
		  
		  i++;
		  n = n >> 1;
		 }

		 return -1;
	}

	public static int getHighestSeqOnes(int n) {
		// current and previous bit if set to 1 then true
		boolean cur, prev = false;
		
		int i = 0;
		int highest = -1;
		
		while(n > 0) {
		  if ( (n & 1) == 1) {
		    cur = true;
		  } else {
		    cur = false;
		  }
		  if (cur && prev) {
			  highest = i;
		  }
		  prev = cur;		  
		  
		  i++;
		  n = n >> 1;
		 }

		 return highest;
	}

	public static boolean isSparseBinaryNumber(int n) {
		// current and previous bit if set to 1 then true
		boolean cur, prev = false;
		
		while(n > 0) {
		  if ( (n & 1) == 1) {
		    cur = true;
		  } else {
		    cur = false;
		  }
		  if (cur && prev) {
			  return false;
		  }
		  prev = cur;
		  
		  n = n >> 1;
		 }

		 return true;
	}
	
	
	public static String convertToBinaryString(int n) {
		StringBuilder sb = new StringBuilder();

		 while(n > 0) {
		  if ( (n & 1) == 1) {
		   sb.append("1");
		  } else {
		   sb.append("0");
		  }

		  n = n >> 1;
		 }

		 return sb.reverse().toString();
	}

	public static boolean getBit(int n, int index) {
		return ((n & (1 << index)) > 0);
	}

	public static int setBit(int n, int index, boolean b) {
		if (b) {
			return n | (1 << index);
		} else {
			return n & ~(1 << index);
		}
	}
}