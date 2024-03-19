import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int x;
    int count;

    public Position(int x, int count) {
        this.x = x;
        this.count = count;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int floors = Integer.parseInt(info[0]);
        int start = Integer.parseInt(info[1]);
        int target = Integer.parseInt(info[2]);
        int up = Integer.parseInt(info[3]);
        int down = Integer.parseInt(info[4]);

        int answer = bfs(floors, start, target, up, down);
        if (answer < 0)
            System.out.println("use the stairs");
        else
            System.out.println(answer);
    }

    private static int bfs(int floors, int start, int target, int up, int down) {
        int[] directions = {up, -down};
        Queue<Position> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int answer = -1;

        queue.add(new Position(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;

            if (x == target) {
                return position.count;
            }

            for (int i = 0; i < 2; i++) {
                int dx = x + directions[i];

                if (dx > floors || dx < 1) continue;
                if (visited.contains(dx)) continue;

                visited.add(dx);
                queue.add(new Position(dx, position.count+1));
            }
        }

        return answer;
    }
}