package BFS;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static String getHint(String secret, String guess) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        int A = 0;
        int B = 0;
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
                continue;
            }
            if(map.containsKey(secret.charAt(i))){
                map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
            }else if(map.containsKey(guess.charAt(i))){
                B++;
                int t = map.get(guess.charAt(i));
                if(t == 1){
                    map.remove(guess.charAt(i));
                }else{
                    map.put(guess.charAt(i), t - 1);
                }
            }
            if(map.containsKey(secret.charAt(i))){
            	map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
            }else{
            	map.put(secret.charAt(i), 1);
            }
            
        }
        for(int i = 0; i < guess.length(); i++){
            if(map.containsKey(guess.charAt(i))){
                B++;
                int t = map.get(guess.charAt(i));
                if(t == 1){
                    map.remove(guess.charAt(i));
                }else{
                    map.put(guess.charAt(i), t - 1);
                }
            }
        }
        return A + "A" + B + "B";
    }
	public static void main(String[] args){
		int[] nums = {1};
		System.out.println(getHint("1807", "7810"));
	}
}
