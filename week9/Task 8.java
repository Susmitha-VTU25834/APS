class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev1 = 0; // min cost to reach i+1
        int prev2 = 0; // min cost to reach i+2

        for (int i = n - 1; i >= 0; i--) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return Math.min(prev1, prev2);
    }
}