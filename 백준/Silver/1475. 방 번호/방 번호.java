import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;

        String number = br.readLine();
        char[] numbers = number.toCharArray();
        int[] count = new int[10];

        for (char n : numbers) {
            count[n -'0']++;
        }

        count[6] = (int) Math.ceil(((double)(count[6] + count[9]) / 2.0));
        count[9] = count[6];

        for (int c : count) {
            answer = Math.max(answer, c);
        }

        System.out.println(answer);
    }
}