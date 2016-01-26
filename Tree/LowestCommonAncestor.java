package Tree;

public class LowestCommonAncestor {
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null || root == p || root == q){
	            return root;
	        }
	        boolean p_left = cover(root.left, p);
	        boolean q_left = cover(root.left, q);
	        
	        if(p_left != q_left){
	            return root;
	        }
	        TreeNode child = p_left? root.left : root.right;
	        return lowestCommonAncestor(child, p, q);
	    }
	    public static boolean cover(TreeNode root, TreeNode p){
	        if(root == null){
	            return false;
	        }
	        if(root == p){
	            return true;
	        }
	        return cover(root.left, p)||cover(root.right, p);
	    }
	    public static void main(String[] args) {
			TreeNode n1 = new TreeNode(2);
			TreeNode n2 = new TreeNode(1);
			TreeNode n3 = new TreeNode(3);
			n1.left = n2;
			n1.right = n3;
			System.out.println(lowestCommonAncestor(n1, n2, n3).val);
		}
}
