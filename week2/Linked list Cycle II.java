class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
        if (head == null || head.next == null) 
            return null;

        ListNode a = head;
        ListNode b = head;

        while (b != null && b.next != null) 
        {
            a = a.next;
            b = b.next.next;

            if (a == b) 
            {
                ListNode entry = head;
                while (entry != a) 
                {
                    entry = entry.next;
                    a = a.next;
                }
                return entry;
            }
        }

        return null;
    }
}
