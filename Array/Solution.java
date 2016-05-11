package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static String getHint(String secret, String guess) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < secret.length(); i++){
            int t = secret.charAt(i) - '0';
            if(!map.containsKey(t)){
                map.put(t, 1);
            }else{
                map.put(t, map.get(t) + 1);
            }
        }
        int a = 0;
        int b = 0;
        for(int i = 0; i < secret.length(); i++){
            if(guess.charAt(i) == secret.charAt(i)){
                a++;
                int temp = guess.charAt(i) - '0';
                int num = map.get(temp);
                num--;
                if(num == 0){
                    map.remove(temp);
                }else{
                    map.put(temp, num);
                }
            }else{
                if(map.containsKey(guess.charAt(i) - '0')){
                    int t = map.get(guess.charAt(i) - '0');
                    b++;
                    t--;
                    if(t == 0){
                        map.remove(guess.charAt(i) - '0');
                    }else{
                        map.put(guess.charAt(i) - '0', t);
                    }
                }
            }
        }
        return a + "A" + b + "B";
    }

	public static void main(String[] args) {
		int[] nums = {1,3,2};
		getHint("1122","1222");
	}
}
