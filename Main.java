import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr =  {1,3,1};
        System.out.println(DynamicProgramming_LIS.MinimumMountainRemovals(arr));

        // int a[] = {3, 4, 9, 1};
        // int b[] = {5, 3, 8, 9, 10, 2, 1};
        // int n = a.length;
        // int m = b.length;
        // int[][][] dp = new int[n][m][n+1];
        // for (int[][] is : dp) {
        //     for (int[] row : is) {
        //         Arrays.fill(row, -1);
        //     }
        // }
        // System.err.println(DynamicProgramming_LIS.LongestCommonIncreasingSubsequence_Memoization(0, 0, -1, a, b, dp));
        // String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        // System.out.println(DynamicProgramming_LIS.LongestStrinChain(words));

        // int[] arr = {1,2,5,4,8};
        // int n = arr.length;
        // System.out.println(DynamicProgramming_LIS.LargetDivisibleSet(arr));
        // System.out.println(DynamicProgramming_LIS.LongestIncreasingSubsequence_Space_Optimization(arr));
        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // System.out.println(DynamicProgramming_LIS.LongestIncreasingSubsequence_Memoization(0, -1, arr, dp));

        // System.out.println(DynamicProgramming_LIS.LongestIncreasingSubsequence_Tabulation(arr));

        // System.out.println(DynamicProgramming_String.BestTimeBuyAndSellStock_II_Tabulation(arr));

        // String s1 = "1";
        // String s2 = "1";
        // String s2 = new StringBuilder(s1).reverse().toString();

        // int n = s1.length();
        // int m = s2.length();
        // int[][] dp = new int[n][m];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }

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
