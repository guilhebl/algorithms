package com.guilhebl.algo.math;

/**
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=13771
 *
 */
public class ProblemSets {
	
	public static void main(String[] args) {
		solveMaxSets();
	}
	
	public static void solveMaxSets() {
		System.out.println(maxSets(2,2,1,2,2));
		
		System.out.println(maxSets(100,100,100,0,0));
		
		System.out.println(maxSets(657,657,657,657,657));
		
		System.out.println(maxSets(1,2,3,4,5));
		
		System.out.println(maxSets(1000000000000000000L,1000000000000000000L,1000000000000000000L,
				1000000000000000000L,1000000000000000000L));		
	}

	public static long maxSets(long E, long EM, long M, long MH, long H) {
		long maxSet = 0;
		long maxE = 0 , maxM = 0, maxH = 0;
		long rest = 0;
		long diffEM, diffMH;
		
		// if all equal
		if(E == EM && EM == M && M == MH && MH == H) {
			maxSet = (E + EM + M + MH + H)/3;
		} else {
			maxE = E;
			maxM = M;
			maxH = H;

			diffEM = Math.abs(E - M);
			diffMH = Math.abs(M - H);
			
			// distribute E - M
			long iEM = 0;
			
			// start adding diff
			while(iEM < diffEM && maxE < maxM) {
				maxE++;
				iEM++;
			}
			while(iEM < EM && maxE > maxM) {
				maxM++;
				iEM++;
			}

			// once equated E and M distribute MH
			// distribute M - H
			long iMH = 0;
			
			// start adding diff
			while(iMH < diffMH && maxM < maxH) {
				maxM++;
				iEM++;
			}
			while(iMH < MH && maxM > maxH) {
				maxH++;
				iEM++;
			}
			
			rest = (MH - iMH) + (EM - iEM);
			while(rest > 0) {
			   if (iEM < EM) {
				  if (maxE <= maxM) {
					  maxE++;
					  rest--;
					  iEM++;
				  } else if (maxE > maxM) {
					  maxM++;
					  rest--;
					  iEM++;
				  }
			   }
				
			   if (iMH < MH) {
				  if (maxH <= maxM) {
					  maxH++;
					  rest--;
					  iMH++;
				  } else if (maxH > maxM) {
					  maxM++;
					  rest--;
					  iMH++;
				  }
			   }												
			}

			maxSet = Math.min(maxM, Math.min(maxE, maxH));			
		}
		
		return maxSet;		
	}
	
}
