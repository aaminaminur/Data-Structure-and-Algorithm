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
    
    public TreeNode build(int[] preOrder, HashMap<Integer, Integer> hm, int inL, int inR, int preIdx){
        if(inL>inR) return null;
        
        TreeNode curr = new TreeNode(preOrder[preIdx]);
        
        int idx = hm.get(preOrder[preIdx]);
        
        curr.left = build(preOrder, hm, inL, idx-1, preIdx+1);
        curr.right = build(preOrder, hm, idx+1, inR, preIdx+1+idx-inL);
        
        return curr;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        
        return build(preorder, hm, 0, inorder.length-1, 0);
    }
}