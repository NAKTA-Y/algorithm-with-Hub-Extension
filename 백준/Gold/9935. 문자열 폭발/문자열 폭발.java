import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] line = reader.readLine().toCharArray();
        char[] bomb = reader.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        for (char c : line) {
            deque.addLast(c);
            if (c == bomb[bomb.length-1]) matchProcess(bomb, deque);
        }

        if (deque.isEmpty()) {
            System.out.println("FRULA");
        } else {
            while(!deque.isEmpty()) answer.append(deque.pollFirst());
            System.out.println(answer);
        }

        reader.close();
    }

    private static void matchProcess(char[] bomb, Deque<Character> deque) {
        Stack<Character> temp = new Stack<>();
        if (deque.size() < bomb.length) return;

        for (int i = bomb.length-1; i >= 0; i--) {
            temp.add(deque.pollLast());
            if (bomb[i] != temp.peek()) {
                while (!temp.isEmpty()) deque.addLast(temp.pop());
                return;
            }
        }
    }
}