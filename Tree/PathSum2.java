package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>>ret = new ArrayList<List<Integer>>(); 
	    List<Integer> cur = new ArrayList<Integer>(); 
	    pathSum(root, sum, cur, ret);
	    return ret;
	}

	public void pathSum(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
	    if (root == null){
	        return; 
	    }
	    cur.add(root.val);
	    if (root.left == null && root.right == null && root.val == sum){
	        ret.add(new ArrayList(cur));
	    }else{
	        pathSum(root.left, sum - root.val, cur, ret);
	        pathSum(root.right, sum - root.val, cur, ret);
	    }
	    cur.remove(cur.size()-1);
	}
	
	//Iterative
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));

            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;

        }
        return res;
    }
}
