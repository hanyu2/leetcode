package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 0){
            return res;
        }
        part(s, 0, new ArrayList<String> (), res);
        return res;
    }
    
    public void part(String s, int index, List<String> list, List<List<String>> res){
        if(index >= s.length()){
            res.add(list);
            return ;
        }
        for(int i = index + 1; i <= s.length(); i++){
            String temp = s.substring(index, i);
            if(isPalin(temp)){
                List<String> tempList = new ArrayList<String>(list);
                tempList.add(temp);
                part(s, i, tempList, res);
            }
        }
    }
    
    public boolean isPalin(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
