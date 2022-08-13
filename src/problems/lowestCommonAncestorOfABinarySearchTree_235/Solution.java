package problems.lowestCommonAncestorOfABinarySearchTree_235;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode lca = root;
      while (lca != null) {
        if (p.val < lca.val && q.val < lca.val) {
          lca = lca.left;
        } else if (p.val > lca.val && q.val > lca.val) {
          lca = lca.right;
        } else {
          return lca;
        }
      }
      return lca;
    }
}
