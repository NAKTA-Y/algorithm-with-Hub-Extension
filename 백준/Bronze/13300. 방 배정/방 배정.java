import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
            
        String[] countAndCapacity = br.readLine().split(" ");
        int n = Integer.parseInt(countAndCapacity[0]);
        int capacity = Integer.parseInt(countAndCapacity[1]);
        
        int[] manRooms = new int[7];
        int[] girlRooms = new int[7];
        
        for (int i = 0; i < n; i++) {
            String[] gradeAndCount = br.readLine().split(" ");
            int gender = Integer.parseInt(gradeAndCount[0]);
            int grade = Integer.parseInt(gradeAndCount[1]);
            
            if (gender == 0) {
                manRooms[grade]++; 
            } else {
                girlRooms[grade]++;
            }
        }
        
        for (int i = 1; i < 7; i++) {
            answer += (int) Math.ceil(manRooms[i] / 2.0);
            answer += (int) Math.ceil(girlRooms[i] / 2.0);
        }
        
        System.out.println(answer);
    }
}