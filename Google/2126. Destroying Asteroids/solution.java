import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

       long masss = mass;
       for(int ast : asteroids){
           if((long) ast > masss) return false;
           masss += ast;
       }
       return true;


    }
}