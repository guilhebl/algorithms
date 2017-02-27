package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * tickets = [
 * ["MUC", "LHR"], 
 * ["JFK", "MUC"], 
 * ["SFO", "SJC"], 
 * ["LHR", "SFO"]
 * ]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * @author root
 *
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		runSolution();
	}
	
	public static void runSolution() {
		ReconstructItinerary ri = new ReconstructItinerary();
		ri.runSample();		
	};
	
	public void runSample() {
		String[][] it = {				
				{"MUC", "LHR"}, 
				{"JFK", "MUC"}, 
				{"SFO", "SJC"}, 
				{"LHR", "SFO"}
		};
		
		List<String> r = findItinerary2(it);
		for (String string : r) {
			System.out.print(string + " ");
		}
	}
	
	public List<String> findItinerary(String[][] tickets) {        
		List<Itinirary> list = new ArrayList<>();						
		for (int i = 0; i < tickets.length; i++) {
			list.add(new Itinirary(tickets[i][0], tickets[i][1]));
		}
		return getOrderedList(list);
    }

	public List<String> getOrderedList(List<Itinirary> l) {		
		if (l == null || l.isEmpty()) {
			return null;
		}
		
		List<String> r = new ArrayList<>();
		
		// 1. find JFK srcs tickets
		String src = "JFK";
		String dest = null;
		boolean found = false;
		r.add(src);
		int usedTicketsCount = 0;
		int j = 0;
								
		while (usedTicketsCount < l.size()) {									
			j = 0;	
			found = false;
			while (!found && !l.isEmpty() && j < l.size()) {
				Itinirary i = l.get(j);
				if (i.src.equals(src) && !i.used) {
					dest = i.dest;
					r.add(dest);
					i.used = true;
					usedTicketsCount++;
					src = dest;
					found = true;
				}
				j++;
			}
		}		
		
		return r;
	}
	
	public List<String> findItinerary2(String[][] tickets) {
	    Map<String, PriorityQueue<String>> map = new HashMap<>();
	    for (String[] ticket : tickets) {
	        if (!map.containsKey(ticket[0])) {
	            map.put(ticket[0], new PriorityQueue<>());
	        }
	        map.get(ticket[0]).offer(ticket[1]);
	    }
	    List<String> path = new LinkedList<>();
	    helper(map, path, "JFK");
	    return path;
	}

	private void helper(Map<String, PriorityQueue<String>> map, List<String> path, String from) {
	    while (map.containsKey(from) && !map.get(from).isEmpty()) {
	        helper(map, path, map.get(from).poll());
	    }
	    path.add(0, from);
	}
	
	class ItineraryComparator implements Comparator<Itinirary> {
		@Override
		public int compare(Itinirary o1, Itinirary o2) {
			if (o1.src.equals(o2.src)) {
				return o1.dest.compareTo(o2.dest);
			};
			return o1.src.compareTo(o2.src);
		}
		
	}
		
	class Itinirary {
		String src;
		String dest;
		boolean used;
		
		public Itinirary(String src, String dest) {
			super();
			this.src = src;
			this.dest = dest;
			used = false;
		}				
	}
	
}
