class Solution {
    public void moveZeroes(int[] nums) {
        int snowBall = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && snowBall > 0) {
                int temp = nums[i - snowBall];
                nums[i - snowBall] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == 0) {
                snowBall++;
            }
        }
    }
}