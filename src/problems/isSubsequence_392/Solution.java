package problems.isSubsequence_392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        String[] splitS = s.split("");
        String[] splitT = t.split("");
        int pointerS = 0;
        int pointerT = 0;

        while (pointerS < s.length() && pointerT < t.length()) {
            if (splitT[pointerT].equals(splitS[pointerS])) {
                pointerS++;
            }
            pointerT++;
        }

        return pointerS == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("a", "axfbqetewc"));
    }
}
