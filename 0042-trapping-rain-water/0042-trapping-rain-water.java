class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lmax = height[left], rmax = height[right];
        int water = 0;

        while (left < right) {
            if (lmax < rmax) {
                left++;
                if (lmax < height[left]) {
                    lmax = height[left];
                } else {
                    water += (lmax - height[left]);
                }
            } else {
                right--;
                if (rmax < height[right]) {
                    rmax = height[right];
                } else {
                    water += (rmax - height[right]);
                }
            }
        }

        return water;
    }
}