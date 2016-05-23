package com.guilhebl.algo.dp;

public class IncrementAndDoubling {

	public static void main(String[] args) {
		IncrementAndDoubling foo = new IncrementAndDoubling();

		int[] bar = { 2, 1 };
		int[] bar1 = {16, 16, 16};
		int[] bar2 = {100};
		int[] bar3 = {0, 0, 1, 0, 1};
		int[] bar4 = {123, 234, 345, 456, 567, 789};
		int[] bar5 =
		{7,5,8,1,8,6,6,5,3,5,5,2,8,9,9,4,6,9,4,4,1,9,9,2,8,4,7,4,8,8,6,3,9,4,3,4,5,1,9,8,3,8,3,7,9,3,8,4,4,7};
		
		System.out.println(foo.getMin(bar));
		System.out.println(foo.getMin(bar1));
		System.out.println(foo.getMin(bar2));
		System.out.println(foo.getMin(bar3));
		System.out.println(foo.getMin(bar4));
		System.out.println(foo.getMin(bar5));
	}

	public int getMin(int[] desiredArray) {
		int[] A = desiredArray;
		int N = A.length;
		int ret = 0;
		boolean done = false;
		while (!done) {
			// System.out.println(Arrays.toString(A));
			for (int i = 0; i < N; i++) {
				if (A[i] % 2 == 1) {
					A[i]--;
					ret++;
				}
			}
			boolean halved = false;
			done = true;
			for (int i = 0; i < N; i++) {
				if (A[i] > 0) {
					A[i] /= 2;
					done = false;
					halved = true;
				}
			}
			if (halved) {
				ret++;
			}
		}
		return ret;
	}
}
