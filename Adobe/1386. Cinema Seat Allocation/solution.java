
import java.util.*;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] seat : reservedSeats){
            map.putIfAbsent(seat[0], new ArrayList());
            map.get(seat[0]).add(seat[1]);
        }
        int result = (n - map.size()) *2;
        for(Integer row : map.keySet()){
            boolean left = true, right = true, mid = true;

            for(int num : map.get(row)){
                if(num >= 2 && num <=5){
                    left = false;
                }
                if(num >= 4 && num <= 7){
                    mid = false;
                }

                if(num >= 6 && num <= 9){
                    right = false;
                }
            }
            if(left  && right){
                result += 2;
            }
            else if(left || right || mid){
                result += 1;
            }

        }
        return result;

    } 
}