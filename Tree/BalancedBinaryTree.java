package Tree;

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
        if(balance(root) == -1){
            return false;
        }
        return true;
    }
    
    public static int balance(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = balance(root.left);
        int right = balance(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
        	return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.right = n3;
		System.out.println(isBalanced(n1));
	}
}
