public class Day2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Middle of the Linked List : LeetCode Problem 876
    // Linked List - Easy
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Linked List Cycle : LeetCode Problem 141
    // Linked List - Easy
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // Merge Two Sorted Lists : LeetCode Problem 21
    // Linked List - Easy
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = null, temp;

        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        }
        temp = head;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if(list1 == null) temp.next = list2;
        else temp.next = list1;

        return head;
    }

    // Remove Duplicates from Sorted List : LeetCode Problem 83
    // Linked List - Easy
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next, unique = head;
        while(temp != null){
            if(temp.val == unique.val) temp = temp.next;
            else{
                unique.next = temp;
                unique = temp;
                temp = temp.next;
            }
        }
        unique.next = null;
        return head;
    }

    // Remove Nth Node From End of List : LeetCode Problem 19
    // Linked List - Medium
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head.next;
        int i = 1;
        while(right != null){
            right = right.next;
            if (i > n){
                left = left.next;
            }
            i++;
        }

        if(i==n){
            return head.next;
        }

        left.next = left.next.next;
        return head;
    }

    // Reverse Linked List : LeetCode Problem 206
    // Linked List - Easy
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null, curr = head, nxt = head.next;

        while(nxt != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        curr.next = prev;
        return curr;
    }

    // Remove Linked List Elements : LeetCode Problem 203
    // Linked List - Easy
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;

        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }

        return head;
    }
}