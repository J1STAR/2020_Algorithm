package swea.sw1940;

import java.io.*;
import java.util.StringTokenizer;

public class 가랏RC카_1940 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw1940/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int speed = 0;
            int distance = 0;

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());

                int acceleration = 0;
                if (st.hasMoreTokens()) acceleration = Integer.parseInt(st.nextToken());

                if (command == 1) speed += acceleration;
                else if (command == 2) speed -= acceleration;

                if (speed < 0) speed = 0;

                distance += speed;
            }

            bw.write("#" + test_case + " " + distance);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
