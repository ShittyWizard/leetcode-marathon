package problems.findLeavesOfBinaryTree_366;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// link : https://leetcode.com/problems/find-leaves-of-binary-tree/
public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();

        iterate(root, map);

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getKey(), entry.getValue());
        }
        return res;
    }

    private int iterate(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return 0;
        }

        int left = iterate(node.left, map);
        int right = iterate(node.right, map);

        int max = Math.max(left, right);
        if (!map.containsKey(max)) {
            map.put(max, new ArrayList<>());
        }
        map.get(max).add(node.val);
        return max + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(4);
        two.right = new TreeNode(5);
        root.left = two;
        root.right = new TreeNode(3);
        System.out.println(solution.findLeaves(root));
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
