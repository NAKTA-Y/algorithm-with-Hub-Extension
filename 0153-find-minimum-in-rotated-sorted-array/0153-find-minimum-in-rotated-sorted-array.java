class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer num : nums) minHeap.add(num);
        return minHeap.poll();
    }
}