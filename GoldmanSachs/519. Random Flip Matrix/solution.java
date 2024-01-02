import java.util.*;


class Solution{
    HashMap<Integer, Integer> map;
    int zeroes;
    Random rand;
    int n, m;

    public Solution(int m, int n){
        map = new HashMap<>();
        zeroes = m*n;
        rand = new Random();
        this.n = n;
        this.m = m;

    }

    public int[] flip(){
        int r = rand.nextInt(zeroes);
        int actual = map.getOrDefault(r,r);
        int[] ret = new int[] {actual/n, actual %n};
        map.put(r,map.getOrDefault(zeroes-1, zeroes-1));
        zeroes--;
        return ret;
    }

    public void reset(){
        map.clear();
        zeroes = m*n;
    }
}