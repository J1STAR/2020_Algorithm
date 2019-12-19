package baekjoon.bj14502;

import java.io.*;
import java.util.*;

public class 연구소_14502 {

    private static int[][] labo;

    private static int N;
    private static int M;

    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static int answer = 0;

    private static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/baekjoon/bj14502/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            labo = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    labo[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (labo[i][j] == 0) {
                        labo[i][j] = -1;
                        buildWall(1);
                        labo[i][j] = 0;
                    }
                }
            }

            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(answer);
            sb.append("\n");
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    private static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (labo[i][j] == 0) {
                    labo[i][j] = -1;
                    buildWall(count + 1);
                    labo[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (labo[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] virusMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            virusMap[i] = Arrays.copyOf(labo[i], labo[i].length);
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int ii = curr[0] + di[i];
                int jj = curr[1] + dj[i];

                if (ii < 0 || ii >= N || jj < 0 || jj >= M) {
                    continue;
                }

                if (virusMap[ii][jj] == 0) {
                    virusMap[ii][jj] = 2;
                    q.offer(new int[]{ii, jj});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        if (answer < count) {
            answer = count;
        }
    }
}
