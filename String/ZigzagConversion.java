package String;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
	public static String convert(String s, int numRows) {
		if (s == null || s.length() < 2 || numRows < 2) {
			return s;
		}

		List<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuilder());
		}

		boolean isGoingDown = true;
		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			list.get(index).append(c);

			if (isGoingDown) {
				if (index == numRows - 1) {
					index--;
					isGoingDown = false;
				} else {
					index++;
				}
			} else {
				if (index == 0) {
					index = 1;
					isGoingDown = true;
				} else {
					index--;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : list) {
			res.append(sb.toString());
		}
		return res.toString();
	}

	public static String convert2(String s, int nRows) {
		int length = s.length();
		if (length <= nRows || nRows == 1)
			return s;
		char[] chars = new char[length];
		int step = 2 * (nRows - 1);
		int count = 0;
		for (int i = 0; i < nRows; i++) {
			int interval = step - 2 * i;
			for (int j = i; j < length; j += step) {
				chars[count] = s.charAt(j);
				count++;
				if (interval < step && interval > 0 && j + interval < length && count < length) {
					chars[count] = s.charAt(j + interval);
					count++;
				}
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(convert2("PAYPALISHIRING", 3));
	}
}
