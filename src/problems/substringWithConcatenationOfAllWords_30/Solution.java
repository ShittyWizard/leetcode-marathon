package problems.substringWithConcatenationOfAllWords_30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;
        int begin = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.putIfAbsent(word, 1);
            if (count != null) {
                map.put(word, ++count);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (begin <= s.length() - windowLen) {
            if (isWindowCorrect(s.substring(begin, begin + windowLen), wordLen, map)) {
                res.add(begin);
            }
            begin++;
        }
        return res;
    }

    private boolean isWindowCorrect(String window, int wordLen, Map<String, Integer> map) {
        Map<String, Integer> seen = new HashMap<>();
        int begin = 0;
        while (begin <= window.length() - wordLen) {
            String word = window.substring(begin, begin + wordLen);
            if (map.containsKey(word)) {
                Integer count = seen.getOrDefault(word, 0);
                count++;
                if (count <= map.get(word)) {
                    seen.put(word, count);
                } else {
                    return false;
                }
                begin += wordLen;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        [0, 9]
//        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        []
//        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
//        [6, 9, 12]
//        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
//        [8]
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
