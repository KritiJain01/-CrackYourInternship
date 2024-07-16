import java.util.*;
public class Day3 {
    // Implement Queue using Stacks : LeetCode Problem 232
    // Stacks and Queues - Easy
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            if(stack1.empty()){
                stack1.push(x);
                return;
            }
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.empty();
        }
    }

    // Backspace String Compare : LeetCode Problem 844
    // Stacks and Queues - Easy
    public boolean backspaceCompare(String s, String t) {
        return getActualString(s).equals(getActualString(t));
    }

    private String getActualString(final String s) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Add Binary : LeetCode Problem 67
    // Mathematical - Easy
    public String addBinary(String a, String b) {
        char[] toReturn = new char[0];
        char[] toAdd = new char[0];
        int r = 0;

        if(a.length() > b.length()){
            toReturn = a.toCharArray();
            toAdd = b.toCharArray();
        }
        else{
            toReturn = b.toCharArray();
            toAdd = a.toCharArray();
        }

        int i = toReturn.length - 1;
        for(int j = toAdd.length - 1; j >= 0; j--){
            int x = ((toReturn[i] - '0') + (toAdd[j] - '0') + r);
            toReturn[i--] = (char)(x%2 + '0');
            r = (x > 1) ? 1 : 0;
        }

        if(r == 0) return new String(toReturn);

        while(i >= 0){
            int x = ((toReturn[i] - '0') + r);
            toReturn[i--] = (char)(x%2 + '0');

            if(x > 1) r = 1;
            else return new String(toReturn);
        }

        return "1" + new String(toReturn);
    }

    // Excel Sheet Column Title : LeetCode Problem 168
    // Mathematical - Easy
    public String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        addLetters(columnNumber - 1, s);
        return s.toString();
    }
    private StringBuilder addLetters(int cN, StringBuilder s){
        if(cN == -1) return s;
        addLetters(cN/26 - 1, s);
        s.append((char)(65 +(cN%26)));
        return s;
    }

    // Product array puzzle : GfG Problem
    // Mathematical - Easy
    public static long[] productExceptSelf(int nums[], int n) {
        long[] ans = new long[n];
        ans[0] = 1;
        long prod = 1;
        for(int i = 0; i < n-1; i++){
            prod *= nums[i];
            ans[i+1] = prod;
        }
        prod = 1;
        for(int i = n-1; i > 0; i--){
            prod *= nums[i];
            ans[i-1] *= prod;
        }
        return ans;
    }

    // Maximum Product of Three Numbers : LeetCode Problem 628
    // Mathematical - Easy
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = 1, p2 = 1;
        for(int i = 0; i < 2; i++){
            p1 *= nums[n-2-i];
            p2 *= nums[i];
        }
        p1 *= nums[n-1];
        p2 *= nums[n-1];
        return Math.max(p1, p2);
    }

    // Two Sum : LeetCode Problem 1
    // Arrays - Easy
    public int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]+nums[j-i]==target) return new int[]{j,j-i};
            }
        }
        return null;
    }

    // Merge Sorted Array : LeetCode Problem 88
    // Arrays - Easy
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;

        while(i>-1 && j>-1){
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while(i>-1){
            nums1[k--] = nums1[i--];
        }
        while(j>-1){
            nums1[k--] = nums2[j--];
        }
    }

    // Remove Duplicates from Sorted Array : LeetCode Problem 26
    // Arrays - Easy
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;

    }

    // Find All Duplicates in an Array : LeetCode Problem 442
    // Arrays - Medium
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            int idx = num - 1;
            if (nums[idx] < 0)
                result.add(num);
            nums[idx] *= -1;
        }
        return result;
    }

    // Move Zeroes : LeetCode Problem 283
    // Arrays - Easy
    public void moveZeroes(int[] nums) {
        if(nums.length < 2) return;

        int i = 0;
        int j = 0;

        while(i < nums.length){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
            i++;
        }
        while(j < nums.length){
            nums[j++] = 0;
        }
    }
}