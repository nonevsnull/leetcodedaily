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
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }   
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String l = tree2str(root.left);
        String r = tree2str(root.right);

        if(l.isEmpty() && r.isEmpty()){
            return sb.toString();
        } 
        sb.append("(" + l + ")");
        if(!r.isEmpty()){
            sb.append("(" + r + ")");
        }
        return sb.toString();

    }
}