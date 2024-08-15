class StockSpanner {
    Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();    
    }
    
    public int next(int price) {
        int greater = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            greater += stack.pop()[1];
        }

        stack.push(new int[]{price, greater});

        return greater;
    }
}