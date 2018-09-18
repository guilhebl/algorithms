package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ZigZagTraversal {

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        ZigZagTraversal z = new ZigZagTraversal();
        z.printResultsZigZag(z.zigzagLevelOrder(t1));
    }

    public void printResultsZigZag(List<List<Integer>> r) {
        for (List<Integer> l : r) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        if (root == null) return r;

        List<Integer> elems = new ArrayList<>();

        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        boolean right = true;
        currLevel.push(root);

        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.pop();
            elems.add(node.val);

            if (!right) {
                if (node.right != null) nextLevel.add(node.right);
                if (node.left != null) nextLevel.add(node.left);
            } else {
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            if (currLevel.isEmpty()) {
                Stack<TreeNode> temp = new Stack<>();
                currLevel = nextLevel;
                nextLevel = temp;
                right = !right;

                r.add(elems);
                elems = new ArrayList<>();
            }
        }

        return r;
    }

}
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

