package Tree;

public class InvertTree {
	public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invert(root);
        return root;
    }
    
    public static void invert(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
        	invert(root.left);
        }
        if(root.right != null){
        	invert(root.right);
        }
    }
    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(invertTree(n1).val);
	}
}
