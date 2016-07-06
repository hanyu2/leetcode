package Tree;

public class RecoverBinarySearchTree {
	static TreeNode firstElement = null;
	static TreeNode secondElement = null;
	// The reason for this initialization is to avoid null pointer exception in
	// the first comparison when prevElement has not been initialized
	static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public static void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private static void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		traverse(n1);
	}
}
