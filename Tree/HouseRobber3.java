package Tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {
	//https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem
	//TLE
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int val = 0;
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		return Math.max(val + root.val, rob(root.left) + rob(root.right));
	}
	//optimization
	public int rob2(TreeNode root) {
	    Map<TreeNode, Integer> map = new HashMap<>();
	    return robSub(root, map);
	}

	private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
	    if (root == null) return 0;
	    if (map.containsKey(root)) return map.get(root);
	    
	    int val = 0;
	    
	    if (root.left != null) {
	        val += robSub(root.left.left, map) + robSub(root.left.right, map);
	    }
	    
	    if (root.right != null) {
	        val += robSub(root.right.left, map) + robSub(root.right.right, map);
	    }
	    
	    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
	    map.put(root, val);
	    
	    return val;
	}
	
	
	public static int rob3(TreeNode root) {
		int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private static int[] robSub(TreeNode root) {
	    if (root == null) {
	    	return new int[2];
	    }
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    
	    int[] res = new int[2];
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(1);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n1.right = n5;
		n5.right = n6;
		n6.right = n7;
		System.out.println(rob3(n1));
	}
}
