class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int count = 1;

        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return count;

                for (int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;

                        String str = String.valueOf(charArray);
                        if (set.contains(str) && !visited.contains(str)) {
                            visited.add(str);
                            queue.add(str);
                        }
                    }
                }
            }

            count++;
        }

        return 0;
    }
}