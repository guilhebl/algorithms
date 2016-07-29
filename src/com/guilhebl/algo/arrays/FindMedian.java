package com.guilhebl.algo.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 */
public class FindMedian {

	public static void main(String[] args) {
		FindMedian fm = new FindMedian();
		fm.addNum(2);
		fm.addNum(3);
		fm.addNum(4);
		System.out.println(fm.findMedian());

		FindMedian fm2 = new FindMedian();
		fm2.addNum(2);
		fm2.addNum(3);		
		System.out.println(fm2.findMedian());
	}
	
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public FindMedian() {
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2) * -1;
			}
		});
		minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
	}
	
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
        	if (minHeap.peek() != null && num > minHeap.peek()) {
        		maxHeap.offer(minHeap.poll());
        		minHeap.offer(num);
        	} else {
        		maxHeap.offer(num);
        	}
        } else {
        	if (num < maxHeap.peek()) {
        		minHeap.offer(maxHeap.poll());
        		maxHeap.offer(num);
        	} else {
        		minHeap.offer(num);
        	}
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
    	if (maxHeap.size() == minHeap.size()) {
    		return new Double((maxHeap.peek() + minHeap.peek()) / 2.0D);
    	}
    	return maxHeap.peek();
    }
}
