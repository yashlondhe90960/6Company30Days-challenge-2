import java.util.*;

class Solution {
    public int minimumLengthEncoding(String[] words) {
       Arrays.sort(words, Comparator.comparingInt(String :: length).reversed());

       List<String> encodingList = new ArrayList<>();
       encodingList.add(words[0]);
       int length = words[0].length();

       for(int i=1;i<words.length;i++){
           boolean suffixFound = false;

           for(String encoding : encodingList){
               if(encoding.endsWith(words[i])){
                   suffixFound = true;
                   break;
               }
           }

           if(!suffixFound){
               encodingList.add(words[i]);
               length += words[i].length();


           }
       } 
       return length + encodingList.size();


    }
}