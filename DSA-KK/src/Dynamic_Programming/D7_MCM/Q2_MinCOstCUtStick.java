package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q2_MinCOstCUtStick {

    // Recursive Approach
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>(Arrays.stream(cuts).boxed().toList());
        list.add(0, 0);
        list.add(n);
        Collections.sort(list);
        int m = cuts.length;

        return minCostStick(1, m, list);
    }

    private int minCostStick(int i, int j, List<Integer> cuts) {
        if (i > j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts.get(j+1) - cuts.get(i-1)
                        + minCostStick(i, ind-1, cuts)
                        + minCostStick(ind+1, j, cuts);
            min = Math.min(min, cost);
        }

        return min;
    }

    // DP-1: Memoization
    public int minCost_mem(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>(Arrays.stream(cuts).boxed().toList());
        list.add(0, 0);
        list.add(n);
        Collections.sort(list);
        int m = cuts.length;
        int[][] dp = new int[m+1][m+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return minCostStick(1, m, list, dp);
    }

    private int minCostStick(int i, int j, List<Integer> cuts, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts.get(j+1) - cuts.get(i-1)
                    + minCostStick(i, ind-1, cuts, dp)
                    + minCostStick(ind+1, j, cuts, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    // DP-2: Tabulation

}
