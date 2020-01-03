package swea.sw9088;

import java.util.*;
import java.io.*;

public class 다이아몬드_9088 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw9088/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            int[] diamond_bag = new int[10001];

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                int size = Integer.parseInt(br.readLine());
                diamond_bag[size]++;
            }

            for (int i = 1; i <= 10000 - K; i++) {
                int total = 0;
                for (int j = 0; j <= K; j++) {
                    total += diamond_bag[i + j];
                }

                if (answer < total) {
                    answer = total;
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer);
            bw.write(sb.toString());
            bw.newLine();
            sb.setLength(0);
        }
        bw.flush();
        bw.close();
    }
}
