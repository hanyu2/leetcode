package Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        ser(root, sb);
        return sb.toString();
    }
    
    public void ser(TreeNode root, StringBuilder data){
        if(root == null){
            data.append("# ");
        }else{
            data.append(root.val + " ");
            ser(root.left, data);
            ser(root.right, data);
        }
    }
	
	public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals(" ")){
            return null;
        }
        String[] path = data.split("\\s+");
        Queue<String> q = new LinkedList<String>();
        for(String str : path){
            q.offer(str);
        }
        return des(q);
    }
    
    public TreeNode des(Queue<String> q){
        if(q.isEmpty()){
            return null;
        }else{
            String s = q.poll(); 
            if(s.equals("#")){
                return null;
            }else{
                TreeNode node = new TreeNode(Integer.parseInt(s));
                node.left = des(q);
                node.right = des(q);
                return node;
            }
        }
    }
	
	 public static String serialize2(TreeNode root) {
	        if (root == null) return "";
	        Queue<TreeNode> q = new LinkedList<>();
	        StringBuilder res = new StringBuilder();
	        q.add(root);
	        while (!q.isEmpty()) {
	            TreeNode node = q.poll();
	            if (node == null) {
	                res.append("# ");
	                continue;
	            }
	            res.append(node.val + " ");
	            q.add(node.left);
	            q.add(node.right);
	        }
	        return res.toString();
	    }

	    public static TreeNode deserialize2(String data) {
	        if (data == "") return null;
	        Queue<TreeNode> q = new LinkedList<>();
	        String[] values = data.split(" ");
	        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
	        q.add(root);
	        for (int i = 1; i < values.length; i++) {
	            TreeNode parent = q.poll();
	            if (!values[i].equals("#")) {
	                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
	                parent.left = left;
	                q.add(left);
	            }
	            if (!values[++i].equals("#")) {
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
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.left = n5;
		n4.right = n6;
		System.out.println(serialize2(n1));
		deserialize2(serialize2(n1));
	}
}
