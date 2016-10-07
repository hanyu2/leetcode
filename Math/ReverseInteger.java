package Math;

public class ReverseInteger {

	public int reverse(int x) {
        int sign = 1;
        if(x < 0){
            sign = -1;
        }
        x = Math.abs(x);
        int res = 0;
        while(x != 0){
            if(res * 10 / 10 != res){
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res * sign;
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
