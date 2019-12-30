package baekjoon.bj3047;

import java.util.*;
import java.io.*;

public class ABC_3047 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/baekjoon/bj3047/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num_arr = new int[3];
        for (int i = 0; i < 3; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num_arr);

        String encode_num = br.readLine();
        sb.append(num_arr[encode_num.charAt(0) - 'A']);
        sb.append(' ');
        sb.append(num_arr[encode_num.charAt(1) - 'A']);
        sb.append(' ');
        sb.append(num_arr[encode_num.charAt(2) - 'A']);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
