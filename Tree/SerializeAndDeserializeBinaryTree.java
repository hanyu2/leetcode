package Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("#")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
	
	 public String serialize2(TreeNode root) {
	        if (root == null) return "";
	        Queue<TreeNode> q = new LinkedList<>();
	        StringBuilder res = new StringBuilder();
	        q.add(root);
	        while (!q.isEmpty()) {
	            TreeNode node = q.poll();
	            if (node == null) {
	                res.append("n ");
	                continue;
	            }
	            res.append(node.val + " ");
	            q.add(node.left);
	            q.add(node.right);
	        }
	        return res.toString();
	    }

	    public TreeNode deserialize2(String data) {
	        if (data == "") return null;
	        Queue<TreeNode> q = new LinkedList<>();
	        String[] values = data.split(" ");
	        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
	        q.add(root);
	        for (int i = 1; i < values.length; i++) {
	            TreeNode parent = q.poll();
	            if (!values[i].equals("n")) {
	                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
	                parent.left = left;
	                q.add(left);
	            }
	            if (!values[++i].equals("n")) {
	                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
	                parent.right = right;
	                q.add(right);
	            }
	        }
	        return root;
	    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
		TreeNode n3 = deserialize(serialize(n1));
	}
}
