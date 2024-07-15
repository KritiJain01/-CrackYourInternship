public class Day1 {
    // Find the Duplicate Number : LeetCode Problem 287
    // Arrays - Medium
    public int findDuplicate(int[] nums) {
        boolean[] saved = new boolean[nums.length + 1];

        for (int num : nums) {
            if (saved[num]) {
                return num;
            } else {
                saved[num] = true;
            }
        }

        return -1;
    }

    // Sort Colors : LeetCode Problem 75
    // Arrays - Medium
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for(int i = 0; i <= two;){
            if(nums[i] == 0 && i != zero){
                int t = nums[zero];
                nums[zero++] = 0;
                nums[i] = t;
            }
            else if(nums[i] == 2 && i != two){
                int t = nums[two];
                nums[two--] = 2;
                nums[i] = t;
            }
            else i++;
        }
    }
}