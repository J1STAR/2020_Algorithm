package swea.sw3462;

import java.util.*;
import java.io.*;

public class 선표의축구경기예측_3462 {

    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    static int[] prime_numbers = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw3462/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            double answer = 0;

            st = new StringTokenizer(br.readLine());

            double percentage_a = Integer.parseInt(st.nextToken()) / 100.0;
            double percentage_b = Integer.parseInt(st.nextToken()) / 100.0;
            double percentage_goal_a = 0;
            double percentage_goal_b = 0;

            double combination = 1;
            for (int i = 1; i <= 30; i++) {
                combination *= (double) (31 - i) / i;
                if (prime_numbers[i] == 1) {
                    percentage_goal_a += combination * Math.pow(percentage_a, i) * Math.pow(1 - percentage_a, 30 - i);
                    percentage_goal_b += combination * Math.pow(percentage_b, i) * Math.pow(1 - percentage_b, 30 - i);
                }
            }
            answer = 1 - (1 - percentage_goal_a) * (1 - percentage_goal_b);

            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(String.format("%.5f", answer));
            bw.write(sb.toString());
            sb.setLength(0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
