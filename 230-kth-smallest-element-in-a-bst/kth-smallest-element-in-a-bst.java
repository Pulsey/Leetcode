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
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return maxHeap.peek();  
    }

    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        maxHeap.add(root.val);

        while(maxHeap.size() > k){
            maxHeap.poll();
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }
}
