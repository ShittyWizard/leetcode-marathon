package problems.wordSubsets_916;

import java.util.*;

// link : https://leetcode.com/problems/word-subsets/
public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> resultList = new ArrayList<>();
        boolean isValid = true;

        Map<String, Integer> subWordLetterCount = new HashMap<>();
        for (String subWord : words2) {
            Map<String, Integer> subWordMap = stringToLetterCount(subWord);
            for (Map.Entry<String, Integer> entry : subWordMap.entrySet()) {
                Integer val = subWordLetterCount.putIfAbsent(entry.getKey(), entry.getValue());
                if (val != null) {
                    subWordLetterCount.put(entry.getKey(), Math.max(val, entry.getValue()));
                }
            }
        }

        for (String word : words1) {
            Map<String, Integer> letterCount = stringToLetterCount(word);

            for (Map.Entry<String, Integer> entry : subWordLetterCount.entrySet()) {
                if (letterCount.get(entry.getKey()) != null && letterCount.get(entry.getKey()) >= entry.getValue()) {
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    private Map<String, Integer> stringToLetterCount(String word) {
        String[] letters = word.split("");
        Map<String, Integer> letterCount = new HashMap<>();
        for (String letter : letters) {
            Integer tmp = letterCount.putIfAbsent(letter, 1);
            if (tmp != null) {
                letterCount.put(letter, ++tmp);
            }
        }
        return letterCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
//        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"}));
//        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"p", "p"}));
//        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}));
        System.out.println(solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "oo"}));
    }

    /*
        Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
        Output: ["facebook","google","leetcode"]

        Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
        Output: ["apple","google","leetcode"]
     */
}
