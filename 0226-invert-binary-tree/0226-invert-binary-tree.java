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
    public void invert(TreeNode newNode, TreeNode oldNode) {
        if (oldNode.right != null) {
            newNode.left = new TreeNode(oldNode.right.val);
            invert(newNode.left, oldNode.right);
        }
        if (oldNode.left != null) {
            newNode.right = new TreeNode(oldNode.left.val);
            invert(newNode.right, oldNode.left);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode result = new TreeNode(root.val);
        
        invert(result, root);

        return result;
    }
}