import java.util.*;

class Word {
    String word;
    int depth;

    public Word(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}

class Solution {
    static boolean[] visited;
    static Queue<Word> queue = new LinkedList<>();
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];

        queue.add(new Word(begin, 0));

        answer = bfs(words, target);

        return answer;
    }

    public static int bfs(String[] words, String target) {
        while(!queue.isEmpty()) {
            Word source = queue.poll();

            if (source.word.equals(target)) {
                return source.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isPossibleChange(source.word, words[i])) {
                    queue.add(new Word(words[i], source.depth+1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    public static boolean isPossibleChange(String source, String target) {
        int answer = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i))
                answer++;
        }

        return answer == 1;
    }
}