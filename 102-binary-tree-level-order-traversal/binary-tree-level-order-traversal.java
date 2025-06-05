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
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
                if(root == null) return result;

        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode node, int level){
        if(node == null) return;

        if (result.size() == level) {
           result.add(new ArrayList<>());
       }


        result.get(level).add(node.val);
        levelOrderHelper(node.left, level+1);
        levelOrderHelper(node.right, level+1);
        
    }
}
