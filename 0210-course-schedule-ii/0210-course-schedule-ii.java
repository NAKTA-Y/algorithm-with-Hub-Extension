class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        int[] degrees = new int[numCourses];
        int[] order = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> edges = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            edges.add(prerequisite[0]);
            graph.put(prerequisite[1], edges);
            degrees[prerequisite[0]]++;
        }

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            if (graph.containsKey(course)) {
                for (int canTakeCourse : graph.get(course)) {
                    degrees[canTakeCourse]--;
                    if (degrees[canTakeCourse] == 0) {
                        queue.add(canTakeCourse);
                    }
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}