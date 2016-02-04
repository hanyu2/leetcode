package Tree;

import com.sun.media.sound.MidiInDeviceProvider;

public class MinDepthTree {
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMin(root);
	}

	public static int getMin(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return Math.min(getMin(root.left), getMin(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		System.out.println(minDepth(n1));
	}
	
}
