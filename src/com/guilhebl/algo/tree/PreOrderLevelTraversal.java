package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderLevelTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        preorderTraversal(root, r);
        return r;
    }

    private void preorderTraversal(TreeNode root, List<Integer> r) {
        if (root == null) return;        
        preorderTraversal(root.left, r);
        r.add(root.val);
        preorderTraversal(root.right, r);
    }

}
