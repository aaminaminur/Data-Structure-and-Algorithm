/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        q.add(root);
        while(q.size() > 0){
            int count= q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<count; i++){
                Node curr = q.remove();
                ans.add(curr.val);
                for(Node child: curr.children){
                    q.add(child);
                }
            }
            res.add(ans);
        }
        return res;
    }
}