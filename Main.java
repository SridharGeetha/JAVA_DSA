public class Main {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot"; 
        // String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();
        int m = s2.length();
        
        // int res = LongestCommonSubstring.findSubstring(s1.length(), s2.length(), s1, s2);
        // System.out.println(res);

        // System.out.println(LongestPalindromicSubsequence.lps(n, m, s1, s2));

        String res = ShortestCommonSubsequence.scs(n, m, s1, s2);
        System.out.println(res);
    }
}
