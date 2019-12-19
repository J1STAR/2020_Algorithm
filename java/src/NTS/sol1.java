package NTS;

import java.util.Arrays;

public class sol1 {
    public static void main(String[] args) {
        System.out.println(solution(1, 2, 100000));
    }

    public static int solution(int a, int b, int budget) {
        int answer = 0;

        int money[] = {a, b};
        Arrays.sort(money);
        int[][] dp = new int[money.length][budget + 1];

        // 제일 작은 금액으로 거스를 수 있을 때, 1
        for (int i = 0; i <= budget; i++) {
            dp[0][i] = (i % money[0] == 0) ? 1 : 0;
        }

        // 금액으로 나눌 수 있을 때,
        for (int i = 1; i < money.length; i++) {

            // 목표 금액만큼 반복
            for (int j = 0; j <= budget; j++) {

                // 이전 돈의 가능한 수
                dp[i][j] = dp[i - 1][j];

                // 금액으로 나누었을 때, 최대 동전 수
                for (int coin = 1; coin <= j / money[i]; coin++) {

                    // 목표 금액 - 현재 동전 * 동전 수
                    // 현재 동전으로 거스름돈을 주었을 때, 나머지 거스름돈의 가능 수
                    dp[i][j] += dp[i - 1][j - money[i] * coin];
                }
            }
        }

//        for (int i = 0; i <= budget; i++) {
//            System.out.println(Arrays.toString(dp[0]));
//            System.out.println(Arrays.toString(dp[1]));
//            System.out.println();
//        }

        answer = dp[money.length - 1][budget];

        return answer;
    }
}
