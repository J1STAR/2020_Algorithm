package swea.sw2117;

import java.util.*;
import java.io.*;

public class 홈방범서비스_2117 {

    static ArrayList<Home> homeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea2117/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    if (st.nextToken().equals("1")) {
                        homeList.add(new Home(x, y));
                    }
                }
            }

            int answer = 0;
            int profit;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    for (int size = 0; size < N + 1; size++) {
                        int count = 0;
                        for (Home h:
                             homeList) {
                            if (h.getDistance(x, y) <= size) {
                                count++;
                            }
                        }

                        profit = count * M - calcCost(size + 1);
                        if (profit >= 0 && answer <= count) {
                            answer = count;
                        }
                    }
                }
            }

            homeList.clear();
            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Home {
        int posX;
        int posY;

        Home(int x, int y) {
            this.posX = x;
            this.posY = y;
        }

        public int getDistance(int centerX, int centerY) {
            return Math.abs(this.posX - centerX) + Math.abs(this.posY - centerY);
        }

        @Override
        public String toString() {
            return "Home{" +
                    "posX=" + posX +
                    ", posY=" + posY +
                    '}';
        }
    }

    public static int calcCost(int K) {
        return (int) (Math.pow(K, 2) + Math.pow(K - 1, 2));
    }
}
