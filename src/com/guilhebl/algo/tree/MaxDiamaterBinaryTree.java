package com.guilhebl.algo.tree;

/**
 * Find max diamater of binary tree
 * 
 * @author root
 *
 */
public class MaxDiamaterBinaryTree {

	public static void main(String[] args) {
		MaxDiamaterBinaryTree sol = new MaxDiamaterBinaryTree();		
		sol.solveBinaryTreeBalancedDiameter();
		sol.solveBinaryTreeDiameter();		
	}

/* 	    binary tree
    		  R
  			/   \
			1    1
		   /  \
		  1    1
 	     / \   /\ 
		1   1  1 1
       /  \     / \
	   1  1     1  1
                   /\
                  1  1	
                     /\
                    1  1	
                  	  
                  
 */	
	public void solveBinaryTreeDiameter() {
		int i = 1;
		NodeB root = new NodeB(i);
		NodeB chLeft1 = new NodeB(i++);
		NodeB chRight1 = new NodeB(i++);
		root.left = chLeft1;
		root.right = chRight1;

		// populating left side
		NodeB chLeft11 = new NodeB(i++);
		NodeB chLeft12 = new NodeB(i++);
		chLeft1.left = chLeft11;
		chLeft1.right = chLeft12;

		NodeB chLeft111 = new NodeB(i++);
		NodeB chLeft112 = new NodeB(i++);
		chLeft11.left = chLeft111;
		chLeft11.right = chLeft112;

		NodeB chLeft1111 = new NodeB(i++);
		NodeB chLeft1112 = new NodeB(i++);
		chLeft111.left = chLeft1111;
		chLeft111.right = chLeft1112;

		NodeB chLeft121 = new NodeB(i++);
		NodeB chLeft122 = new NodeB(i++);
		chLeft12.left = chLeft121;
		chLeft12.right = chLeft122;

		NodeB chLeft1221 = new NodeB(i++);
		NodeB chLeft1222 = new NodeB(i++);
		chLeft122.left = chLeft1221;
		chLeft122.right = chLeft1222;

		NodeB chLeft12221 = new NodeB(i++);
		NodeB chLeft12222 = new NodeB(i++);
		chLeft1222.left = chLeft12221;
		chLeft1222.right = chLeft12222;

		NodeB chLeft122221 = new NodeB(i++);
		NodeB chLeft122222 = new NodeB(i++);
		chLeft12222.left = chLeft122221;
		chLeft12222.right = chLeft122222;
		
		System.out.println(findMaxDiameterOfBinaryTree(root));
	}

/*   	balanced binary tree
		  		  R
				/    \
			   1      1
			 /  \    / \
			1   1   1   1
		   /\  /\   /\  / \
	      1 1 1 1  1  1 1 1			        	  			       
*/	
	public void solveBinaryTreeBalancedDiameter() {
		int i = 1;
		NodeB root = new NodeB(i);
		NodeB chLeft1 = new NodeB(i++);
		NodeB chRight1 = new NodeB(i++);
		root.left = chLeft1;
		root.right = chRight1;

		// populating left side
		NodeB chLeft11 = new NodeB(i++);
		NodeB chLeft12 = new NodeB(i++);
		chLeft1.left = chLeft11;
		chLeft1.right = chLeft12;

		NodeB chLeft111 = new NodeB(i++);
		NodeB chLeft112 = new NodeB(i++);
		chLeft11.left = chLeft111;
		chLeft11.right = chLeft112;

		NodeB chLeft121 = new NodeB(i++);
		NodeB chLeft122 = new NodeB(i++);
		chLeft12.left = chLeft121;
		chLeft12.right = chLeft122;

		// populating right side
		NodeB chRight11 = new NodeB(i++);
		NodeB chRight12 = new NodeB(i++);
		chRight1.left = chRight11;
		chRight1.right = chRight12;

		NodeB chRight111 = new NodeB(i++);
		NodeB chRight112 = new NodeB(i++);
		chRight11.left = chRight111;
		chRight11.right = chRight112;

		NodeB chRight121 = new NodeB(i++);
		NodeB chRight122 = new NodeB(i++);
		chRight12.left = chRight121;
		chRight12.right = chRight122;
		
		System.out.println(findMaxDiameterOfBinaryTree(root));
	}

	public int findMaxDiameterOfBinaryTree(NodeB root) {
		if (root == null) {
			return 0;
		} 
		int heightLeft = findTreeHeight(root.left);
		int heightRight = findTreeHeight(root.right);
						
		return Math.max((heightLeft + heightRight + 1), 
				Math.max(findMaxDiameterOfBinaryTree(root.left), findMaxDiameterOfBinaryTree(root.right)));
	}

	public int findTreeHeight(NodeB root) {
		if (root == null) {
			return 0;
		}						
		return 1 + Math.max(findTreeHeight(root.left), findTreeHeight(root.right));		
	}

}

class NodeB {

	int val;
	NodeB parent;
	NodeB left, right;

	NodeB(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	NodeB(int val, NodeB left, NodeB right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}

}