import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), used, result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> current,
                           boolean[] used,
                           List<List<Integer>> result) {

        // base case: full permutation formed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(nums, current, used, result);

            // un-choose (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}