package com.guilhebl.algo.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/lru-cache/
 *
 */
public class LRUCache {
    
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		//3, [set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)] // [4,3,2,-1,-1,2,3,-1,5]
		
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));

	}
	
	private Map<Integer, LRUNode> cache;
	private LRUNode head;
	private LRUNode tail;
	private Integer maxCapacity;
	
    public LRUCache(int capacity) {
       cache = new HashMap<>(capacity);
       head = tail = null;
       maxCapacity = capacity;
    }
    
    public int get(int key) {
		LRUNode n = cache.get(key);
		if (n != null) {			
			insertInFront(n);
			return n.value;
		}

		return -1;
    }
    
    private void insertInFront(LRUNode n) {
    	if (head == null) {
    		head = tail = n;
    	} else if (!head.equals(n)) {
        	if (n.prev != null) {        		            		
        		if (n.equals(tail)) {
        			n.prev.next = null;
        			tail = n.prev;        			
        		} else {
        			n.prev.next = n.next;        			
        			n.next.prev = n.prev;
        		}
        	}
        	n.prev = null;
           	head.prev = n;        	    	
           	n.next = head;
        	head = n;        	
    	}    	
	}

	private void evict() {		
		if (tail != null) {
			if (tail.prev != null) {
	    		tail.prev.next = null;
	    	}
	    	cache.remove(tail.key);		
	    	tail = tail.prev;
	    	if (tail == null) {
	    		tail = head;
	    	}
		}		
    }
    
    public void set(int key, int value) {
		LRUNode n = cache.get(key);
		if (n == null) {
			if (cache.size() >= maxCapacity) {
				evict();
			}
			n = new LRUNode(key, value);			
		} else {
			n.value = value;
		}
		insertInFront(n);        
		cache.put(key, n);
    }
}

class LRUNode {		
	public LRUNode(Integer key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LRUNode other = (LRUNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}


	public Integer key;
	public Integer value;
	public LRUNode prev;
	public LRUNode next;
}