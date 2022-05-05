package contests.weeklyContest_291.minimumConsecutiveCards_2260;

import java.util.HashSet;
import java.util.Set;

// link : https://leetcode.com/contest/weekly-contest-291/problems/minimum-consecutive-cards-to-pick-up/
public class Solution {
    public static int minimumCardPickup(int[] cards) {
        int minCards = -1;
        int prev = 0;
        Set<Integer> set = new HashSet<>();
        set.add(cards[0]);
        for (int i = 1; i < cards.length; i++) {
            int cardValue = cards[i];
            if (set.contains(cardValue)) {
                while (prev < i) {
                    if (cards[prev] == cardValue) {
                        int countCards = i - prev + 1;
                        if (minCards == -1 || countCards < minCards) {
                            minCards = countCards;
                        }
                        prev++;
                        break;
                    }
                    set.remove(cards[prev]);
                    prev++;
                }
            } else {
                set.add(cardValue);
            }
        }
        return minCards;
    }

    public static void main(String[] args) {
        int[] cards1 = new int[]{3, 4, 2, 3, 4, 7};
        int[] cards2 = new int[]{1, 0, 5, 3};
        int[] cards3 = new int[]{95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6};
        int[] cards4 = new int[]{77,10,11,51,69,83,33,94,0,42,86,41,65,40,72,8,53,31,43,22,9,94,45,80,40,0,84,34,76,28,7,79,80,93,20,82,36,74,82,89,74,77,27,54,44,93,98,44,39,74,36,9,22,57,70,98,19,68,33,68,49,86,20,50,43};
        int[] cards5 = new int[]{746,464,175,787,105,164,370,110,642,413,353,410,200,141,915,170,928,326,123,528,8,11,474,168,992,43,901,133,579,152,135,893,950,102,863,119,835,795,783,728,35,916,770,698,832,324,391,338,102,770,183,739,804,468,591,174,929,992,406,349,472,260,586,938,677,331,629,769,148,566,501,628,845,197,48,369,754,542,608,632,639,815,758,206,400,105,298,993,187,133,950,430,92,225,609,507,753,873,732,353,894,63,867,814,736,109,440,288,846,152,164,42,96,134,170,649,832,385,265,178,447,678,415,32,428,524,118,775,593,221,247,887,119,159,391,661,220,175,693,184,534,281,569,306,383,330,355,408,30,200,391,136,721,925};
        int[] cards6 = new int[]{2,1,2,1,1};
        System.out.println(minimumCardPickup(cards1)); // 4
        System.out.println(minimumCardPickup(cards2)); // -1
        System.out.println(minimumCardPickup(cards3)); // 3
        System.out.println(minimumCardPickup(cards4)); // 3
        System.out.println(minimumCardPickup(cards5)); // 8
        System.out.println(minimumCardPickup(cards6)); // 2
    }
}
