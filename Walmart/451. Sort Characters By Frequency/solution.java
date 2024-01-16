
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);

        }

        map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(record -> {
          Character key = record.getKey();
          int value = record.getValue();
          for(int i = 0; i < value; i++) {
              sb.append(key);
          }
      });
      return sb.toString();
    }
}