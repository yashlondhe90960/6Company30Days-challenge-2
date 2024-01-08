import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        //Method 2:
        Set<String> seen = new HashSet(), repeated = new HashSet();
        for(int i=0;i<s.length() - 9; i++){
            String sub = s.substring(i,i+10);
            if(seen.contains(sub))
                repeated.add(sub);
            else seen.add(sub);
        }

        return new ArrayList(repeated);
    }
}

        //Method 1:

    //    Map<String, Integer> hm = new HashMap<>();

    //    int count =0;
    //    for(int i=0;i<s.length() - 9; i++){
    //       String sub = s.substring(i, i + 10);
    //         hm.put(sub, hm.getOrDefault(sub, 0) + 1);


    //    } 

    //   List<String> list = new ArrayList<>();
    //   for (Map.Entry<String,Integer> mapElement : hm.entrySet()) {
    //         int key = mapElement.getValue();
    //         if (key > 1) {
    //             list.add(mapElement.getKey());
    //         }
    //     }
    //   return list;