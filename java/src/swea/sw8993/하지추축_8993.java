package swea.sw8993;

import java.util.*;
import java.io.*;

public class 하지추축_8993 {
    static Set<Long> setNum = new HashSet();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw8993/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            long N = Long.parseLong(br.readLine());

            if (recursive(N))
                bw.write("#" + test_case + " YES");
            else
                bw.write("#" + test_case + " NO");

            bw.newLine();

            setNum.clear();
        }

        bw.flush();
        bw.close();
    }

    public static boolean recursive(long N) {
        if (setNum.contains(N)) {
            return false;
        }

        if (N == 1) {
            return true;
        } else {
            if (N % 2 == 0) {
                setNum.add(N);
                return recursive(N / 2);
            } else {
                setNum.add(N);
                return recursive(N * 3 + 3);
            }
        }
    }
}
