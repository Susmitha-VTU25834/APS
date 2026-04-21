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
import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;

        if (path.length() == 0)
            path = "" + node.val;
        else
            path = path + "->" + node.val;

        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        dfs(node.left, path, res);
        dfs(node.right, path, res);
    }
}