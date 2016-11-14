package FB;

public class ReadNCharacterGivenRead4IICallMultipleTimes {
	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] temp = new char[4];

	public int read(char[] buf, int n) {
		int total = 0;
		while (total < n) {
			if (buffPtr == 0) {
				buffCnt = read4(temp);
			}
			if (buffCnt == 0)
				break;
			while (total < n && buffPtr < buffCnt) {
				buf[total++] = temp[buffPtr++];
			}
			if (buffPtr >= buffCnt)
				buffPtr = 0;
		}
		return total;
	}

	private int read4(char[] buff2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
