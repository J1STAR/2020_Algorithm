package swea.sw9236_NotSolve;

import java.util.*;
import java.io.*;

public class 곰돌이_9236 {

    static char[][] map;

    static Queue<int[]> bear_queue;
    static Queue<int[]> bee_queue;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw9236_NotSolve/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = -1;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int eating_time = 0;
            bfs:
            while (eating_time < N * 2 - 2) {
                char[][] copy_map = deepCopy(map, N);
                queueInit(copy_map);
                for (int i = 0; i < N * 2 - 2; i++) {
                    if (i >= eating_time) {
                        for (int k = 0; k < S; k++) {
                            if (moveBear(copy_map, N)) {
                                answer = eating_time;
                                eating_time++;
                                continue bfs;
                            }
                        }
                    }

                    int bee_q_size = bee_queue.size();
                    for (int j = 0; j < bee_q_size; j++) {
                        moveBee(copy_map, N);
                    }
                }

                eating_time++;
            }


            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static char[][] deepCopy(char[][] original, int N) {
        if (original == null) {
            return null;
        }

        char[][] result = new char[N][N];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

    public static boolean routeCheck(int i, int j, int N) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    public static boolean moveBear(char[][] map, int N) {
        int bear_q_size = bear_queue.size();
        for (int bq = 0; bq < bear_q_size; bq++) {
            int[] current_bear = bear_queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] next_bear = new int[2];
                next_bear[0] = current_bear[0] + di[i];
                next_bear[1] = current_bear[1] + dj[i];

                if (routeCheck(next_bear[0], next_bear[1], N)) {
                    if (map[next_bear[0]][next_bear[1]] == 'D') {
                        return true;
                    }

                    if (map[next_bear[0]][next_bear[1]] == 'G') {
                        map[next_bear[0]][next_bear[1]] = 'B';
                        bear_queue.offer(new int[]{next_bear[0], next_bear[1]});
                    }
                }
            }
        }

        return false;
    }

    public static void moveBee(char[][] map, int N) {
        int[] current_bee = bee_queue.poll();
        for (int i = 0; i < 4; i++) {
            int[] next_bee = new int[2];
            next_bee[0] = current_bee[0] + di[i];
            next_bee[1] = current_bee[1] + dj[i];

            if (routeCheck(next_bee[0], next_bee[1], N)) {
                if (map[next_bee[0]][next_bee[1]] == 'G' || map[next_bee[0]][next_bee[1]] == 'M' || map[next_bee[0]][next_bee[1]] == 'B') {
                    map[next_bee[0]][next_bee[1]] = 'H';
                    bee_queue.offer(new int[]{next_bee[0], next_bee[1]});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    public static void queueInit(char[][] map) {
        bear_queue = new LinkedList<>();
        bee_queue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 'M') {
                    bear_queue.offer(new int[]{i, j});
                }

                if (map[i][j] == 'H') {
                    bee_queue.offer(new int[]{i, j});
                }
            }
        }
    }
}
