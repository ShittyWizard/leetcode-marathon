package problems.longetPalindromicSubstring_5;

// link : https://leetcode.com/problems/longest-palindromic-substring/submissions/
public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String maxPal = "";
        for (int i = 0; i < chars.length; i++) {
            String pal1 = getPal(chars, i, i);
            if (pal1.length() > maxPal.length()) {
                maxPal = pal1;
            }
            String pal2 = getPal(chars, i, i + 1);
            if (pal2.length() > maxPal.length()) {
                maxPal = pal2;
            }
        }
        return maxPal;
    }

    public String getPal(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = left + 1; i < right; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestPalindrome("ababadfg");
        System.out.println("result: " + result);
    }
}
