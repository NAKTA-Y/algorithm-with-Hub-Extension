class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int size = wordList.size();

        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word, new ArrayList<>());
        }

        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                String source = wordList.get(i);
                String target = wordList.get(j);
                if (canTransformByOneChar(source, target)) {
                    wordMap.get(source).add(target);
                    wordMap.get(target).add(source);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        int count = 1;

        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int queuesize = queue.size();

            for (int i = 0; i < queuesize; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return count;

                List<String> possibleWords = wordMap.get(word);
                for (String possibleWord : possibleWords) {
                    if (visited.contains(possibleWord)) continue;
                    visited.add(possibleWord);
                    queue.add(possibleWord);
                }
            }

            count++;
        }

        return 0;
    }

    private boolean canTransformByOneChar(String source, String target) {
        int count = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) count++;
        }

        return count == 1;
    }
}