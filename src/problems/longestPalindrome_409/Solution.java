package problems.longestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<String, Integer> symbolMap = new HashMap<>();

        String[] split = s.split("");
        for (String str : split) {
            Integer count = symbolMap.putIfAbsent(str, 1);
            if (count != null) {
                symbolMap.put(str, ++count);
            }
        }

        int maxLen = 0;
        boolean containsNonOdd = false;
        for (Map.Entry<String, Integer> entry : symbolMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                maxLen += entry.getValue();
            } else {
                containsNonOdd = true;
                maxLen += entry.getValue() - 1;
            }
        }
        if (containsNonOdd) {
            maxLen += 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome("abccccdd"));
//        983 (total sum 999)
        System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
