package Math;

public class IntegerBreak {
	//https://leetcode.com/discuss/98276/why-factor-2-or-3-the-math-behind-this-problem
	public static int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
}
