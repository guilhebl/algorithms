package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrays {

	public static void main(String[] args) {
		int a1[] = {2,1};
		int a2[] = {1,1};
		printArray(intersect(a1, a2));

	}

	private static void printArray(int[] intersect) {
		for (int i = 0; i < intersect.length; i++) {
			System.out.print(intersect[i] + ",");
		}
	}

    public static int[] intersect(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
        	return null;
        }
        if (arr1.length == 0 || arr2.length == 0) {
        	return new int[0];
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    	int m = arr1.length; 
    	int n = arr2.length;
    	int i = 0, j = 0;
    	List<Integer> list = new ArrayList<>();
  	  while (i < m && j < n)
  	  {
  	    if (arr1[i] > arr2[j])
  	      j++;
  	    else if (arr2[j] > arr1[i])
  	      i++;
  	    else /* if arr1[i] == arr2[j] */
  	    {
  	    	list.add(arr1[i]);  	    	
  	      i++;
  	      j++;
  	    }
  	  }
  
        int[] r = new int[list.size()];
        int idx = 0;
        for (Integer num : list) {
			r[idx] = num;
			idx++;
		}
        return r;
    }

}
