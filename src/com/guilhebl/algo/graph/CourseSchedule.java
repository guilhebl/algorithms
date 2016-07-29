package com.guilhebl.algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Contains answers for problems:
 * https://leetcode.com/problems/course-schedule/
 * https://leetcode.com/problems/course-schedule-ii/
 *
 */
public class CourseSchedule {

	public static void main(String[] args) {
		int[][] a = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(2, a));
		int[][] a2 = { { 1, 0 } };
		System.out.println(canFinish(2, a2));
		int[][] arr1 = { { 1, 0 } };
		printArray(findOrder(2, arr1));
		int[][] arr2 = { { 1, 0 }, {2,0}, {3,1}, {3,2} };
		printArray(findOrder(4, arr2));
		int[][] arr3 = { { 0, 1 }, {1, 0} };
		printArray(findOrder(2, arr3));
		int[][] arr4 = { { 1, 0 }, {2, 0} };
		printArray(findOrder(3, arr4));
		int[][] arr5 = { { 1, 0 } };
		printArray(findOrder(3, arr5));
	}
	
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0 || numCourses == 1) {
			return true;
		}
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[numCourses];
		boolean[] visiting = new boolean[numCourses];
		Map<Integer, Set<Integer>> adjMap = new HashMap<>();
		Set<Integer> tempSet = null;

		for (int i = 0; i < prerequisites.length; i++) {
			int sourceNode = prerequisites[i][0];
			int dependsOnNode = prerequisites[i][1];

			if (!adjMap.containsKey(sourceNode)) {
				tempSet = new HashSet<>();
				tempSet.add(dependsOnNode);
				adjMap.put(sourceNode, tempSet);
			} else {
				tempSet = adjMap.get(sourceNode);
				tempSet.add(dependsOnNode);
				adjMap.put(sourceNode, tempSet);
			}
			if (!adjMap.containsKey(dependsOnNode)) {
				tempSet = new HashSet<>();
				adjMap.put(dependsOnNode, tempSet);
			}
		}
		BooleanWrapper result = new BooleanWrapper(Boolean.TRUE);
		for(int i = 0; i < numCourses; i++) {
			topologicalSort(i, adjMap, visiting, visited, stack, result);	
		}

		return result.result;
	}
	
    public static int[] findOrder(int numCourses, int[][] prerequisites) {		
    	int[] r = null;
    	if (numCourses == 1) {
    	    return new int[1];
    	}
    	if (prerequisites.length == 0) {
    	    r = new int[numCourses];
    		int k = 0;
    		while(k < numCourses) {
    			r[k] = k;
    			k++;
    		}
			return reverse(r);
		}
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[numCourses];
		boolean[] visiting = new boolean[numCourses];
		Map<Integer, Set<Integer>> adjMap = new HashMap<>();
		Set<Integer> tempSet = null;

		for (int i = 0; i < prerequisites.length; i++) {
			int sourceNode = prerequisites[i][0];
			int dependsOnNode = prerequisites[i][1];

			if (!adjMap.containsKey(sourceNode)) {
				tempSet = new HashSet<>();
				tempSet.add(dependsOnNode);
				adjMap.put(sourceNode, tempSet);
			} else {
				tempSet = adjMap.get(sourceNode);
				tempSet.add(dependsOnNode);
				adjMap.put(sourceNode, tempSet);
			}
			if (!adjMap.containsKey(dependsOnNode)) {
				tempSet = new HashSet<>();
				adjMap.put(dependsOnNode, tempSet);
			}
		}
		BooleanWrapper result = new BooleanWrapper(Boolean.TRUE);
		for(int i = 0; i < numCourses; i++) {
			topologicalSort(i, adjMap, visiting, visited, stack, result);	
		}		
		if (!result.result) {
		    return new int[0];
		}
		
		int i = 0;
		r = new int[numCourses];
		while(!stack.isEmpty()) {
			r[i++] = stack.pop();
		}
		int[] topologicalOrder = reverse(r);		
		return topologicalOrder; 
    }    
	
	private static int[] reverse(int[] r) {
		int[] topologicalOrder = new int[r.length];
		for (int j = 0, k = r.length-1; j < topologicalOrder.length && k >= 0; j++, k--) {
			topologicalOrder[j] = r[k];
		}
		
		return topologicalOrder;
	}

	private static void topologicalSort(int i, Map<Integer, Set<Integer>> adjMap, boolean[] visited, boolean[] visiting,
			Stack<Integer> stack, BooleanWrapper result) {
		if (visiting[i]) {
			result.result = Boolean.FALSE;
			return;
		}

		if (!visited[i]) {
			visiting[i] = true;
			Set<Integer> set = adjMap.get(i);
			if (set != null && !set.isEmpty()) {
				for (Integer node : set) {
					topologicalSort(node, adjMap, visited, visiting, stack, result);
				}				
			}
			visited[i] = true;
			visiting[i] = false;
			stack.add(i);
		}
	}
}
class BooleanWrapper {
	Boolean result;
	public BooleanWrapper(Boolean result) {
		super();
		this.result = result;
	}
}
