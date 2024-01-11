import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
       //Method 1: sorting
        // int n=nums.length;
        // int[][] indexAndVal = new int[n][2];

        // for(int i=0;i<n;++i){
        //     indexAndVal[i] = new int[]{i, nums[i]};

        // }

        // //reverse sort by value
        // Arrays.sort(indexAndVal, Comparator.comparingInt(a -> -a[1]));
        // int[][] maxK = Arrays.copyOf(indexAndVal, k);

        // //sort by index;

        // Arrays.sort(maxK, Comparator.comparingInt(a -> a[0]));
        // int[] seq = new int[k];
        // for(int i=0;i<k;++i){
        //     seq[i] = maxK[i][1];
        // }
        // return seq;


        //Method 2: PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for(int n: nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: pq){
            freq.merge(n, 1, Integer:: sum);
   
        }

        int[] seq = new int[k];
        int i=0;
        for(int n: nums){
            if(freq.merge(n,-1,Integer::sum) >= 0){
                seq[i++] = n;

            }
        }
        return seq;

        
    }
}