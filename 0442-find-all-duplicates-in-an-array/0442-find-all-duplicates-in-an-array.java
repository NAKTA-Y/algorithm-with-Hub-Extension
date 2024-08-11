class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            if (nums[index-1] < 0) {
                result.add(index);
            } else {
                nums[index-1] *= -1;
            }
        }

        return result;
    }
}