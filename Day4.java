import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day4 {
    // Spiral Matrix : LeetCode Problem 54
    // Arrays - Medium
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int rstart = 0;
        int rend = matrix.length - 1;
        int cstart = 0;
        int cend = matrix[0].length - 1;
        while(true){
            //Column Start to Column End
            for(int i = cstart; i <= cend; i++){
                ans.add(matrix[rstart][i]);
            }
            rstart++;
            if(rstart > rend) break;

            //Row Start to Row End
            for(int i = rstart; i <= rend; i++){
                ans.add(matrix[i][cend]);
            }
            cend--;
            if(cstart > cend) break;

            //Column End to Column Start
            for(int i = cend; i >= cstart; i--){
                ans.add(matrix[rend][i]);
            }
            rend--;
            if(rstart > rend) break;

            //Row End to Row Start
            for(int i = rend; i >= rstart; i--){
                ans.add(matrix[i][cstart]);
            }
            cstart++;
            if(cstart > cend) break;
        }
        return ans;
    }

    // Majority Element : LeetCode Problem 169
    // Arrays - Easy
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
                count = 1;
            } else if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    // Jump Game : LeetCode Problem 55
    // Arrays - Medium
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int end = nums.length - 1;
        int ptr = nums.length - 2;
        while(ptr >= 0){
            if(end - ptr <= nums[ptr]){
                end = ptr;
                ptr--;
            }
            else ptr--;
        }

        return end == 0;
    }

    // Valid Parentheses : LeetCode Problem 20
    // String - Easy
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int top = -1;
        for (char c : chars){
            switch (c){
                case '(':
                case '[':
                case '{':
                    top++;
                    stack[top] = c;
                    break;
                case ')':
                    if (top == -1 || stack[top] != '('){
                        return false;
                    }
                    top--;
                    break;
                case ']':
                    if (top == -1 || stack[top] != '['){
                        return false;
                    }
                    top--;
                    break;
                case '}':
                    if (top == -1 || stack[top] != '{'){
                        return false;
                    }
                    top--;
                    break;
            }
        }
        return top == -1;
    }

    // Print all the duplicate characters in a string : GfG Article
    // String - Easy
    // https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

    // Find the Index of the First Occurrence in a String : LeetCode Problem 28
    // String - Easy
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Longest Common Prefix : LeetCode Problem 14
    // String - Easy
    public String longestCommonPrefix(String[] strs) {
        String shortword = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortword.length())
                shortword = strs[i];
        }
        boolean found = false;
        while (!shortword.isEmpty() && !found) {
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(shortword)) {
                    found = false;
                    break;
                }
                else found = true;
            }
            if(!found) shortword = shortword.substring(0, shortword.length() - 1);

        }
        if(found) return shortword;
        else return "";
    }

    // Reverse Words in a String : LeetCode Problem 151
    // String - Medium
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = arr.length-1; i >= 0; i--){
            if(!arr[i].equals("")){
                str.append(arr[i]);
                str.append(" ");
            }
        }
        return str.toString().trim();
    }

    // Simplify Path : LeetCode Problem 71
    // String - Medium
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> st = new Stack<>();
        for(String str : s){
            switch(str){
                case "", ".": break;
                case "..": if(!st.isEmpty()) st.pop(); break;
                default: st.push(str);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, "/" + st.pop());
        }
        return (ans.isEmpty()) ? "/" : ans.toString();
    }

    // Same Tree : LeetCode Problem 100
    // Tree - Easy
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;

        if(p.val == q.val) return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        else return false;
    }
}