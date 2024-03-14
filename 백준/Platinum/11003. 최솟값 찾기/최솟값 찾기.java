import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Element {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        String[] secondLine = reader.readLine().split(" ");
        Deque<Element> deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(firstLine[0]);
        int l = Integer.parseInt(firstLine[1]);
        Element[] elements = new Element[n];
        for (int i = 0; i < secondLine.length; i++) {
            elements[i] = new Element(Integer.parseInt(secondLine[i]), i);
        }

        for (int index = 0; index < n; index++) {
            while (!deque.isEmpty() && deque.peekLast().value > elements[index].value) {
                deque.pollLast();
            }

            deque.add(elements[index]);

            if (index - deque.peekFirst().index >= l) {
                deque.pollFirst();
            }

            answer.append(deque.peekFirst().value).append(" ");
        }

        reader.close();
        System.out.println(answer);
    }
}