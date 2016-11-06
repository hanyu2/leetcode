package BFS;

import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        if(strs.length == 0){
            return "/";
        }
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(strs[i].equals(".")){
                continue;
            }else{
                stack.push(strs[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
	}
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		System.out.println(simplifyPath("/..."));
	}
}
