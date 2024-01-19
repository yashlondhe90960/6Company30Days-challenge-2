class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        //convert list to array
        String[] dictArray = dictionary.toArray(new String[0]);

        Arrays.sort(dictArray, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        for(String word : dictArray){
            if(isSubsequence(word.toCharArray(), s.toCharArray())){
                return word;
            }
        }
        return "";
    }

    public static boolean isSubsequence(char[] word, char[] s){
        int i=0, j=0;
        while(i < s.length && j < word.length){
            if(s[i] == word[j]){
                j++;
            }
            i++;

        }
        return j == word.length;

    }
}