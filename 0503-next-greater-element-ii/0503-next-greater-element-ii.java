class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;

        for (int i = len-1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for (int i = len-1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        return nums;
    }
}