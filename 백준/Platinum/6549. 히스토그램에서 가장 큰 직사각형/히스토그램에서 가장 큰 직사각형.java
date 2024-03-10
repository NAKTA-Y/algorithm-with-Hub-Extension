import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Square {
    long height;
    int left;
    int right;

    public Square(long height, int left, int right) {
        this.height = height;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] line = reader.readLine().split(" ");
            if ("0".equals(line[0])) {
                break;
            }
            int n = Integer.parseInt(line[0]);
            Square[] squares = new Square[n];
            Stack<Square> stack = new Stack<>();
            long answer = 0;

            for (int i = 0; i < n; i++) {
                squares[i] = new Square(Long.parseLong(line[i+1]), 1, 1);
            }

            for (int i = n - 1; i >= 0; i--) {
                int count = 1;
                while (!stack.isEmpty() && squares[i].height <= stack.peek().height) {
                    count += stack.peek().left;
                    stack.pop();
                }

                squares[i].left = count;
                stack.push(squares[i]);
            }
            stack.clear();

            for (int i = 0; i < n; i++) {
                int count = 1;
                while (!stack.isEmpty() && squares[i].height <= stack.peek().height) {
                    count += stack.peek().right;
                    stack.pop();
                }

                squares[i].right = count;
                stack.push(squares[i]);
            }

            for (Square square : squares) {
                answer = Math.max(answer, (square.left + square.right - 1) * square.height);
            }

            System.out.println(answer);
        }
    }
}