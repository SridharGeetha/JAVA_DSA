public class DynamicProgarmming_BuyAndSellStock {
    
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
    
    public static int BestTimeBuyAndSellStock_IV_Memoization(int ind,int buy,int cap,int[][][] dp,int[] arr){
        if(ind == arr.length){
            return 0;
        }
        if(cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-arr[ind] + BestTimeBuyAndSellStock_IV_Memoization(ind+1,0,cap,dp,arr),0+BestTimeBuyAndSellStock_IV_Memoization(ind+1,1,cap,dp,arr));
        }else{
            return dp[ind][buy][cap] = Math.max(arr[ind] + BestTimeBuyAndSellStock_IV_Memoization(ind+1,1,cap-1,dp,arr),0+BestTimeBuyAndSellStock_IV_Memoization(ind+1,0,cap,dp,arr));
        }
    }
    
    public static int BestTimeBuyAndSellStock_IV_Tabulation(int k,int[] arr){
           
       int n = arr.length;
       int[][][] dp = new int[n+1][2][k+1];
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
            for(int cap = k;cap>0;cap--)
                {
                  if(buy == 1){
                  dp[ind][buy][cap] = Math.max(-arr[ind] + dp[ind+1][0][cap],0+dp[ind+1][1][cap]);
                    }else{
                  dp[ind][buy][cap] = Math.max(arr[ind] + dp[ind+1][1][cap-1],0+dp[ind+1][0][cap]);
            }   
                }
            }
        }        
        return dp[0][1][k];
    }
 
    public static int BestTimeBuyAndSellStock_Cooldown_Memoization(int ind ,int buy ,int arr[],int[][] dp){
        if(ind >= arr.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
            return dp[ind][buy] = Math.max(-arr[ind]+BestTimeBuyAndSellStock_Cooldown_Memoization(ind+1,0,arr,dp),BestTimeBuyAndSellStock_Cooldown_Memoization(ind+1,1,arr,dp));
        }else{
            return dp[ind][buy] = Math.max(arr[ind]+BestTimeBuyAndSellStock_Cooldown_Memoization(ind+2,1,arr,dp),BestTimeBuyAndSellStock_Cooldown_Memoization(ind+1,0,arr,dp));
        }
    }

    public static int BestTimeBuyAndSellStock_Cooldown_Tabulation(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+2][2];
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
            return dp[ind][buy] = Math.max(-arr[ind]+dp[ind+1][0],dp[ind+1][1]);
        }else{
            return dp[ind][buy] = Math.max(arr[ind]+dp[ind+2][1],dp[ind+1][0]);
        }
            }
        }
        return dp[0][1];
    }

    public static int BestTimeBuyAndSellStock_Fee(int ind ,int buy ,int[][] dp,int[] arr,int fee){
        if(ind == arr.length){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
             return dp[ind][buy] = Math.max(-arr[ind] + BestTimeBuyAndSellStock_Fee(ind+1,0,dp,arr,fee),0+BestTimeBuyAndSellStock_Fee(ind+1,1,dp,arr,fee));
        }else{
             return dp[ind][buy] = Math.max((arr[ind]-fee) + BestTimeBuyAndSellStock_Fee(ind+1,1,dp,arr,fee),0+BestTimeBuyAndSellStock_Fee(ind+1,0,dp,arr,fee));
        }
    }
}
