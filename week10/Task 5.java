import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // choose
            current.add(nums[i]);

            // explore
            backtrack(nums, i + 1, current, result);

            // un-choose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}