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
    HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
            inorderIndexMap = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                inorderIndexMap.put(inorder[i], i);
            }
            return build(preorder, 0, 0, inorder.length - 1);
        }

         public TreeNode build(int[] preorder, int preStart, int inStart, int inEnd){

            if(preStart >= preorder.length || inStart > inEnd){
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int inIndex = inorderIndexMap.get(rootVal);
            int leftTreeSize = inIndex - inStart;

            root.left = build(preorder, preStart +1, inStart, inIndex -1);
            root.right = build(preorder, preStart + leftTreeSize +1, inIndex +1, inEnd );
            return root;
        }
}
    

       
