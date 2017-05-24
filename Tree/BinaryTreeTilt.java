package Tree;

public class BinaryTreeTilt {
	static int tilt = 0;
    public static int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = find(root.left);
        int r = find(root.right);
        tilt += Math.abs(l - r);
        return tilt;
    }
    public static int find(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = find(root.left);
        int r = find(root.right);
        tilt += Math.abs(l - r);
        return root.val + l + r;
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n4.left = n5;
		System.out.println(findTilt(n1));
	}
}
