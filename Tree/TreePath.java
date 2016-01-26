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
			if(newPath.size() - 1 != 0){
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
	
	////////////////////////////////////
	public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null){
            return list;
        }
        createPath(list, String.valueOf(root.val), root);
        return list;
    }
    private void createPath(List<String> list, String path, TreeNode root){
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }
        if(root.left != null){
            createPath(list, path + "->" + String.valueOf(root.left.val), root.left);
        }
        if(root.right != null){
            createPath(list, path + "->" + String.valueOf(root.right.val), root.right);
        }
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		//TreeNode n2 = new TreeNode(2);
		/*
		 * TreeNode n3 = new TreeNode(3); TreeNode n4 = new TreeNode(4);
		 * TreeNode n5 = new TreeNode(5); TreeNode n6 = new TreeNode(6);
		 * TreeNode n7 = new TreeNode(7);
		 */
		//n1.left = n2;
		/*
		 * n1.right = n3; n2.left = n4; n2.right = n5; n3.left = n6; n3.right =
		 * n7;
		 */

		List<String> list = binaryTreePaths(n1);
	}

}
