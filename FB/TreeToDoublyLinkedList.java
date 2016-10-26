package FB;

import Tree.TreeNode;

//In order
public class TreeToDoublyLinkedList {
	public TreeNode treeToList(TreeNode root){
		if(root == null){
			return null;
		}
		root = treeToList(root);
		while(root.left != null){
			root = root.left;
		}
		return root;
	}
	
	public TreeNode treeToListUtil(TreeNode root){
		if(root == null){
			return root;
		}
		if(root.left != null){
			TreeNode node = treeToListUtil(root.left);
			while(node.right != null){
				node = node.right;
			}
			node.right = root;
			root.left = node;
		}
		if(root.right != null){
			TreeNode node = treeToListUtil(root.right);
			while(node.left != null){
				node = node.left;
			}
			node.left = root;
			root.right = node;
		}
		return root;
	}
	
	TreeNode pre = null;
	TreeNode head = null;
	public void treeToList2(TreeNode root){
		if(root == null){
			return;
		}
		treeToList2(root.left);
		if(pre == null){
			head = root;
		}else{
			root.left = pre;
			pre.right = root;
		}
		pre = root;
		treeToList2(root.right);
	}
}
