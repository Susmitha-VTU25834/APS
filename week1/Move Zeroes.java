class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int s = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[s] = nums[i];
                s++;
            }
        }
        while(s < nums.length)
        {
            nums[s] = 0;
            s++;
        }
    }
}
