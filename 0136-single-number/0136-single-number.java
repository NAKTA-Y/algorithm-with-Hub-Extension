class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int xor = sum;
        for (int num : nums) xor ^= num;

        return sum ^ xor;
    }
}