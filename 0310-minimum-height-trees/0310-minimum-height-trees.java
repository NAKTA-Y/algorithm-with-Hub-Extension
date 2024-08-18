class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>(); 
            for (int leave : leaves) {
                int opposite = adj.get(leave).iterator().next();
                adj.get(opposite).remove(leave);

                if (adj.get(opposite).size() == 1) newLeaves.add(opposite);

                leaves = newLeaves;
            }
        }

        return leaves;
    }
}
