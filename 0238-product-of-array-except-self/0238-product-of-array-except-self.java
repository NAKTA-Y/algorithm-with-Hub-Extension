class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);

        int current = 1;
        for (int i = 0; i < len; i++) {
            result[i] *= current;
            current *= nums[i];
        }

        current = 1;
        for (int i = len-1; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }

        return result;
    }
}