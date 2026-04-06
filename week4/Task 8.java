class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int[] freq = new int[26];
        
        for (char t : tasks) 
        {
            freq[t - 'A']++;
        }
        
        int maxFreq = 0;
        for (int f : freq) 
        {
            maxFreq = Math.max(maxFreq, f);
        }
        
        int maxCount = 0;
        for (int f : freq) 
        {
            if (f == maxFreq) maxCount++;
        }
        

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        
        int minIntervals = partCount * partLength + maxCount;
        
        return Math.max(tasks.length, minIntervals);
    }
}
