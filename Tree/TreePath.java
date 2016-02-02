package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreePath {
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new LinkedList<String>();
		List<TreeNode> path = new LinkedList<TreeNode>();
		if (root == null) {
			return list;
		}
		findPath(list, path, root);
		return list;
	}

	public static void findPath(List<String> list, List<TreeNode> path, TreeNode root) {
		List<TreeNode> newPath = new ArrayList<TreeNode>();
		newPath.addAll(path);
		newPath.add(root);
		if (root.left == null && root.right == null) {
			String s = newPath.get(0).val + "";
			for (int i = 1; i < newPath.size() - 1; i++) {
				s += "->";
				s += newPath.get(i).val + "";
			}
			if (newPath.size() - 1 != 0) {
				s += "->" + newPath.get(newPath.size() - 1).val;
			}
			list.add(s);
		} else {
			if (root.left != null) {
				findPath(list, newPath, root.left);
			}
			if (root.right != null) {
				findPath(list, newPath, root.right);
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	public static List<String> binaryTreePaths2(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null) {
			return list;
		}
		createPath(list, String.valueOf(root.val), root);
		return list;
	}

	private static void createPath(List<String> list, String path, TreeNode root) {
		if (root.left == null && root.right == null) {
			list.add(path);
			return;
		}
		if (root.left != null) {
			createPath(list, path + "->" + String.valueOf(root.left.val), root.left);
		}
		if (root.right != null) {
			createPath(list, path + "->" + String.valueOf(root.right.val), root.right);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int[] levelVal = new int[1000];

	public static List<String> binaryTreePaths3(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null) {
			return res;
		}

		helper(res, root, 0);
		return res;
	}

	public static void helper(List<String> res, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		levelVal[level] = root.val;
		if (root.left == null && root.right == null) {
			addToRes(res, level);
		}
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
	}

	public static void addToRes(List<String> res, int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append(levelVal[i]);
			sb.append("->");
		}
		sb.append(levelVal[level]);
		res.add(sb.toString());
		return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<String> binaryTreePaths4(TreeNode root) {  
	     List<Integer> one=new ArrayList<>();  
	     List<String> res=new ArrayList<>();  
	     if (root!=null) dfs(root,one,res);  
	     return res;  
	   }  
	   private static void dfs(TreeNode x, List<Integer> one, List<String> res) {  
	     one.add(x.val);  
	     if (x.left!=null) dfs(x.left,one,res);  
	     if (x.right!=null) dfs(x.right,one,res);  
	     if (x.left==null && x.right==null) {  
	       StringBuilder sb=new StringBuilder();  
	       for (int num: one) {  
	         sb.append(String.valueOf(num));  
	         sb.append("->");  
	       }  
	       res.add(sb.substring(0,sb.length()-2));  
	     }  
	     one.remove(one.size()-1);  
	   }  
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);

		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;

		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		List<String> list = binaryTreePaths4(n1);
	}

}
