import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Tower {
    int height;
    int index;

    public Tower(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] line = reader.readLine().split(" ");
        Tower[] towers = new Tower[line.length];
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < line.length; i++) {
            towers[i] = new Tower(Integer.parseInt(line[i]), i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("0").append(" ");
        stack.push(towers[0]);

        for (int i = 1; i < towers.length; i++) {
            while (!stack.isEmpty() && stack.peek().height < towers[i].height) {
                stack.pop();
            }

            if (stack.isEmpty()) answer.append("0").append(" ");
            else answer.append(stack.peek().index+1).append(" ");

            stack.push(towers[i]);
        }

        System.out.println(answer);
        reader.close();
    }
}