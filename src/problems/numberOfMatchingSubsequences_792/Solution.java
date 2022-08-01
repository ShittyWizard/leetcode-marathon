package problems.numberOfMatchingSubsequences_792;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words) {
            Integer prevVal = mapWords.putIfAbsent(word, 1);
            if (prevVal != null) {
                mapWords.put(word, ++prevVal);
            }
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : mapWords.entrySet()) {
            if (isSubsequence(s, entry.getKey())) {
                res += entry.getValue();
            }
        }
        return res;
    }

    private boolean isSubsequence(String word, String subword) {
        if (subword.equals(word)) {
            return true;
        }
        int pointerSubword = 0;
        int pointerWord = 0;

        while (pointerSubword < subword.length() && pointerWord < word.length()) {
            if (word.charAt(pointerWord) == subword.charAt(pointerSubword)) {
                pointerSubword++;
            }
            pointerWord++;
        }

        return pointerSubword == subword.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        3
        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
//        2
        System.out.println(solution.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }
}
