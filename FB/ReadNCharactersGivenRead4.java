package FB;

public class ReadNCharactersGivenRead4 {
	public int read(char[] buf, int n) {
		boolean end = false; // end of file flag
		int total = 0; // total bytes have read
		char[] tmp = new char[4]; // temp buffer

		while (!end && total < n) {
			int count = read4(tmp);
			end = count < 4;
			count = Math.min(count, n - total);
			for (int i = 0; i < count; i++)
				buf[total++] = tmp[i];
		}

		return total;
	}

	private int read4(char[] tmp) {
		// TODO Auto-generated method stub
		return 0;
	}
}

