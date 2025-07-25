public class ShortestCommonSubsequence {
    public static String scs(int n,int m,String s1,String s2){

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
}
