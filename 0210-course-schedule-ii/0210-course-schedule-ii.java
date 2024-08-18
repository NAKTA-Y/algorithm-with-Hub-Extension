class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        int[] degrees = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> order = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> edges = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            edges.add(prerequisite[0]);
            graph.put(prerequisite[1], edges);
            degrees[prerequisite[0]]++;
        }

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                order.add(i);
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (graph.containsKey(course)) {
                for (int canTakeCourse : graph.get(course)) {
                    degrees[canTakeCourse]--;
                    if (degrees[canTakeCourse] == 0) {
                        order.add(canTakeCourse);
                        queue.add(canTakeCourse);
                    }
                }
            }
        }

        if (order.size() == numCourses)
            return order.stream().mapToInt(Integer::intValue).toArray();
        else
            return new int[]{};
    }
}