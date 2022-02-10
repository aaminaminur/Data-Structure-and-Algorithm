/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean check(TreeNode root, long min, long max){
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
        
        boolean lc = check(root.left, min, root.val);
        boolean rc = check(root.right, root.val, max);
        
        return lc && rc;
    }
    
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}