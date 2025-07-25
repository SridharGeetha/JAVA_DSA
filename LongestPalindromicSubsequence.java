public class LongestPalindromicSubsequence {
    public  static int  lps(int n,int m, String s1,String s2){
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int equals = 0;
                int notEquals = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    equals = 1+ dp[i-1][j-1];
                }else{
                    notEquals  = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = Math.max(equals,notEquals);
            }
        }
        return dp[n][m];
    }
}
