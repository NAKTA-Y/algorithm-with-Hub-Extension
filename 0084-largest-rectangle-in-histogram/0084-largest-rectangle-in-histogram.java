class Tower {
    int value;
    int left;
    int right;

    Tower(int value, int left, int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Tower> stack = new ArrayDeque<>();
        int len = heights.length;
        Tower[] towers = new Tower[len];
        int result = 0;

        // migration
        for (int i = 0; i < len; i++) {
            towers[i] = new Tower(heights[i], 0, 0);
        }
        
        // left update
        for (int i = 0; i < len; i++) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek().value >= towers[i].value) {
                count += stack.pop().left + 1;
            }

            towers[i].left = count;
            stack.push(towers[i]);
        }

        stack.clear();

        // right update
        for (int i = len-1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && stack.peek().value >= towers[i].value) {
                count += stack.pop().right + 1;
            }

            towers[i].right = count;
            stack.push(towers[i]);
        }

        // calc result
        for (Tower tower : towers) {
            result = Math.max(result, (tower.left + tower.right + 1) * tower.value);
        }

        return result;
    }
}