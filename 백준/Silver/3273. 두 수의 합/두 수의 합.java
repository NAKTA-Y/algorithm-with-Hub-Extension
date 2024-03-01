import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int answer = 0;

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(numbers);

        int target = Integer.parseInt(br.readLine());

        int start = 0;
        int end = numbers.length-1;

        while (start < end) {
            int left = numbers[start];
            int right = numbers[end];

            if (left + right == target) {
                answer++;
                start++;
            } else if (left + right > target) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer);
    }
}