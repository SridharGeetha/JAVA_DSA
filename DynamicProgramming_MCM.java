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
}
