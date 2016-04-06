package Tree;

import java.util.Stack;

public class KthSmallestElementInABST {
	public static int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(k <= count){
            return kthSmallest(root.left, k);
        }else if(k > count + 1){
            return kthSmallest(root.right, k-1-count);
        }
        return root.val;
    }
    public static int count(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
    
    //DFS
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
    
    //Iterative
    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
  }

    
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		System.out.println(kthSmallest(n1, 1));
	}
}
