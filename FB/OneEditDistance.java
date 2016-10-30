package FB;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()){
            return isOneEditDistance(t, s);
        }
        if(Math.abs(t.length() - s.length()) > 1){
            return false;
        }
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else{
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
            i++;
        }
        return s.length() != t.length();
    }
}
