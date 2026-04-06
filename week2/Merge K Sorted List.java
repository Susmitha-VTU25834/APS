import java.util.*;
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) 
        {
            if (node != null) 
            {
                pq.offer(node);
            }
        }

        ListNode previous = new ListNode(-1);
        ListNode current = previous;

        while (!pq.isEmpty()) 
        {
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;

            if (min.next != null) 
            {
                pq.offer(min.next);
            }
        }

        return previous.next;
    }
}
