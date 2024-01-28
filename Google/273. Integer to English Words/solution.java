class Solution {
    final String[] below_twenty = {
        "", "One", "Two", "Three", "Four","Five","Six","Seven","Eight", "Nine","Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"
    };
    final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"
    };
    final String[] thousands = { "", "Thousand", "Million", "Billion"};



    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        int i=0;
        String words = "";

        while(num > 0){
            if(num % 1000 != 0){
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;

        }
        return words.trim();

        
    }

    String helper(int num){
        if(num == 0) {return "";}
        else if(num < 20){
            return below_twenty[num] + " ";

        } else if(num< 100){
            return tens[num/10] + " " + helper(num % 10);

        } else {
            return below_twenty[num/100] + " Hundred " + helper(num % 100);

        }
    }
}