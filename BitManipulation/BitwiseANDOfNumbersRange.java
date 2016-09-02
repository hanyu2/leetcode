package BitManipulation;

public class BitwiseANDOfNumbersRange {
	// https://yq.aliyun.com/articles/3512
	public static int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m = m >>> 1; // shift numbers right
			n = n >>> 1; // shift numbers right
			count = count + 1; // keep track of Shifts
		}
		return n << count; // do left shifts with 0 padding and return answer.
	}

	public int rangeBitwiseAnd2(int m, int n) {
		int r = Integer.MAX_VALUE;
		while ((m & r) != (n & r))
			r = r << 1;
		return n & r;
	}
	public static void main(String[] args){
		System.out.println(rangeBitwiseAnd(5, 9));
	}
}
