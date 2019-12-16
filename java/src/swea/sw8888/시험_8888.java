package swea.sw8888;

import java.io.*;
import java.util.*;

public class 시험_8888 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/sw8888/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int Tc = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= Tc; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            Participant[] participants = new Participant[N];
            int[] scores = new int[T];

            for (int pIndex = 0; pIndex < N; pIndex++) {
                st = new StringTokenizer(br.readLine());

                participants[pIndex] = new Participant();
                participants[pIndex].num = pIndex + 1;
                participants[pIndex].scores = new int[T + 2];

                int solving = 0;
                for (int scoreIndex = 0; scoreIndex < T; scoreIndex++) {
                    int solve = Integer.parseInt(st.nextToken());

                    if (solve != 0) {
                        participants[pIndex].scores[scoreIndex] = 1;
                        solving++;
                    } else {
                        scores[scoreIndex]++;
                    }
                }

                participants[pIndex].scores[T] = solving;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    if (participants[i].scores[j] == 1) {
                        participants[i].scores[T + 1] += scores[j];
                    }
                }
            }
            Comparator<Participant> participantComparator = new Comparator<Participant>() {
                @Override
                public int compare(Participant o1, Participant o2) {
                    if (o1.scores[T + 1] < o2.scores[T + 1]) {
                        return 1;
                    } else if (o1.scores[T + 1] == o2.scores[T + 1]) {
                        if (o1.scores[T] < o2.scores[T]) {
                            return 1;
                        } else if (o1.scores[T] == o2.scores[T]) {
                            if (o1.num < o2.num) {
                                return -1;
                            } else if (o1.num == o2.num) {
                                return 0;
                            } else
                                return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            };

            Arrays.sort(participants, participantComparator);
            for (Participant p :
                    participants) {
                System.out.println(p);
            }
            for (int i = 0; i < N; i++) {
                if (participants[i].num == P) {
                    bw.write("#" + test_case + " " + participants[i].scores[T + 1] + " " + (i + 1));
                    break;
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

class Participant {
    int num;
    int[] scores;

    @Override
    public String toString() {
        return "Participant{" +
                "num=" + num +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}