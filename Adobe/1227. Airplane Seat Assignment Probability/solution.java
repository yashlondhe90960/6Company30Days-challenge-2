class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        // else return 1.0/n + (n - 2.0)/n * nthPersonGetsNthSeat(n-1);
        //iske alawa tum bas 0.5 return krdo
        else return 0.5;
    }
}