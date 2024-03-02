import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main (String[] args) throws IOException {
        LinkedList<Character> characters = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] splitLine = reader.readLine().toCharArray();

        for (char c : splitLine) characters.add(c);
        ListIterator<Character> cursor = characters.listIterator(characters.size());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String commandLine = reader.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'L':
                    if (cursor.hasPrevious()) cursor.previous(); break;
                case 'D':
                    if (cursor.hasNext()) cursor.next(); break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    Character c = commandLine.charAt(2);
                    cursor.add(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : characters)
            builder.append(c);
        System.out.println(builder);
    }
}