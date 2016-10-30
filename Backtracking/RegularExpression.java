package Backtracking;

public class RegularExpression {
	//http://www.cnblogs.com/lupx/p/leetcode-10.html
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1) {
			return s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
		}

		if (p.charAt(1) == '*') {
			if (isMatch(s, p.substring(2))) {
				return true;
			} else {
				return s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
						&& isMatch(s.substring(1), p);
			}
		} else {
			return s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
					&& isMatch(s.substring(1), p.substring(1));
		}
	}
	
	//https://www.youtube.com/watch?v=l3hda49XcDE
	public static boolean isMatch3(String text, String pattern){
		boolean[][] T = new boolean[text.length() + 1][pattern.length() + 1];
		T[0][0] = true;
		for(int j = 1; j < T[0].length; j++){
			if(pattern.charAt(j - 1) == '*'){
				T[0][j] = T[0][j - 2];
			}
		}
		
		for(int i = 1; i < T.length; i++){
			for(int j = 1; j < T[0].length; j++){
				if(pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)){
					T[i][j] = T[i - 1][j - 1];
				}else if(pattern.charAt(j - 1) == '*'){
					T[i][j] = T[i][j - 2];
					if(pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)){
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				}else{
					T[i][j] = false;
				}
			}
		}
		return T[text.length()][pattern.length()];
	}
	
    	//http://www.cnblogs.com/lupx/p/leetcode-10.html
	public static boolean isMatch2(String s, String p) {
		          int slen = s.length();
		         int plen = p.length();
		 
		         /**
		          * 保存动态规划的中间结果,我们用dp[i][j]来表示: S{0,..i-1} 与P{0,..j-1}的匹配结果.
		          */
		         boolean dp[][] = new boolean[slen+1][plen+1];//上面解释了,i和j在dp里代表s和p的下标.所以,dp尺寸需要加1
		 
		         /**
		         * 下面来分析一下递推公式(DP少不了这个东西!).
		         * 所谓递推公式就是根据之前已经保存的状态推出当前的状态. 也即求当前dp[i][j],可根据之前的结果间接的求出
		          * 假设当前求dp[i][j], 它代表了S{0->i-1}与P{0->j-1}的匹配情况. 那么有以下几个可能:
		          * (1)如果p{j-1}当前不是*,情况简单,当前匹配的唯一条件就是p{j-1}要与s{i-1}匹配
		          *    并且, 之前也都一直匹配, dp[i-1][j-1]匹配! 两者哪个不满足都是false,所以两个条件"&&"一下即可.
		          *    得递推公式:
		          *    when p{j-1}!='*', dp[i][j] = dp[i-1][j-1] && p{j-1} == s{i-1} || p{j-1} == '.'
		        * (2)如果p{j-1}当前是个*, 情况比较复杂了. 首先看看有哪几种可能性, 我们设p{j-2} = X, X* 是个二元组
		          *   (2.1) X没有在s中重复过, 也即X重复了0次, 所以这种情况就是只要dp[i][j-2]为true, 当前就可以为true.
		          *   (2.2) X在S中...i-3,i-2,i-1的位置出现过>=1次, >=1可以拆分开理解,=1成立&&>1也成立!(这是本题最难的部分!一旦理解,这个题就是个easy题了!)
		        *         那么可以假设出现一次的话, 显然必须满足 p{j-2}==s{i-1}||p{j-2}=='.'
		          *         出现>1次, 还应要求, S{0->i-2}最起码要能匹配p{0->j-1}, 也即dp[i-1][j]也需为true
		          *   综上, 2.1和2.2之间是或者的关系,但是2.2内部,>=1我们拆成了>1&&=1的情况,这样就是个&&的关系
		          *    得递推公式:
		          *    when p{j-1}=='*', dp[i][j] = dp[i][j-2] || (p{j-2}==s{i-1}||p{j-2}=='.') && dp[i-1][j]
		          * 有了递推公式, 我们可以看到,当i和j分别推进到各自边界的时候,两个串的最终匹配结果一定保存在dp[slen][plen],return这个结果就可以了!
		          */
		 
		         /**
		         * 显然 dp[0][0] = true, 因为代表两个空串做匹配的结果,肯定是true
		         */
		         dp[0][0] = true;
		 
		         /**
		          * 当p为空串的时候,s有字符,显然全部不可能匹配
		         */
		         for(int i = 1; i <= s.length(); i++) {
		             dp[i][0] = false;
		         }
		 
		         /**
		          * 显然, i=0, j从1-plen遍历的各个结果,代表了p各个子串分别是否能否匹配空串s.
		          * 有一定可能, 当p中j-1位置是*,并且0->j-3的匹配结果是true, 也即dp[0][j-2] = true
		          * 否则,dp[0][j] =false
		          * 这里, 我们把i=0的第一行计算出来
		          */
		         for(int j = 1; j <= p.length(); j++) {
		             //之所以从1开始,是为了方便理解: j位置结果表示了p{0->j-1}的匹配结果
		             //所以,显然dp[0][1]代表了p第一个字符是否能够匹配空串, 显然是不可能的
		             if(j==1) dp[0][j] = false;
		            else dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
		         }
		 
		 
		 
		         /**到这里,我们就已经分析完了基本边界情况以及空串情况,下来开始递推*/
		         for(int i = 1; i <= slen; i++) {
		             for(int j = 1; j <= plen; j++) {
		                 if(p.charAt(j-1) != '*') {
		                     dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1));
		                 }
		                 else {
		                     dp[i][j] = dp[i][j-2]||
		                             (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) && dp[i-1][j];
		                 }
		             }
		         }
		         return dp[slen][plen];
		     }
	public static void main(String[] args) {
		System.out.println(isMatch3("aa", "a*"));
	}
}
