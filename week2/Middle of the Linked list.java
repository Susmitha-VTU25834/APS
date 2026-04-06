class Solution 
{
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;   // will point to 4 for this list
    }
}
