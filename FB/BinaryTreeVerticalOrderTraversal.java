package FB;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res; 
        }
        int count = 0;
        while(root.left != null){
            root = root.left;
            count++;
        }
        order(root, count, res);
        return res;
    }
    
    public static void order(TreeNode root, int count, List<List<Integer>> res){
        if(root == null){
            return;
        }
        order(root.left, count - 1, res);
        if(res.size() <= count){
            res.add(new ArrayList<Integer>());
        }
        res.get(count).add(root.val);
        order(root.right, count + 1, res);
    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(4);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(5);
    	TreeNode n5 = new TreeNode(2);
    	TreeNode n6 = new TreeNode(6);
    	n1.right = n2;
    	n2.left = n3;
    	n2.right = n4;
    	n3.left = n5;
    	n4.right = n6;
    	System.out.println(verticalOrder(n1));
    }
}
