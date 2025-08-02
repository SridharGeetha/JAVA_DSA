import java.util.Map;

public class DynamicProgramming_MCM {

    public static int MatrixChainMultiplication_Memoization(int i,int j,int[]arr,int[][] dp){

        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for(int k = i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j] +
                        MatrixChainMultiplication_Memoization(i, k, arr,dp)+
                        MatrixChainMultiplication_Memoization(k+1, j, arr,dp);
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;
    }

    public static int MatrixChainMultiplication_Tabulation(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            dp[i][i] = 0;
        }
        for (int i = n-1; i >=1; i--) {
            for (int j = i+1; j < n; j++) {

                int mini = Integer.MAX_VALUE;
                for(int k = i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] +
                                dp[i][k]+
                                dp[k+1][j];
                    mini = Math.min(mini, steps);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][n-1];  
    }

    public static int MinimumCostToCutStick_Memoization(int i,int j,int[]arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;

        for(int ind = i;ind<=j;ind++){
            int steps = arr[j+1] - arr[i-1]+
                        MinimumCostToCutStick_Memoization(i, ind-1, arr, dp)+
                        MinimumCostToCutStick_Memoization(ind+1, j, arr, dp);
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }

    public static int MinimumCostToCutStick_Tabulation(int[] arr,int c){
        // if(i>j) return 0;

        // if(dp[i][j]!=-1) return dp[i][j];

        // int maxi = Integer.MIN_VALUE;

        // for(int k=i;k<=j;k++){
        //     int ans = arr[i-1]*arr[k]*arr[j+1] +
        //         MinimumCostToCutStick_Tabulation(i,k-1,arr,dp)+
        //         MinimumCostToCutStick_Tabulation(k+1, j, arr, dp);
        //     maxi = Math.max(maxi, ans);
        // }

        // return dp[i][j] = maxi;
        return 0;
    }

    public static int BurstBallons_memoization(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){
            int ans = arr[i-1]*arr[k]*arr[j+1] +
                BurstBallons_memoization(i,k-1,arr,dp)+
                BurstBallons_memoization(k+1, j, arr, dp);
            maxi = Math.max(maxi, ans);
        }

        return dp[i][j] = maxi;
    }

    public static int BurstBallons_Tabulation(int[] arr,int c){
        int[][] dp = new int[c+2][c+2];
        for (int i = c; i>=1; i--) {
            for (int j =1; j <= c; j++) {
                if(i>j) continue;
                int maxi = Integer.MIN_VALUE;
                 for(int k=i;k<=j;k++){
                    int ans = arr[i-1]*arr[k]*arr[j+1] +
                        dp[i][k-1]+
                        dp[k+1][j];
                    maxi = Math.max(maxi, ans);
                }

                dp[i][j] = maxi;
            }
        }
        return dp[1][c];
    }

    public static int EvaluateBooleanExpression(int i ,int j,int isTrue,String s,int[][][] dp)
    {
        if(i>j) return 0;
        if(i == j)
        {
            if(isTrue == 1)
            {
                return s.charAt(i) == 'T' ? 1 : 0;
            }
            else
            {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

        int ways = 0;

        for(int k = i+1;k<=j-1;k += 2)
        {
            int leftTrue   = EvaluateBooleanExpression(i, k-1, 1, s, dp);
            int leftFalse  = EvaluateBooleanExpression(i, k-1, 0, s, dp);
            int rigthTrue  = EvaluateBooleanExpression(k+1, j, 1, s, dp);
            int rightFalse = EvaluateBooleanExpression(k+1, j, 0, s, dp);

            char operator = s.charAt(k);
            if(operator == '&')
            {
                if(isTrue == 1)
                {
                    ways += leftTrue * rigthTrue;
                }else
                {
                    ways += (leftFalse*rigthTrue) + (rightFalse * leftTrue) + (rightFalse*leftFalse);
                }
            }
            else if(operator == '|')
            {
                if(isTrue == 1)
                {
                    ways += (leftFalse*rigthTrue) + (leftTrue * rightFalse) + (rigthTrue*leftTrue);
                }else
                {
                    ways += (leftFalse * rightFalse);
                }
            }else
            {   
                if(isTrue == 1)
                {
                    ways += (leftFalse * rigthTrue) + (leftTrue * rightFalse);
                }else
                {
                    ways += (leftFalse * rightFalse) + (leftTrue * rigthTrue);
                }
            }
        }
        return dp[i][j][isTrue] = ways;    
    }

    public static boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static int PalindromePartioning(int i,int j,String s,int[][] dp){

        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i == j || isPalindrome(i,j,s)){
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for(int k = i;k<j;k++){
            int cuts = 1+ PalindromePartioning(i, k, s,dp) +PalindromePartioning(k+1, j, s,dp);

            mini = Math.min(mini, cuts);

        }

        return dp[i][j] = mini;
    }

    public static int PartionArrayMaximumSum(int ind,int[] arr,int k,int[] dp){
        int n = arr.length;
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int maxi = Integer.MIN_VALUE;
        int len = 0;
        int maxValue = Integer.MIN_VALUE;

        for(int i = ind;i<Math.min(ind+k,n);i++){
            len++;
            maxValue = Math.max(maxValue, arr[i]);
            int sum = len * maxValue + PartionArrayMaximumSum(i+1, arr, k,dp);
            maxi = Math.max(maxi, sum);
        }

        return dp[ind] = maxi;
        
    }

    public static int MaxNumOfPalindromeSubstring(int i,int k,String s,int[] dp){
        int n = s.length();
        if(i>=n) return 0;

        if(dp[i] != -1) return dp[i];

        int maxi = Integer.MIN_VALUE;

        // skip
        maxi = MaxNumOfPalindromeSubstring(i+1,k,s, dp);

        for(int j = i+k-1;j<n;j++){
            if(isPalindrome(i, j, s)){
                int count =  1+MaxNumOfPalindromeSubstring(j+1, k, s, dp);
                maxi = Math.max(maxi, count);
                break;
            }
        }

        return dp[i] = maxi;
    }

     //Hard
    public static boolean Scramble_String(String s1 , String s2,Map<String,Boolean> dp){
        int n = s1.length();

        if(n == 1){
            return s1.equals(s2);
        }

        if(s1.equals(s2)){
            return true;
        }

        String key = s1+" "+s2;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        for (int i = 1; i < n; i++) {
            if (Scramble_String(s1.substring(0,i), s2.substring(0,i), dp) && Scramble_String(s1.substring(i), s2.substring(i), dp)) {
                dp.put(key, true);
                return true;
            }
            if(Scramble_String(s1.substring(0,i), s2.substring(n-i), dp) && Scramble_String(s1.substring(i), s2.substring(0,n-i), dp)){
                 dp.put(key, true);
                 return true;
            }
        }

         dp.put(key, false);
         return false;
    }
}
