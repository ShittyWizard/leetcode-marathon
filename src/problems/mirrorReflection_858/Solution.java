package problems.mirrorReflection_858;

public class Solution {
    public int mirrorReflection(int p, int q) {
        int roomExtensions = 1; // # of room extension + 1
        int reflections = 1; // # of reflection + 1

        while (roomExtensions * p != reflections * q)
            roomExtensions = ++reflections * q / p;

        if (reflections % 2 == 0)
            return 2;
        if (roomExtensions % 2 == 0)
            return 0;
        if (roomExtensions % 2 == 1)
            return 1;
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        2
        System.out.println(solution.mirrorReflection(2, 1));
//        1
        System.out.println(solution.mirrorReflection(3, 1));
    }
}
