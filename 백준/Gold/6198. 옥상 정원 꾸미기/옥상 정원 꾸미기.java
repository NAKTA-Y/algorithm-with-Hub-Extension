import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Building {
    int height;
    int index;

    public Building(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Building[] buildings = new Building[n];
        long[] answer = new long[n];
        Stack<Building> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            buildings[i] = new Building(Integer.parseInt(reader.readLine()), i);
        }

        for (int i = buildings.length-1; i >= 0; i--) {
            long distance = 0;
            while (!stack.isEmpty() && stack.peek().height < buildings[i].height) {
                distance += 1 + answer[stack.peek().index];
                stack.pop();
            }
            answer[i] = distance;
            stack.push(buildings[i]);
        }

        long sum = Arrays.stream(answer).sum();
        System.out.println(sum);
    }
}