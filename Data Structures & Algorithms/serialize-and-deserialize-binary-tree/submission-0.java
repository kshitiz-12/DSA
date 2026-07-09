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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
        
    }
    private void helper(TreeNode root , StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return build(queue);
        
    }
    private TreeNode build (Queue<String> queue){
        String value = queue.poll();

        if(value.equals("N"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = build(queue);
        root.right = build(queue);

        return root;
    }
}
