package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}
	//same idea
	public List<String> restoreIpAddresses2(String s) {
		List<String> ans = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i <= 3; ++i) { // first cut
			if (len - i > 9)
				continue;
			for (int j = i + 1; j <= i + 3; ++j) { // second cut
				if (len - j > 6)
					continue;
				for (int k = j + 1; k <= j + 3 && k < len; ++k) { // third cut
					int a, b, c, d; // the four int's seperated by "."
					a = Integer.parseInt(s.substring(0, i));
					b = Integer.parseInt(s.substring(i, j)); // notice that "01" can be parsed to 1. Need to deal with that later.
					c = Integer.parseInt(s.substring(j, k));
					d = Integer.parseInt(s.substring(k));
					if (a > 255 || b > 255 || c > 255 || d > 255)
						continue;
					String ip = a + "." + b + "." + c + "." + d;
					if (ip.length() < len + 3)
						continue; // this is to reject those int's parsed from
									// "01" or "00"-like substrings
					ans.add(ip);
				}
			}
		}
		return ans;
	}

	//backtracking
	public static List<String> restoreIpAddresses4(String s) {
        List<String> res = new ArrayList<>();
        helper(s,"",res,0);
        return res;
    }
    public static void helper(String s, String tmp, List<String> res,int n){
        if(n==4){
            if(s.length()==0) res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int k=1;k<=3;k++){
            if(s.length()<k) break;
            int val = Integer.parseInt(s.substring(0,k));
            if(val>255 || k!=String.valueOf(val).length()) continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        }
    }

	public static void main(String[] args) {
		String s = "25525511135";
		restoreIpAddresses4(s);
	}

}
