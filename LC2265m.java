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
    public int averageOfSubtree(TreeNode root) {
        int[] r = helper(root);
        return r[1];
    }

    static int[] helper(TreeNode root){
        if(root == null) {
            return new int[]{0, 0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int sum = left[0] + right[0] + root.val;
        int branches = left[2] + right[2] + 1;
        int counts = left[1] + right[1];
        if(root.val == sum / branches){
            return new int[]{sum, counts + 1, branches};
        } else {
            return new int[]{sum, counts, branches};
        }
    }
}