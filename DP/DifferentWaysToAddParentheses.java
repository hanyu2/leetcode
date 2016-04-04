package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	
	//Recursive
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for (Integer p1 : part1Ret) {
					for (Integer p2 : part2Ret) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '*':
							c = p1 * p2;
							break;
						}
						ret.add(c);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}
	
	//Recursive with memorization DP
	public static List<Integer> diffWaysToCompute2(String input) {
	    //cache for memorization
	    HashMap<String,List<Integer>> cache = new HashMap<String,List<Integer>>();
	    return helper(input,cache);
	}

	public static List<Integer>helper(String s, HashMap<String,List<Integer>> cache) {
	    if (cache.get(s)!=null) {
	        return cache.get(s);
	    }
	    boolean expression = false;
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for(int i=0; i<s.length(); i++) {
	        if("+-*".indexOf(s.charAt(i))!=-1) {
	            List<Integer> left = helper(s.substring(0,i),cache);
	            List<Integer> right = helper(s.substring(i+1),cache);
	            for(Integer l: left) {
	                for(Integer r: right) {
	                    result.add(cal(l,r,s.charAt(i)));
	                }
	            }
	            expression = true;
	        }
	    }
	    if (!expression) {
	        result.add(Integer.parseInt(s));
	    }
	    cache.put(s, result);
	    return result;
	}
	public static int cal(int l, int r, char op) {
	    int result = 0;
	    switch (op) {
	        case '+': result= l+r; break;
	        case '-': result = l-r; break;
	        case '*': result= l*r; break;
	        default: break;
	    }
	    return result;
	}

	public static void main(String[] args) {
		String input = "2*3-4*5";
		diffWaysToCompute2(input);
	}
}
