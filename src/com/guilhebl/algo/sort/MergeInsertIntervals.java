package com.guilhebl.algo.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * https://leetcode.com/problems/merge-intervals/
 * https://leetcode.com/problems/insert-interval/
 *
 */
public class MergeInsertIntervals {

	public static void main(String[] args) {
		
		//[2,3],[5,5],[2,2],[3,4],[3,4]]		
		Interval i1 = new Interval(2,3);
		Interval i2 = new Interval(5,5);
		Interval i3 = new Interval(2,2);
		Interval i4 = new Interval(3,4);
		Interval i5 = new Interval(3,4);
		
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		
		printList(merge(list));
	}
	
	private static void printList(List<Interval> merge) {
		for (Interval interval : merge) {
			System.out.print(interval.start + " " + interval.end + " - ");
		}
		
	}

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {								
				return Integer.compare(o1.start, o2.start);
			}
		});		
		
		List<Interval> r = new ArrayList<>();
		r.add(intervals.get(0));
		Interval it = r.get(0);
		
		int n = 0;
		for (Interval itB : intervals) {
			if (it.end < itB.start) {
				r.add(itB);
				n++;
				it = r.get(n);
			} else {
				it.start = Math.min(it.start, itB.start);
				it.end = Math.max(it.end, itB.end);				
			}						
		}

		return r;
    }
    
	public static List<Interval> merge(List<Interval> intervals) {		
		if (intervals == null || intervals.isEmpty()) {
			return new ArrayList<Interval>();
		}
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {								
				return Integer.compare(o1.start, o2.start);
			}
		});		
		
		List<Interval> r = new ArrayList<>();
		r.add(intervals.get(0));
		Interval it = r.get(0);
		
		int n = 0;
		for (Interval itB : intervals) {
			if (it.end < itB.start) {
				r.add(itB);
				n++;
				it = r.get(n);
			} else {
				it.start = Math.min(it.start, itB.start);
				it.end = Math.max(it.end, itB.end);				
			}						
		}

		return r;		
	}

	public static List<Interval> merge2(List<Interval> intervals) {		
		List<Interval> r = null;
		if (intervals == null || intervals.isEmpty()) {
			return new ArrayList<Interval>();
		}
		r = new ArrayList<>(intervals);

		// try to compress result list merging internal intervals
		List<Interval> r2 = null;
		boolean hasMerge = true;
		boolean merged[] = null;
		while(hasMerge) {		
			hasMerge = false;
			merged = new boolean[r.size()];					
			
			for (int i = 0; i < r.size(); i++) {
				if (!merged[i]) {	
				Interval intervalA = r.get(i);				
					for (int j = i + 1; j < r.size(); j++) {
						if (!merged[j]) {
							Interval intervalB = r.get(j);
							if (intervalA.start <= intervalB.start && intervalA.end >= intervalB.start || 
									intervalB.start <= intervalA.start && intervalB.end >= intervalA.start) {
									if (!hasMerge) {
										hasMerge = true;
										r2 = new ArrayList<>(r);
									}
									Interval interval = new Interval();							
									interval.start = intervalA.start <= intervalB.start ? intervalA.start : intervalB.start;
									interval.end = intervalA.end >= intervalB.end ? intervalA.end : intervalB.end;
									merged[i] = true;
									merged[j] = true;
									
									while(r2.contains(intervalA)) {
										r2.remove(intervalA);
									}
									while(r2.contains(intervalB)) {
										r2.remove(intervalB);
									}
									r2.add(interval);
							}							
						}
					}						
				}
				
			}
			if (hasMerge) {
				r = r2;
			}			
		}		
		return r;		
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return start + " - " + end;
	}
}
