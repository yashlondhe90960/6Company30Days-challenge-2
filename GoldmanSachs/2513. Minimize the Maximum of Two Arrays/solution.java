class Solution {
    public int minimizeSet(int d1, int d2, int uniqueCnt1, int uniqueCnt2) {
       long lo = 1, hi = (int) 10e10;
       long ans = hi;
       long lcm = ((long)d1 * (long)d2)/gcd(d1,d2);

       while(lo <= hi){
           long mid = lo + (hi - lo)/2;
           int a = (int) (mid - mid/d1);
           int b = (int) (mid - mid/d2);
           int c = (int) (mid - mid/lcm);

           if(a < uniqueCnt1 || b < uniqueCnt2 || c < uniqueCnt1+ uniqueCnt2){
               lo = mid +1;

           }
           else{
               ans = Math.min(ans, mid);
               hi = mid - 1;
            }
        }

        return (int) ans;



    }

    public long gcd(long a, long b){
        if((a%b) == 0){
            return b;

        }
        else{
            return gcd(b, a%b);
        }
    }
}