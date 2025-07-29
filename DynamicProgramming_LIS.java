import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DynamicProgramming_LIS {

    public static int LongestIncreasingSubsequence_Memoization(int ind,int prev,int[] arr,int[][] dp){
        if(arr.length==ind) return 0;
        int take = 0;
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        if(prev == -1 || arr[ind]>arr[prev]){
            take =  1+LongestIncreasingSubsequence_Memoization(ind+1,ind,arr,dp);
        }

        int notTake =0+LongestIncreasingSubsequence_Memoization(ind+1,prev,arr,dp);

        return dp[ind][prev+1] = Math.max(take , notTake);

    }

    public static int LongestIncreasingSubsequence_Tabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1]; 

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int notTake = dp[ind + 1][prev + 1];
                int take = 0;
                if (prev == -1 || arr[ind] > arr[prev]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1] = Math.max(take, notTake);
            }
        }
        for (int i = 0; i <dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]+" "); 
            }
            System.out.println();
        }

        return dp[0][0];
    }

    public static int LongestIncreasingSubsequence_Space_Optimization(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        int lastindex= -1;
        for(int ind = 0;ind<n; ind++){
            hash[ind] = ind;
            for(int prev = 0;prev<ind;prev++){
                if(arr[ind]>arr[prev]){
                    dp[ind] = Math.max(dp[ind],1+dp[prev]); 
                    hash[ind] = prev;
                }
            }
            if(max<dp[ind]){
                max = dp[ind];
                lastindex = ind;
            }

        }
        List<Integer> str = new ArrayList<>();
        str.add(arr[lastindex]);
        while(lastindex != hash[lastindex]){
            lastindex = hash[lastindex];
            str.add(arr[lastindex]);
        }
        for(int i=str.size()-1; i>=0; i--){
            System.out.print(str.get(i)+" ");
        }
        System.out.println();

        return max;
    }

    public static List<Integer> LargetDivisibleSet(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        int maxi = 0;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            hash[i]  = i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]%arr[prev]==0 && dp[i]<1+dp[prev]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(maxi<dp[i]){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);    
        }
        Collections.reverse(ans);
        return ans;

    }
  
    // Comparator to Sort the String Based on Length
    static class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
    }
 
    //helper function to compare String
    static boolean checkPossible(String s1,String s2){
    // s1 big
    // s2 small
        int n = s1.length();
        int m = s2.length();
        if(n != m+1) return false;
        int first = 0;
        int second = 0;
        while(first<n){
            if(second<m && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return (first == n && second == m);
    }

    public static int LongestStrinChain(String[] arr){
        int n = arr.length;
        Arrays.sort(arr,new StringLengthComparator());
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 0;
        for(int ind = 0;ind<n;ind++){
            for(int prev = 0;prev<ind;prev++){
                if(checkPossible(arr[ind],arr[prev]) && dp[ind]<1+dp[prev]){
                    dp[ind] = 1+dp[prev];
                }
            }
            maxi = Math.max(maxi,dp[ind]);
        }

        return maxi;
    }

    public static int LongestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        for(int ind = 0;ind<n;ind++){
            dp1[ind] = 1;
            for(int prev = 0;prev<ind;prev++){
                if(arr[ind]>arr[prev] && dp1[ind]<1+dp1[prev]){
                    dp1[ind] = 1+dp1[prev];
                }
            }
        }

        int[] dp2 = new int[n];
        int maxi = 0;
        for(int ind = n-1;ind>=0;ind--){
            dp2[ind] = 1;
            for(int prev = n-1;prev>=0;prev--){
                if(arr[ind]>arr[prev] && dp2[ind]<1+dp2[prev]){
                    dp2[ind] = 1+dp2[prev];
                }
            }
            maxi = Math.max(maxi,(dp1[ind]+dp2[ind]-1));
        }

        // return  maxi;

    // if Questions state it should contain Both Increase and Decrease

    //      int maxi = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (dp1[i] > 1 && dp2[i] > 1) {
    //             maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
    //         }
    //     }
        
        return  maxi;
    // }
    }

    public static int LongestCommonIncreasingSubsequence_Memoization(int i,int j,int prev ,int[] a ,int[] b,int[][][] dp){
        int n = a.length;
        int m = b.length;
        if(i == n || j == m){
            return 0;
        }
        if(dp[i][j][prev+1] != -1) return dp[i][j][prev+1];
        int take = 0;
        if(a[i] == b[j] && (prev == -1 || a[i]>a[prev])){
            take = 1 + LongestCommonIncreasingSubsequence_Memoization(i+1, j+1, i, a, b, dp);
        }

        int notTake = 0+Math.max(
            LongestCommonIncreasingSubsequence_Memoization(i, j+1, prev, a, b, dp),
            LongestCommonIncreasingSubsequence_Memoization(i+1, j, prev, a, b, dp)
        );
        
        return dp[i][j][prev+1] = Math.max(take, notTake);
    }

    public static int LongestCommonIncreasingSubsequence_Optimization(int[]a,int[]b){
                int n = a.length;
        int m = b.length;
        
        int[] dp = new int[m];
        
        int maxi = 0;
        for(int i=0;i<n;i++){
            int currLen = 0;
            for(int j=0;j<m;j++){
                if(a[i]==b[j]){
                    dp[j] = Math.max(dp[j],currLen+1);
                }
                else if(a[i]>b[j]){
                    currLen = Math.max(currLen,dp[j]) ;
                }
            maxi = Math.max(dp[j],maxi);
            }
        }
        
        return maxi;
    }

    public static int MinimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        for(int ind = 0;ind<n;ind++){
            dp1[ind] = 1;
            for(int prev = 0;prev<ind;prev++){
                if(arr[ind]>arr[prev]){
                    dp1[ind] = Math.max(dp1[ind],1+dp1[prev]);
                }
            }
            

        }
        for (int i = 0; i < dp1.length; i++) {
            System.out.print(dp1[i]+" ");
        }
        int[] dp2 = new int[n];
        for(int ind = n-1;ind>=0;ind--){
            dp2[ind] = 1;
            for(int prev = n-1;prev>ind;prev--){
                if(arr[ind]>arr[prev]){
                    dp2[ind] = Math.max(dp2[ind],1+dp2[prev]);
                }
            }
            // System.out.print(dp2[ind]+" ");
        }
        
        int maxi = 0;
        for(int i =0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
                maxi  = Math.max(maxi,dp1[i]+dp2[i]-1);
            }
        }
        System.err.println(maxi);
        return n-maxi;
    }

    
}
