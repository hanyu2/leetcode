package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
	public static TreeNode invertTree(TreeNode root) {
		if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	
	public TreeNode invertTree2(TreeNode root) {
	    if (root == null) return null;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
	    return root;
	}
    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(invertTree(n1).val);
	}
}
