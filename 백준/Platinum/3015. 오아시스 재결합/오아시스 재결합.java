import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person {
    long height;
    long duplicated;

    public Person(long height, long duplicated) {
        this.height = height;
        this.duplicated = duplicated;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long answer = 0;
        Person[] person = new Person[n];
        Stack<Person> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            person[i] = new Person(Integer.parseInt(reader.readLine()), 0);
        }

        stack.push(person[person.length-1]);

        for (int i = person.length-2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().height <= person[i].height) {
                if (person[i].height == stack.peek().height) {
                    person[i].duplicated = stack.peek().duplicated + 1;
                }
                answer += stack.peek().duplicated + 1;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(person[i]);
        }

        System.out.println(answer);
    }
}