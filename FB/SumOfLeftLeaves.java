package FB;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeNode;

public class SumOfLeftLeaves {
	public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        traverse(root.left, 0, list);
        traverse(root.right, 0, list);
        int sum = 0;
        for(Integer i : list){
            sum += i;
        }
        return sum;
    }
    
    public static void traverse(TreeNode root, int depth, List<Integer> res){
        if(root == null){
            return;
        }
        if(depth >= res.size()){
            res.add(root.val);
        }
        traverse(root.left, depth + 1, res);
        traverse(root.right, depth + 1, res);
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println(sumOfLeftLeaves(n1));
	}
}
