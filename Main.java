import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit"; 
        // String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();
        int m = s2.length();
        
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
