package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if(node == null){
					sb.append("null,");
					continue;
				}else{
					sb.append(node.val).append(",");
				}
				if(node.right != null){
					q.offer(node.left);
					q.offer(node.right);
				}else{
					if(node.left != null){
						q.offer(node.left);
					}
				}
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	static int start = 0;

	public static TreeNode deserialize(String data) {
		if (data.length() == 0) {
			return null;
		}
		String[] strings = data.split(",");
		return des(strings);
	}

	public static TreeNode des(String[] strings) {
		if (start >= strings.length) {
			return null;
		}
		String s = strings[start];
		int val = 0;
		if (s.equals("null")) {
			return null;
		} else {
			val = Integer.parseInt(s);
		}
		TreeNode root = new TreeNode(val);
		start++;
		root.left = des(strings);
		start++;
		root.right = des(strings);
		return root;
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
