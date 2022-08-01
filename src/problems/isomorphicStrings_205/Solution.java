package problems.isomorphicStrings_205;

import java.util.HashMap;
import java.util.Map;


// link : https://leetcode.com/problems/isomorphic-strings/submissions/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        String[] splitS = s.split("");
        String[] splitT = t.split("");
        Map<String, String> mapping = new HashMap<>();

        for (int i = 0; i < splitS.length; i++) {
            String charS = splitS[i];
            String charT = splitT[i];
            if (!mapping.containsKey(charS) && !mapping.containsValue(charT)) {
                mapping.put(charS, charT);
            }
            System.out.println(mapping);
            if (mapping.get(charS) == null || !mapping.get(charS).equals(charT)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egf", "foo"));
    }
}
