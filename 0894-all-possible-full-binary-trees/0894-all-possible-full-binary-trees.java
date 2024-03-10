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
    public Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();

        if (n % 2 == 0) {
            return result;
        }

        if (!dp.containsKey(n)) {
            List<TreeNode> list = new ArrayList<>();

            if (n == 1) {
                list.add(new TreeNode(0));
            } else {
                for (int i = 1; i <= n - 1; i += 2) {
                    List<TreeNode> lTrees = allPossibleFBT(i);
                    List<TreeNode> rTrees = allPossibleFBT(n - i - 1);

                    for (TreeNode l: lTrees) {
                        for (TreeNode r: rTrees) {
                            list.add(new TreeNode(0, l, r));
                        }
                    }
                }
            }

            dp.put(n, list);
        }

        return dp.get(n);
    }
}