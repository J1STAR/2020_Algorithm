package swea.sw4111;

import java.util.*;
import java.io.*;

public class 무선단속카메라_4111 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw4111/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int remote_camera_amount = Integer.parseInt(br.readLine());
            int signal_receiver_amount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if (remote_camera_amount <= signal_receiver_amount) {
                bw.write("#" + test_case + " " + 0);
                bw.newLine();
                continue;
            }

            int[] camera_set = new int[remote_camera_amount];
            for (int i = 0; i < remote_camera_amount; i++) {
                camera_set[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(camera_set);

            int[] distance_set = new int[remote_camera_amount - 1];
            for (int i = 0; i < distance_set.length; i++) {
                distance_set[i] = camera_set[i + 1] - camera_set[i];
            }
            Arrays.sort(distance_set);

            int answer = 0;
            for (int i = 0; i < remote_camera_amount - signal_receiver_amount; i++) {
                answer += distance_set[i];
            }

            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
