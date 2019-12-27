package swea.sw1861;

import java.util.*;
import java.io.*;

public class 정사각형방_1861 {

    static int[][] map;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {-1, 0, 1, 0};

    static int T;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw1861/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int room_num = Integer.MAX_VALUE;
            int move_count = 0;

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    int current_room_num = map[j][i];
                    int current_count = findPath(j, i);
                    if (move_count < current_count) {
                        room_num = current_room_num;
                        move_count = current_count;
                    } else if (move_count == current_count) {
                        if (room_num > current_room_num) {
                            room_num = current_room_num;
                        }
                    }
                }
            }

            bw.write("#" + test_case + " " + room_num + " " + move_count);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static int findPath(int j, int i) {
        for (int k = 0; k < 4; k++) {
            int next = map[j][i] + 1;

            if (0 <= j + dj[k] && j + dj[k] < N && 0 <= i + di[k] && i + di[k] < N) {
                if (next == map[j + dj[k]][i + di[k]]) {
                    return 1 + findPath(j + dj[k], i + di[k]);
                }
            }
        }

        return 1;
    }
}
