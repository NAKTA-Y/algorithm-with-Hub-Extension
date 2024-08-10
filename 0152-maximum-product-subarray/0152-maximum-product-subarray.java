class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        double l=1, r=1;
        double answer = nums[0];

        for (int i = 0, j = len-1; i < len; i++, j--) {
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];
            r *= nums[j];

            answer = Math.max(answer, Math.max(l, r));
        }

        return (int)answer;
    }
}