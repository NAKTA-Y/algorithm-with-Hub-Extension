import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] alphabets = new int[26];
            String[] strings = br.readLine().split(" ");
            String before = strings[0];
            String after = strings[1];

            char[] splitBefore = before.toCharArray();
            for (char c : splitBefore) {
                alphabets[c - 'a']++;
            }

            decreaseCount(alphabets, after);

            if (isPossible(alphabets)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    private static void decreaseCount(int[] alphabets, String after) {
        char[] splitAfter = after.toCharArray();

        for (char c : splitAfter) {
            alphabets[c - 'a']--;
        }
    }

    private static boolean isPossible(int[] alphabats) {
        for (int count : alphabats) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}