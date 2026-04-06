class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return true;
        }

        ListNode a = head;
        ListNode b = head;

        while (b != null && b.next != null) 
        {
            a = a.next;
            b = b.next.next;
        }

        ListNode last = reverse(a);
        ListNode first = head;
        while (last != null) 
        {
            if (first.val != last.val) 
            {
                return false;
            }
            first = first.next;
            last = last.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) 
    {
        ListNode prev = null;
        while (head != null) 
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
