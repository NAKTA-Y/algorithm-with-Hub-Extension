class Solution {
    public int missingNumber(int[] nums) {
        int max = nums.length;
        int sum = max * (max + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}