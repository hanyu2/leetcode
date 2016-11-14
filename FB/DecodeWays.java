package FB;

public class DecodeWays {

	//N(1) space
	public static int numDecodings4(String s) {
		int n = s.length();
        if(n == 0){
            return 0;
        }
        int first = 1;
        int second = 1;
        int ans = 0;
        int pre = 27;
        for(int i = n - 1; i >= 0; i--){
            int d = s.charAt(i) - '0';
            if(d == 0){
                ans = 0;
            }else{
                ans = first + (d * 10 + pre <= 26 ? second : 0);
            }
            second = first;
            first = ans;
            pre = d;
        }
        return ans;
	}

	public static int numDecodings2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				dp[i] = dp[i + 1];
				if (i < len - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

	public static int numDecodings1(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char[] sa = s.toCharArray();
		int[] nums = new int[sa.length + 1];
		nums[0] = 1;
		for (int i = 1; i <= sa.length; i++) {
			if (sa[i - 1] != '0')
				nums[i] += nums[i - 1];
			if (i > 1 && sa[i - 2] == '1')
				nums[i] += nums[i - 2];
			else if (i > 1 && sa[i - 2] == '2' && sa[i - 1] >= '0' && sa[i - 1] <= '6')
				nums[i] += nums[i - 2];
		}
		return nums[sa.length];
	}

	public static int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	// no extra space
	public int numDecodings3(String s) {
		if (s.length() == 0)
			return 0;
		int pre = 27, digit, answer = 0, first = 1, second = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			digit = s.charAt(i) - '0';
			if (digit == 0)
				answer = 0;
			else
				answer = first + (digit * 10 + pre < 27 ? second : 0);
			second = first;
			first = answer;
			pre = digit;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings1("0"));
		System.out.println(numDecodings2("12415"));
	}
}
