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
    
    public TreeNode build(int[] postorder, HashMap<Integer, Integer> hm, int inL, int inR, int postIdx){
        if(inL>inR) return null;
        
        TreeNode curr = new TreeNode(postorder[postIdx]);
        
        int idx = hm.get(postorder[postIdx]);
        
        curr.left = build(postorder, hm, inL, idx-1, postIdx-1-(inR-idx));
        curr.right = build(postorder, hm, idx+1, inR, postIdx-1);
        
        return curr;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        
        return build(postorder, hm, 0, inorder.length-1, postorder.length-1);
    }
}