package Math;

public class ReverseInteger {

	public static int reverse(int x) {
		int rst = 0;

		while (x != 0) {
			int next_rst = rst * 10 + x % 10;
			x = x / 10;
			if (next_rst / 10 != rst) {//checks reverse overflow
				rst = 0;
				break;
			}
			rst = next_rst;
		}
		return rst;
	}
	
	public static int reverse2(int x) {
        int rst = 0;
        while(x != 0){
            int next = rst * 10 + x % 10; 
            x = x / 10;
            rst = next;
        }
        return rst;
    }


	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
}
