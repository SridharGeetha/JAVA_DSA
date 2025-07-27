import java.util.Arrays;

public class DynamicProgramming_String {

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

    public  static int  LongestPalindromicSubsequence(int n,int m, String s1,String s2){
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

    public static String ShortestCommonSupersequence(int n,int m,String s1,String s2){

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                int eq = 0;
                int nq = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    eq = 1+dp[i-1][j-1];
                }else{
                    nq = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = Math.max(eq, nq);
                
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n][m]);
        int i = n;
        int j = m;
        StringBuilder s = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                s.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                s.append(s1.charAt(i-1));
                i--;
            }else{
                s.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            s.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            s.append(s2.charAt(j-1));
            j--;
        }   

        return s.reverse().toString();
    }

    public static int DistinctSubsequence(int i,int j,String s1,String s2,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            int move = DistinctSubsequence(i-1,j-1,s1,s2,dp);
            int stay = DistinctSubsequence(i-1,j,s1,s2,dp);
        return dp[i][j] = (move + stay);
        }else{
            return dp[i][j] = DistinctSubsequence(i-1,j,s1,s2,dp);
        }
    }

     public static int  editDistance(int i,int j,String s1,String s2,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 0+editDistance(i-1,j-1,s1,s2,dp);
        }else{
            int delete = 1+editDistance(i-1,j,s1,s2,dp);
            int insert = 1+editDistance(i,j-1,s1,s2,dp);
            int replace = 1+editDistance(i-1,j-1,s1,s2,dp);

            return dp[i][j] = Math.min(delete,Math.min(insert,replace));
        }
    }    

    public static int wildcardMatching(int i,int j,String s1,String s2,int[][] dp){

        if(i<0 && j<0)  return 1;
        if(i>=0 && j<0) return 0;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k) != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?'){
            return dp[i][j] =  wildcardMatching(i-1, j-1, s1, s2,dp);
        }
        if(s2.charAt(j) == '*'){
            int notTake = wildcardMatching(i, j-1, s1, s2,dp);
            int take =  wildcardMatching(i-1, j, s1, s2,dp);
            return dp[i][j] = (notTake == 1 || take == 1) ? 1 : 0;
        }

        return 0;
    }
    // memoization
    public static int BestTimeBuyAndSellStock_II(int ind ,int buy ,int[][] dp,int[] arr){
        if(ind == arr.length){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        // int profit = 0;
        if(buy == 1){
             return dp[ind][buy] = Math.max(-arr[ind] + BestTimeBuyAndSellStock_II(ind+1,0,dp,arr),0+BestTimeBuyAndSellStock_II(ind+1,1,dp,arr));
        }else{
             return dp[ind][buy] = Math.max(arr[ind] + BestTimeBuyAndSellStock_II(ind+1,1,dp,arr),0+BestTimeBuyAndSellStock_II(ind+1,0,dp,arr));
        }
        // return dp[ind][buy] = profit;
    }

    public static int BestTimeBuyAndSellStock_II_Tabulation(int[] arr){
        int n = arr.length;
        // int[][] dp = new int[n+1][2];
        int[] prev = new int[2];
        int[] curr = new int[2];
        // dp[n][0] = dp[n][1] = 0;
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                    curr[buy] = Math.max(-arr[ind] + prev[0],0+prev[1]);
                }else{
                    curr[buy] = Math.max(arr[ind] + prev[1],0+prev[0]);
                }
            }
            prev = curr;
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }    
        //     System.out.println();
        // }
        return prev[1];
    }

    public static int BestTimeBuyAndSellStock_III_Tabulation(int[] arr){
        int n = arr.length;
        int[][][] dp = new int[n+1][2][3];
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap = 2;cap>0;cap--)
                {
                  if(buy == 1){
                  dp[ind][buy][cap] = Math.max(-arr[ind] + dp[ind+1][0][cap],0+dp[ind+1][1][cap]);
                    }else{
                  dp[ind][buy][cap] = Math.max(arr[ind] + dp[ind+1][1][cap-1],0+dp[ind+1][0][cap]);
            }   
                }
            }
        }        
        return dp[0][1][2];
    }
}
