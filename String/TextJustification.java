package String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		for (int i = 0, w; i < words.length; i = w) {
			int len = -1;
			for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
				len += words[w].length() + 1;
			}
			int space = 1, extra = 0, gaps = w - i - 1;
			if (w != i + 1 && w != words.length) {
				space = (maxWidth - len) / gaps + 1;
				extra = (maxWidth - len) % gaps;
			}
			StringBuilder sb = new StringBuilder(words[i]);
			for (int j = i + 1; j < w; j++) {
				for (int s = space; s > 0; s--) {
					sb.append(' ');
				}
				if (extra-- > 0)
					sb.append(' ');
				sb.append(words[j]);
			}
			int remain = maxWidth - sb.length();
			while (remain-- > 0)
				sb.append(' ');
			res.add(sb.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(fullJustify(words, 16));
	}
}
