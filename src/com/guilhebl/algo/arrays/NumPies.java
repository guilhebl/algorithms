package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class NumPies {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(4);
		list.add(6);
		list.add(2);
		
		System.out.println(getMaxSlices(list, 8));
	}
	
	public static int getMaxSlices(List<Integer> pieSlices, int n) {
		if (pieSlices == null || pieSlices.isEmpty()) {
			return -1; 
		}
				
		int totalSlices = 0;						
		int minPieSize = Integer.MAX_VALUE;
		
		for (Integer i : pieSlices) {
			minPieSize = Math.min(minPieSize, i);
			totalSlices += i;
		}

		if (n > totalSlices) {
			return -1; // impossible to satisfy all
		}

		int slicesPerPerson = totalSlices / n;
		if (slicesPerPerson >= minPieSize) {
			return minPieSize;
		}
		
		int pies = 0;
		while(pies < n && slicesPerPerson > 0) {			
			for (Integer i : pieSlices) {
				pies += i / slicesPerPerson;
			}
						
			if (pies < n) {
				pies = 0;
				slicesPerPerson--;
			}
		}
		
		return slicesPerPerson;
	}
}
