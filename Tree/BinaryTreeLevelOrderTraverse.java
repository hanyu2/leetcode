package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraverse {
	//BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
	
	//DFS
	public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        traverse(res, 0,root);
        return res;
    }
    
    public void traverse(List<List<Integer>> res, int level, TreeNode root){
        if(root == null){
            return;
        }
        if(res.size() <= level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        traverse(res, level + 1, root.left);
        traverse(res, level + 1, root.right);
    }
}
