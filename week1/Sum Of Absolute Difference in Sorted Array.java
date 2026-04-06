class Solution 
{
    public int[] getSumAbsoluteDifferences(int[] nums) 
    {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        prefix[0] = 0;
        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int total = prefix[n - 1] + nums[n - 1];
        for(int i = 0; i < n; i++)
        {
            int left = nums[i] * i - prefix[i];
            int right = (total - prefix[i] - nums[i]) - nums[i] * (n - i - 1);
            result[i] = right + left;
        }
        return result;
    }
}
