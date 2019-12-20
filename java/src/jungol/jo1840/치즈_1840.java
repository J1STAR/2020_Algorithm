package jungol.jo1840;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_1840 {

    private static int[][] map;
    private static int col;
    private static int row;

    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static Queue<int[]> q = new LinkedList<>();

    private static int count;
    private static int cheese;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/jungol/jo1840/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            map = new int[col][row];

            for (int i = 0; i < col; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < row; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            while (isExist()) {
                q.offer(new int[]{0, 0});
                map[0][0] = count--;
                while (!q.isEmpty()) {
                    int[] curr = q.poll();

                    for (int i = 0; i < 4; i++) {
                        int ii = curr[0] + di[i];
                        int jj = curr[1] + dj[i];

                        if (ii < 0 || ii >= col || jj < 0 || jj >= row) {
                            continue;
                        }

                        if (map[ii][jj] == count + 1 || map[ii][jj] == 0) {
                            q.offer(new int[]{ii, jj});
                            map[ii][jj] = count;
                        } else if (map[ii][jj] == 1) {
                            map[ii][jj] = count;
                        }

                    }
                }
            }

            bw.write("#" + test_case + " " + (-1 * count) + " " + cheese);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static boolean isExist() {
        boolean exist = false;

        int c = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] == 1) {
                    c++;
                    exist = true;
                }
            }
        }

        if (exist) {
            cheese = c;
        }

        return exist;
    }
}

