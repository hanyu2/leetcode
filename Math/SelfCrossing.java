package Math;

public class SelfCrossing {
	//https://leetcode.com/discuss/88054/java-oms-with-explanation
	public boolean isSelfCrossing(int[] x) {
		if (x.length < 4)
			return false;

		boolean inside = false;
		for (int i = 3; i < x.length; i++) {
			if (inside) {
				if (x[i] >= x[i - 2])
					return true;
				continue;
			}

			if (x[i - 1] > x[i - 3])
				continue;

			int x5 = i >= 5 ? x[i - 5] : 0;
			int x4 = i >= 4 ? x[i - 4] : 0;
			if (x[i - 1] >= x[i - 3] - x5) {
				if (x[i] >= x[i - 2] - x4)
					return true;
			} else {
				if (x[i] >= x[i - 2])
					return true;
			}
			inside = true;
		}
		return false;
	}
}
