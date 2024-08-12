class NumArray {
    private int[] cumulative;

    public NumArray(int[] nums) {        
        int len = nums.length;
        int[] cumulative = new int[len+1];
        
        for (int i = 1; i <= len; i++) {
            cumulative[i] = cumulative[i-1] + nums[i-1];
        }

        this.cumulative = cumulative;
    }
    
    public int sumRange(int left, int right) {
        return cumulative[right+1] - cumulative[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */