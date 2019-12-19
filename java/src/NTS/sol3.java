package NTS;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sol3 {
    static String openBracket = "({[";
    static String closeBracket = ")}]";

    public static void main(String[] args) {
        System.out.println(solution("()"));
    }

    public static boolean solution(String input) {
        boolean answer = true;

        String REGEX = "[^(){}\\[\\]]";
        Stack<Character> stack = new Stack<>();

        Pattern pattern = Pattern.compile(REGEX);

        Matcher matcher = pattern.matcher(input);
        input = matcher.replaceAll("");
        System.out.println(input);


        char current;
        int border = -1;
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);

            if (stack.isEmpty()) {
                stack.push(current);
            } else {
                if (openBracket.contains(String.valueOf(stack.peek()))) {
                    border = openBracket.indexOf(stack.peek());
                    if (openBracket.contains(String.valueOf(current))) {
                        if (border <= openBracket.indexOf(current)) {
                            answer = false;
                            break;
                        }

                        stack.push(current);
                        continue;
                    }
                }

                if (closeBracket.contains(String.valueOf(current))) {
                    try {
                        if (current == closeBracket.charAt(border))
                            stack.pop();
                        else {
                            answer = false;
                            break;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        answer = false;
                        break;
                    }

                }
            }
        }
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}












