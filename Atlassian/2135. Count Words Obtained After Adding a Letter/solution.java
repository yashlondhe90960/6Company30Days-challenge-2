import java.util.*;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {

        //bit masking approach
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for(String word : startWords){
            seen.add(bitmask(word));

        }

        for(String word : targetWords){
            int bitmask = bitmask(word);
            for(char c: word.toCharArray()){
                if(seen.contains(bitmask - (1 << c - 'a'))){
                    ans++;
                    break;

                }
            }
        }
        return ans;
    }

    private int bitmask(String word){
        int res = 0;
        for(char c: word.toCharArray()){
            res += 1 << c - 'a';
        }
        return res;

    }
}

//sorting approach 
        // Set<String> set = new HashSet<>();
        // for(String s : startWords){
        //     char[] charStr = s.toCharArray();
        //     Arrays.sort(charStr);
        //     //will sort all strings in sorted order
        //     set.add(new String(charStr));

        // }

        // int count  = 0;
        // for(String t : targetWords){
        //     int n = t.length();
        //     for(int i=0;i<n;i++){
        //         String reducedStr = t.substring(0,i) + t.substring(i+1);
            
        //         char[] charStr = reducedStr.toCharArray();
        //         Arrays.sort(charStr);
        //         String storedStr = new String(charStr);
        //         if(set.contains(storedStr)){
        //         count++;
        //         break;
        //         }
        //     }
        // }
        // return count;