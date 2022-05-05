package contests.removeDigitFromNumberToMaximize_2259;


// link : https://leetcode.com/contest/weekly-contest-291/problems/remove-digit-from-number-to-maximize-result/
public class Solution {
    public static String removeDigit(String number, char digit) {
        String maxSum = "0";
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == digit) {
                String sum = number.substring(0, i).concat(number.substring(i + 1));
                if (maxSum.compareTo(sum) < 0) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        String number1 = "123";
        String number2 = "1231";
        String number3 = "551";
        char digit1 = '3';
        char digit2 = '1';
        char digit3 = '5';

        System.out.println(removeDigit(number1, digit1)); // 12
        System.out.println(removeDigit(number2, digit2)); // 231
        System.out.println(removeDigit(number3, digit3)); // 51
    }
}
