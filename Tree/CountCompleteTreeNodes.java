package Tree;

public class CountCompleteTreeNodes {
	//
	public int countNodes(TreeNode root) {

		int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);

		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1;
		else
			return 1 + countNodes(root.left) + countNodes(root.right);

	}

	private int rightDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.right;
			dep++;
		}
		return dep;
	}

	private int leftDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.left;
			dep++;
		}
		return dep;
	}
	//Better
	public int countNodes2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == right){
            return (1 << left) + countNodes(root.right);
        }else{
            return (1 << right) + countNodes(root.left);
        }
    }
    public int depth(TreeNode root){
        int dp = 0;
        while(root != null){
            root = root.left;
            dp++;
        }
        return dp;
    }
    //Iterative version of the above one
    public int countNodes3(TreeNode root) {
        int k = 0;
        if(root == null){
            return 0;
        }
        int h1 = depth(root.left);
        while(root != null){
            int h2 = depth(root.right);
            if(h1 == h2){
                root = root.right;
            }else{
                root = root.left;
            }
            k += 1 << h2;
            h1--;
        }
        return k;
    }
  
}
