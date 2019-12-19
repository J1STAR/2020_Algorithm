package NTS;

import java.util.HashSet;
import java.util.Set;

public class sol2 {
    public static void main(String[] args) {
        System.out.println(solution(2130));
    }

    public static int solution(long n) {
        int answer = 0;

        String num = Long.toString(n);
        Set<Long> num_set = new HashSet<>();
        for (int i = 0; i < num.length(); i++) {
            num_set.add((long) (num.charAt(i) - '0'));
        }

        for (long nn:
                num_set) {
            if(nn != 0 && n % nn == 0) answer++;
        }

        return answer;
    }
}
