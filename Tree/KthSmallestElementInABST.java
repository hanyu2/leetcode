package Tree;

public class KthSmallestElementInABST {
	public static int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(k < count){
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
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		System.out.println(kthSmallest(n1, 1));
	}
}
