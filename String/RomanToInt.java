package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	public int romanToInt(String s) {
		int res = 0;
		int pre = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = transfer(s.charAt(i));
			if (cur <= pre) {
				res += cur;
			} else {
				res -= pre * 2;
				res += cur;
			}
			pre = cur;
		}
		return res;
	}

	int transfer(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}
	public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
		int pre = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = map.get(s.charAt(i));
			if (cur <= pre) {
				res += cur;
			} else {
				res -= pre * 2;
				res += cur;
			}
			pre = cur;
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(romanToInt2("MCMXCVI"));
		System.out.println(romanToInt2("IV"));
	}
}
