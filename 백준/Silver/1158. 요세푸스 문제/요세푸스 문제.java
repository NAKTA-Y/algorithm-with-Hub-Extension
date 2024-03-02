import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        Queue<Integer> peoples = new LinkedList<>();
        for (int i = 1; i <= n; i++) peoples.add(i);
        StringBuilder result = new StringBuilder();
        result.append("<");

        while (peoples.size() != 1) {
            for (int i = 0; i < k-1; i++) {
                Integer people = peoples.poll();
                peoples.add(people);
            }
            result.append(peoples.poll()).append(", ");
        }

        result.append(peoples.poll()).append(">");
        System.out.println(result);
    }
}