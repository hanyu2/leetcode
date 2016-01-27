package String;

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
}
