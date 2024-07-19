public class Day5 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Palindrome Linked List : LeetCode Problem 234
    // Linked List - Easy
    private static final int[] array = new int[100_000];
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode h= head;
        final int[] array1 = array;
        int size =0;

        while(h!=null){
            array1[size++] = h.val;
            h=h.next;
        }

        int m = size/2;
        for(int i=0;i<m;i++){
            if(array[i] != array1[--size]){
                return false;
            }
        }
        return true;
    }

    // Sort a linked list of 0s, 1s and 2s : GfG Article
    // Linked List - Easy
    // https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/

    // Intersection of Two Linked Lists : LeetCode Problem 160
    // Linked List - Easy
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ac=0,bc=0;
        ListNode temp1=headA,temp2=headB;
        while(temp1!=null){
            ac++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            bc++;
            temp2=temp2.next;
        }
        while(ac>bc){
            ac--;
            headA=headA.next;
        }
        while(bc>ac){
            bc--;
            headB=headB.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
