class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i <= (1 << n); i++){
            String x = "", y = "";
            for(int j = 0; j < n; j++){
                if(((1 << j) & i) > 0){
                    x += s.charAt(j);
                } else {
                    y += s.charAt(j);
                }
            }
            ans = Math.max(ans, helper(x) * helper(y));
        }
        return ans;
    }
    private int helper(String s){
        String str = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            str = ch + str;
        }
        return lcs(s, str);
    }
    private int lcs(String a, String b){
        int n = a.length(), m = b.length();
        int [][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < m + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}