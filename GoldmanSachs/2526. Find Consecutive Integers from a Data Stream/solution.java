


class DataStream {
    int count =0;
    int value, k;


    public DataStream(int value, int k) {
        count = 0;
        this.value = value;
        this.k = k;

    }
    
    public boolean consec(int num) {
        if(num == value){
            count++;

        } else{
            count =0;

        }
        if(count >= k) return true;
        return false;
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */