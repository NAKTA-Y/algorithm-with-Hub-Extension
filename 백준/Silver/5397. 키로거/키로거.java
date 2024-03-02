import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            LinkedList<Character> password = new LinkedList<>();
            char[] inputs = reader.readLine().toCharArray();
            ListIterator<Character> cursor = password.listIterator(password.size());

            for (char input : inputs) {
                switch (input) {
                    case '<':
                        if (cursor.hasPrevious()) cursor.previous(); break;
                    case '>':
                        if (cursor.hasNext()) cursor.next(); break;
                    case '-':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(input);
                }
            }

            StringBuilder builder = new StringBuilder();
            for (char c : password) builder.append(c);
            System.out.println(builder);
        }
    }
}