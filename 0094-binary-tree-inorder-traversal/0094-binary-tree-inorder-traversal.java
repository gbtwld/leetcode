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
    public List<Integer> result = new ArrayList<Integer>();

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traversal(node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            traversal(node.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }
}