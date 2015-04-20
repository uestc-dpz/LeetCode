public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null)
            return null;
        
        //待删除的目标节点的前向节点
        ListNode prev_node = null;
        //待删除的目标节点
        ListNode target_node = head;
        //控制节点
        ListNode prune_node = head;
        
        /* 先让控制节点向前移动n-1个距离，这样控制节点和待删除节点就相隔n个距离
         * 同时移动待删除节点和控制节点，当控制节点指向链表末尾的时候，待删除节
         * 点就是倒数第N个节点*/
        for(int i = 1; i < n; i++) {
            prune_node = prune_node.next;
        }
        
        while(prune_node.next != null) {
            prev_node = target_node;
            target_node = target_node.next;
            prune_node = prune_node.next;
        }
        
        //如果删除的是头结点，则更新头结点，否则直接删除目标节点
        if(target_node == head) 
            head = head.next;
        else
            prev_node.next = target_node.next;
        
        return head;
        
    }
}