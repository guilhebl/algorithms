package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 */
public class NestedIterator {

	public static void main(String[] args) {
		
		// [[1,1],2,[1,1]]
		List<NestedInteger> nestedList = new ArrayList<>();

		List<NestedInteger> nestedList1 = new ArrayList<>();
		NestedInteger n11 = new NestedInteger(1, null);
		NestedInteger n12 = new NestedInteger(1, null);
		nestedList1.add(n11);
		nestedList1.add(n12);
		NestedInteger n1 = new NestedInteger(null, nestedList1);		
		nestedList.add(n1);
		
		NestedInteger n2 = new NestedInteger(2, null);
		nestedList.add(n2);
		
		List<NestedInteger> nestedList3 = new ArrayList<>();
		NestedInteger n31 = new NestedInteger(1, null);
		NestedInteger n32 = new NestedInteger(1, null);
		nestedList3.add(n31);
		nestedList3.add(n32);
		NestedInteger n3 = new NestedInteger(null, nestedList3);
		nestedList.add(n3);
		
		NestedIterator i = new NestedIterator(nestedList);
		Integer[] v = new Integer[5];
		int j = 0;
		while (i.hasNext() && j < 5) {
			Integer itg = i.next();
			if (itg != null) {
				v[j] = itg;							
			}
			j++;
		}
		
		printArray(v);
	}
	
	public static void printArray(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}		
	}
	
	
	   private List<NestedInteger> nestedList;

	    public NestedIterator(List<NestedInteger> nestedList) {
	    	this.nestedList = nestedList;
	    }

	    private boolean isEmptyList(List<NestedInteger> nestedList2) {
			if (nestedList2.isEmpty()) {
				return true;
			}
			NestedInteger ni = nestedList2.get(0);
			if (ni.isInteger()) {
				return false;
			}
			return isEmptyList(ni.getList());
	    }
	    
	    public Integer next() {
	       return getNextFromList(this.nestedList);
	    }
	    
	    private Integer getNextFromList(List<NestedInteger> nestedList2) {
	    	Integer num = null;
	           if (hasNext(nestedList2)) {
	               NestedInteger ni = nestedList2.get(0);
	               if (ni.isInteger()) {
	                   nestedList2.remove(0);
	                   num = ni.getInteger();
	               } else {
			           num = getNextFromList(ni.getList());
			           if (ni.getList().isEmpty()) {
			        	   nestedList2.remove(0);
			           }	            	   
	               }
	           }
	           return num;
	    }

	    public boolean hasNext() {	        	    	
	        return hasNext(this.nestedList);
	    }
	    
	    private boolean hasNext(List<NestedInteger> nestedList2) {
	    	if (nestedList2 == null || nestedList2.isEmpty()) {
	            return false;
	        }
	    	NestedInteger ni = nestedList2.get(0);	    	
	        if (ni.isInteger()) {
	          return true;	          	        
	        } 
	        else {
            	while (isEmptyList(ni.getList()) && !nestedList2.isEmpty()) {
    	        	nestedList2.remove(0);	        	
    	        	ni = nestedList2.get(0);            		
            	}	        
       		}	        	        
	        return hasNext(ni.getList());
	    }
	    
}

class NestedInteger {
	private Integer integer;
	private List<NestedInteger> list;
	
     public NestedInteger(Integer integer, List<NestedInteger> list) {
		super();
		this.integer = integer;
		this.list = list;
	}

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger() {
    	 return integer != null;
     };

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger() {
    	 return integer;
     };

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList(){
    	 return list;
     };
     
     public void setList(List<NestedInteger> list) {
		this.list = list;
	}
 }
