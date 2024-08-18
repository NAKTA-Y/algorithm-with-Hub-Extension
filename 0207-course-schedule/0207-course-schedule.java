class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        List<Integer>[] graph = new ArrayList[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
            degree[prerequisite[1]]++;
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int shouldFinishedCourse : graph[course]) {
                degree[shouldFinishedCourse]--;
                if (degree[shouldFinishedCourse] == 0) {
                    count++;
                    queue.add(shouldFinishedCourse);
                }
            }
        }

        return count == numCourses;
    }
}