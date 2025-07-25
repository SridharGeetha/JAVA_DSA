public class LongestCommonSubstring{
    
    public static int findSubstring(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        int maxi  = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s1.charAt(i-1) == (s2.charAt(j-1))){
                    int val = 1+dp[i-1][j-1];
                    dp[i][j] = val;
                    maxi = Math.max(maxi, val);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
      return maxi;
        
    }

}