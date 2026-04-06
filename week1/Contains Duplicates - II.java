import java.util.*;

class Solution 
{
    public boolean containsNearbyDuplicate(int[] n, int k) 
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n.length; i++)
        {
            if(i > k)
            {
                set.remove(n[i-k-1]);
            }
            if(!set.add(n[i]))
            {
                return true;
            }
        }
        return false;
    }
}
