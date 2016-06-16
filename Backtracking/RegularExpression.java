package Backtracking;

public class RegularExpression {
	public static boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// P.length() >=2
		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}
	//http://cwind.iteye.com/blog/2228723
	public boolean isMatch2(String /* string to check */ s, String /* patterns */ p) {  
        boolean[] match = new boolean[s.length()+1];  
        for(int i=0; i<match.length; i++){  
            match[i] = false;  
        }  
        match[s.length()] = true;  
        for(int i=p.length()-1; i>=0; i--){  
            if(p.charAt(i)=='*'){  
                for(int j=s.length()-1; j>=0; j--){  
                    match[j] = match[j]||match[j+1]&&(p.charAt(i-1)=='.'||p.charAt(i-1)==s.charAt(j));  
                }  
                i--;  
            }else {  
                for(int j=0; j<s.length(); j++){  
                    match[j] = match[j+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j));  
                }  
                match[s.length()] = false;  
            }  
        }  
        return match[0];  
    }  
	public static void main(String[] args) {
		isMatch("aa","a");
	}
}
