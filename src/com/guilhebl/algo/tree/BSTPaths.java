package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BSTPaths {
	 
	 public List<String> binaryTreePaths(TreeNodeBSTSearch root) {
	        List<String> r = new ArrayList<>();
	        if (root == null) {
	            return r;
	        }
	        List<StringBuilder> pathList = new ArrayList<>();
	        StringBuilder currPath = new StringBuilder();
	        findPaths(root, pathList, currPath);
	        
	        for(StringBuilder sb : pathList) {
	            r.add(sb.toString());
	        }
	        return r;
	    }
	    
	    public void findPaths(TreeNodeBSTSearch root, List<StringBuilder> pathList, StringBuilder currPath) {
	        if (root == null) {
	            return;
	        }
	        
	        // leaf
	        if (root.left == null && root.right == null) {
	            currPath.append(root.val);
	            pathList.add(currPath);
	        } else {
	            currPath.append(root.val + "->");
	            findPaths(root.left, pathList, new StringBuilder(currPath.toString()));
	            findPaths(root.right, pathList, new StringBuilder(currPath.toString()));
	        }
	    }
	    
}

class TreeNodeBSTSearch {
    int val;
    TreeNodeBSTSearch left;
    TreeNodeBSTSearch right;
    TreeNodeBSTSearch(int x) { val = x; }
}
