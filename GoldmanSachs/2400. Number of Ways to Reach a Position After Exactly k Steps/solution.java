import java.util.*;


class Solution {
    private int mod = 1000000007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3002][1001];

        for(int[] item : dp){
            Arrays.fill(item,-1);
            //fill array with -1
        }
        return topDownApproach(startPos,endPos,startPos,k,dp);

    }

    private int topDownApproach(int s, int e, int curr, int k, int[][] dp){
        if(k==0){
            if(curr == e){ return 1;}
            else { return 0;}
        }

        if(dp[curr + 1001][k] != -1){
            return dp[curr+1001][k];

        }
        int rightMove = topDownApproach(s,e,curr+1,k-1,dp)%mod;

        int leftMove = topDownApproach(s,e,curr-1, k-1,dp)%mod;

        return dp[curr+1001][k] = (rightMove + leftMove)%mod;

    }
}