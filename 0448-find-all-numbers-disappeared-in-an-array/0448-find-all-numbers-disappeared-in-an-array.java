class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index-1] > 0)
                nums[index-1] *= -1;
        }

        return IntStream.range(0, nums.length)
                .filter(idx -> nums[idx] > 0)
                .map(idx -> idx + 1).boxed()
                .toList();
    }
}