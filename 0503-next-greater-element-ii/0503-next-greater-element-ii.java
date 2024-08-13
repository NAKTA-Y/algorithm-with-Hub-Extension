class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] answer = new int[len];

        int index = len-1;
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[index]) stack.pop();

            if (!stack.isEmpty() && !map.containsKey(nums[index])) {
                answer[index] = stack.peek();
            } else {
                answer[index] = -1;
            }

            stack.push(nums[index]);

            index = index == 0 ? len-1 : index-1;
        }

        return answer;
    }
}