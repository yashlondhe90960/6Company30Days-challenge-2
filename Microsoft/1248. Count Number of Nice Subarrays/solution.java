import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;++i){
            if((nums[i]&1) == 1){
            nums[i]=1;
            }else {nums[i] = 0;}

        }

        int sum =0, count = 0;
        for(int i=0;i<nums.length;++i){
            sum += nums[i];
            if(sum == k)
            count++;

            if(map.containsKey(sum-k)){
                count += map.get(sum-k);

            }
            map.put(sum, map.getOrDefault(sum, 0) +1);

        }
        return count;
        
    }
}