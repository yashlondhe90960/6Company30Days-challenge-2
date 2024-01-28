
import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}


// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
//         int[] dp = new int[envelopes.length];
//         int maxlen=0;
        
//         for(int i=0;i<dp.length;i++){
            
//             //find the index of heioght of envelope[i]
//             int index = binarySearch ( dp, 0, maxlen, envelopes[i][1]);
            
//             dp[index] = envelopes[i][1];
            
//             if(index == maxlen){
//                 maxlen++;
//             }
            
//         }
//         return maxlen;
//     }
    
//     int binarySearch(int[] arr , int start, int end, int target){
//         int index = Arrays.binarySearch(arr,start,end,target);
//         if(index<0){
//             index = -(index+1);
//         }
//         return index;
//     }
// }