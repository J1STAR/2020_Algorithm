package swea.sw7829;

import java.util.*;
import java.io.*;

public class 보물왕태혁_7829 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw7829/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int MAX_VALUE = 0;
            int MIN_VALUE = Integer.MAX_VALUE;

            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            if (N == 1) {
                sb.append((int) Math.pow(Integer.parseInt(st.nextToken()), 2));
            } else {
                for (int i = 0; i < N; i++) {
                    int current_value = Integer.parseInt(st.nextToken());

                    if (current_value < MIN_VALUE)
                        MIN_VALUE = current_value;

                    if (current_value > MAX_VALUE) {
                        MAX_VALUE = current_value;
                    }
                }

                sb.append(MIN_VALUE * MAX_VALUE);
            }

            bw.write(sb.toString());
            bw.newLine();
            sb.setLength(0);
        }
        bw.flush();
        bw.close();
    }
}
