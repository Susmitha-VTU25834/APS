class Solution 
{
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode end = previous;

        while (true) 
        {
            ListNode kth = end;
            for (int i = 0; i < k && kth != null; i++) 
            {
                kth = kth.next;
            }
            if (kth == null) break;

            ListNode start = end.next;
            ListNode next = kth.next;

            ListNode prev = next;
            ListNode curr = start;

            while (curr != next) 
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            end.next = kth;
            end = start;
        }

        return previous.next;
    }
}
