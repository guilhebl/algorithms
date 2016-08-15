package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 */
public class BSTOrderLevelTraversal {
	   public List<List<Integer>> levelOrder(TreeNodeCS root) {
	        List<List<Integer>> r = new ArrayList<>();
	        if (root == null) {
	            return r;
	        }
	        
	        List<TreeNodeCS> parents = new ArrayList<>();
	        List<TreeNodeCS> current  = new ArrayList<>();
	        parents.add(root);
	        
	        while(!parents.isEmpty()) {
	            r.add(getIntList(parents));
	            current = new ArrayList<>();
	            for(TreeNodeCS t : parents) {    
	                if (t.left != null) {
	                    current.add(t.left);  
	                }
	                if (t.right != null) {
	                    current.add(t.right);    
	                }
	            }
	            parents = current;
	        }
	        
	        List<List<Integer>> r2 = new ArrayList<>();
	        for(int i = r.size()-1; i >= 0; i--) {
	        	List<Integer> list = r.get(i);
	        	r2.add(list);
	        }
	        return r2;
	    }
	    
	    private List<Integer> getIntList(List<TreeNodeCS> list) {
	        if (list == null) {
	            return null;
	        }
	        List<Integer> r = new ArrayList<>();
	        for(TreeNodeCS t : list) {
	            r.add(t.val);
	        }
	        return r;
	    }
}

class TreeNode {
     int val;
     TreeNodeCS left;
     TreeNodeCS right;
     TreeNode(int x) { val = x; }
 }
