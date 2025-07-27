import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {3,3,5};
       

        // System.out.println(DynamicProgramming_String.BestTimeBuyAndSellStock_II_Tabulation(arr));

        String s1 = "1";
        String s2 = "1";
        // String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        // System.out.println(DynamicProgramming_String.wildcardMatching(n-1, m-1, s1, s2,dp)==1);
        // System.out.println(DynamicProgramming_String.editDistance(n, m, s1, s2, dp));

        // System.out.println();

        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=m;j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }

        // int res = LongestCommonSubstring.findSubstring(s1.length(), s2.length(), s1, s2);
        // System.out.println(res);

        // System.out.println(LongestPalindromicSubsequence.lps(n, m, s1, s2));

        // String res = ShortestCommonSubsequence.scs(n, m, s1, s2);
        // System.out.println(res);


        // int[][] dp = new int[n][m];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // System.out.println(DynamicProgramming_String.DistinctSubsequence(n-1, m-1, s1, s2,dp));
    }
}
