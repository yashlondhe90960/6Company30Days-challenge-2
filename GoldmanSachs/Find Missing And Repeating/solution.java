


class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        //S - Sn = x-y
        //Sn = (n(n+1)/2)
        //S2n = (n(n+1)(2n+1))/6
        //s2-s2n = x2-y2
        
        long SN = ((long)n * ((long)n+1))/2;
        long S2N = ((long)n * ((long)n+1) * (2*(long)n+1))/6;
        
        //calculate s=0,s2=0;
        long S=0, S2=0;
        
        
        for(int i=0;i<n;i++){
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
            
        }
    
        
        //S-Sn = x-y
        long val1 = S-SN;
        
        //S2 - S2N = X^2 - Y^2;
        long val2 = S2 - S2N;
        
        val2 = val2/val1;
        
        
        long x = (val1 + val2)/2;
        long y = x- val1;
        int[] ans = {(int)x, (int)y};
        return ans;
        
    }
}