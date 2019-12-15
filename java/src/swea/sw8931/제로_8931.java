package swea.sw8931;

import java.io.*;
import java.util.*;

public class 제로_8931 {
    static Stack<Integer> moneyStack = new Stack<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw8931/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T ; test_case++) {
            int K = Integer.parseInt(br.readLine());

            for (int i = 0; i < K; i++) {
                int money = Integer.parseInt(br.readLine());

                if (money == 0 && moneyStack.size() != 0) {
                    moneyStack.pop();
                } else {
                    moneyStack.push(money);
                }
            }
            int answer = 0;
            for (int money:
                 moneyStack) {
                answer += money;
            }
            moneyStack.clear();

            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
