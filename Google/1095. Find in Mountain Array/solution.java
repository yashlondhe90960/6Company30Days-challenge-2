import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        public int peakIndexInMountainArray(MountainArray mountainArr) {
            int n = mountainArr.length();
            int l = 0;
            int r = n - 1;
            
            while (l < r) {
                int mid = l + (r - l) / 2;
                
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            
            return l;
        }
        
        public int binarySearch(MountainArray mountainArr, int l, int r, int target) {
            int mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            
            return -1;
        }
    
        public int reverseBinarySearch(MountainArray mountainArr, int l, int r, int target) {
            int mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) { // Because the array in the right side of the peak is in descending order
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            return -1;
        }
        
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int n = mountainArr.length();
            int peakIndex = peakIndexInMountainArray(mountainArr);
            int idx = binarySearch(mountainArr, 0, peakIndex, target);
            
            if (idx == -1) {
                return reverseBinarySearch(mountainArr, peakIndex, n - 1, target);
            }
            
            return idx;
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