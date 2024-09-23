import java.util.*;

class Solution {
    static HashMap<String, Integer>[] cntOfMenuNumbers;
    static boolean[] visited = new boolean[20];

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        // 해시맵 init
        cntOfMenuNumbers = new HashMap[course.length];
        for (int i = 0; i < cntOfMenuNumbers.length; i++) {
            cntOfMenuNumbers[i] = new HashMap<>();
        }

        // 메뉴들을 정렬해서 다시 저장
        for (int i = 0; i < orders.length; i++) {
            orders[i] = orders[i].chars()
                                 .sorted()
                                 .collect(StringBuilder::new,
                                          StringBuilder::appendCodePoint,
                                          StringBuilder::append)
                                 .toString();
        }

        // 메뉴의 모든 조합에 대해서 메뉴 길이 당 카운트 값들을 저장
        for (int i = 0; i < course.length; i++) {
            for (String order : orders) {
                // 방문 여부 배열 초기화
                initVisitedArray();

                if (course[i] <= order.length()) {

                    addNumberOfMenus(course[i], order, "", 0, cntOfMenuNumbers[i]);
                }
            }
        }

        // 각 해시맵 마다 탐색
        for (HashMap<String, Integer> cntOfMenuNumber : cntOfMenuNumbers) {
            int maxCnt = 0;
            // 값 기준으로 내림차순 정렬
            List<Map.Entry<String,Integer>> descSorted = descSortByValue(cntOfMenuNumber);

            for (Map.Entry<String, Integer> entry : descSorted) {
                if (maxCnt == 0 && entry.getValue() >= 2) {
                    maxCnt = entry.getValue();
                } else if (maxCnt != entry.getValue()){
                    break;
                }

                answer.add(entry.getKey());
            }
        }

        // 메뉴들을 오름차순으로 정렬
        Collections.sort(answer);

        return answer.stream().toArray(String[]::new);
    }

    static void initVisitedArray() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    static void addNumberOfMenus(int numOfMenus, String order, String currentOrder, int start, HashMap<String, Integer> menuCnt) {
        if (currentOrder.length() == numOfMenus) {
            menuCnt.put(currentOrder, menuCnt.getOrDefault(currentOrder, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                addNumberOfMenus(numOfMenus, order, currentOrder + order.charAt(i), i+1, menuCnt);
                visited[i] = false;
            }
        }
    }

    static List<Map.Entry<String,Integer>> descSortByValue(HashMap<String, Integer> menuCnt) {
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(menuCnt.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
    }

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders, course);

        for (String s : result) {
            System.out.println(s);
        }
    }
}