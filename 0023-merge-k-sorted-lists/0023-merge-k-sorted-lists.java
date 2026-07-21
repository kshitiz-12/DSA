/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode node : lists){
            if(node!=null){
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!heap.isEmpty()){
            ListNode smallest = heap.poll();
            curr.next=smallest;
            curr=curr.next;

            if(smallest.next!=null){
                heap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}