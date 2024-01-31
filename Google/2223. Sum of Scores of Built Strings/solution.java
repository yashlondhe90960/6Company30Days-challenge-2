class Solution {
    public long sumScores(String s) {
        int n = s.length();
        if(n==1){
            return 1;
        }
         long sum =0;
        int[] z = zArray(s);
        for(int k:z){
            if(k!=0){
                sum+=k;
            }
        }
        return sum;
    }
    public int[] zArray(String s){
        int n = s.length();
        int [] z = new int[n];
        z[0] = n;
        int l =0, r =0;
        for(int i =1; i<n; i++){
            if(i>r){
                l = i;
                r= i;
                while(r<n && s.charAt(r) == s.charAt(r-i)){
                    r++;
                }
                z[i] = r-l;
                r--;
            }else{
                int j = i-l;
                if((j+z[j])<=(r-l)){
                    z[i] = z[j];
                }else{
                    l = i;
                    r++;
                    while(r<n && s.charAt(r) == s.charAt(r-i)){
                        r++;
                    }
                    z[i] =r -l;
                    r--;
                }
            }
        }
        return z;
    }
}