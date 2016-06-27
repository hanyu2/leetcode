package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> sol = new ArrayList<>();
		travel(root, sol, 0);
		return sol;
	}

	private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null)
			return;

		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}

		List<Integer> collection = sol.get(level);
		if (level % 2 == 0)
			collection.add(curr.val);
		else
			collection.add(0, curr.val);

		travel(curr.left, sol, level + 1);
		travel(curr.right, sol, level + 1);
	}
	
	public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack.push(root);
        int level = 1;
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if(level % 2 == 1){
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                }
            }
            level++;
            res.add(list);
            stack.addAll(stack2);
            stack2.clear();
        }
        return res;
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		n1.left = n2;
		n1.right = n3;
		zigzagLevelOrder2(n1);
	}
}
