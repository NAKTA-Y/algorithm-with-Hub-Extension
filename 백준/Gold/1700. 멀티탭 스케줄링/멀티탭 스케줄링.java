import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] useOrders = new int[k];
            Set<Integer> use = new HashSet<>();
            int answer = 0;

            for (int i = 0; i < k; i++) {
                useOrders[i] = sc.nextInt();
            }

            int useCount = 0;
            for (int i = 0; i < k; i++) {
                // 이미 멀티탭에 있는 경우
                if (use.contains(useOrders[i])) {
                    continue;
                }

                if (useCount < n) { // 멀티탭 자리가 남았을 경우
                    use.add(useOrders[i]);
                    useCount++;
                } else { // 멀티탭 자리가 없을 경우
                    boolean[] afterUse = new boolean[k+1];
                    int lastUsed = -1;
                    int afterUseCount = 0;



                    // 이후에 사용될 물건 체킹
                    for (int j = i; j < useOrders.length; j++) {
                        int afterUseStuff = useOrders[j];
                        if (use.contains(afterUseStuff) && !afterUse[afterUseStuff]) {
                            afterUse[afterUseStuff] = true;
                            lastUsed = afterUseStuff;
                            afterUseCount++;
                        }
                    }

                    if (afterUseCount < use.size()) { // 이후에 사용이 되지 않는 물건이 있을 경우
                        for (Integer stuff : use) {
                            if (!afterUse[stuff]) {
                                use.remove(stuff);
                                break;
                            }
                        }
                    } else { // 모든 물건이 이후에 다시 사용될 경우
                        use.remove(lastUsed);
                    }

                    answer++;
                    use.add(useOrders[i]);
                }
            }

            System.out.println(answer);
        }
    }
}