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
    private int switc = 0;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        if( switc == 0){
            return true;
        }
        return false;
    }
    public void dfs(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return;
        }
         if(p == null && q != null){
            switc =1;
            return;
                }

         if(p != null && q == null){
            switc =1;
            return;
                }

        if( p.val != q.val){
            switc = 1;
            return;
        }
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }
}