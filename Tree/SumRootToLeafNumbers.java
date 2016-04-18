package Tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	//My solution
	public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        sum(list, root, 0);
        int result = 0;
        for(int i = 0; i < list.size(); i++){
            result += list.get(i);
        }
        return result;
    }
    
    public void sum(List<Integer> list, TreeNode root, int sum){
       if(root == null){
           return;
       }
       if(root.left != null){
           sum(list, root.left, (sum + root.val) * 10);
       }
       if(root.right != null){
           sum(list, root.right, (sum + root.val) * 10);
       }
       if(root.left == null && root.right == null){
           list.add(sum + root.val);
           return;
       }
    }
    
    //Better solution
    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
