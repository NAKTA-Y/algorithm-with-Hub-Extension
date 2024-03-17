import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

interface DirectionAction {
    int perform(int position);
}

class Subin {
    int position;
    int moveCount;

    public Subin(int position, int moveCount) {
        this.position = position;
        this.moveCount = moveCount;
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] positionLine = reader.readLine().split(" ");
        int subinPosition = Integer.parseInt(positionLine[0]);
        int brotherPosition = Integer.parseInt(positionLine[1]);
        int answer = 0;

        Queue<Subin> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        DirectionAction[] actions = {
                (position) -> position + 1,
                (position) -> position - 1,
                (position) -> position * 2
        };

        queue.add(new Subin(subinPosition, 0));
        while (!queue.isEmpty()) {
            Subin subin = queue.poll();

            if (subin.position == brotherPosition) {
                answer = subin.moveCount;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int movedPosition = actions[i].perform(subin.position);

                if (movedPosition < 0 || movedPosition > 100000) continue;
                if (visited[movedPosition]) continue;

                queue.add(new Subin(movedPosition, subin.moveCount+1));
                visited[movedPosition] = true;
            }
        }

        System.out.println(answer);
    }
}