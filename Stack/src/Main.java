import java.util.ArrayDeque;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("empty : " + stack_08(""));
        System.out.println("() : " + stack_08("()"));
        System.out.println("()) : " + stack_08("())"));
        System.out.println("( : " + stack_08("("));
        System.out.println("()() : " + stack_08("()()"));
        System.out.println(")()() : " + stack_08(")()()"));
        System.out.println("(())() : " + stack_08("(())()"));
        System.out.println("(()) : " + stack_08("(())")); // error

//        System.out.println("() : " + stack_08_2("()"));
//        System.out.println("empty : " + stack_08_2(""));
//        System.out.println("()) : " + stack_08_2("())"));
//        System.out.println("( : " + stack_08_2("("));
//        System.out.println("()() : " + stack_08_2("()()"));
//        System.out.println(")()() : " + stack_08_2(")()()"));
//        System.out.println("(()) : " + stack_08_2("(())"));
//        System.out.println("((()) : " + stack_08_2("((())"));

//        ★ 스택의 핵심은 가장 가까운 (최근) 열린 괄호와 상쇄된다는 점!!!!

//        System.out.println("() : " + stack_08_solution("()"));
//        System.out.println("empty : " + stack_08_solution(""));
//        System.out.println("()) : " + stack_08_solution("())"));
//        System.out.println("( : " + stack_08_solution("("));
//        System.out.println("()() : " + stack_08_solution("()()"));
//        System.out.println(")()() : " + stack_08_solution(")()()"));
//        System.out.println("(()) : " + stack_08_solution("(())"));
//        System.out.println("((()) : " + stack_08_solution("((())"));

//        System.out.println("2 : " + stack_09(2));
//        System.out.println("4 : " + stack_09(4));
//        System.out.println("10 : " + stack_09(10));
//        System.out.println("12 : " + stack_09(12));
//        System.out.println("3 : " + stack_09(3));

    }

    /*
        괄호가 올바르게 되어 있으면 true 반환하시오.

        [제약조건]
        문자열 s의 길이: 100,000 이하의 자연수
        문자열 s는 '(' 또는 ')'로만 이루어져 있습니다.
     */
    public static boolean stack_08(String s) {
        // Stack 문제풀이 : 순서가 있다, 순서대로 요소를 빼낸다.
        Stack<Character> stack = new Stack<>();
        if (s.isEmpty()) {
            return true;
        }

        if (s.charAt(0) == ')') {
//            System.out.println("empty 한데 ( 열린 시작이 아니라니!");
            return false;
        }

        if (s.charAt(s.length()-1) == '(') {
//            System.out.println("끝 ch 가 ( 열린결말입니다");
            return false;
        }

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') stack.pop();
            else stack.push(ch);
        }

        return stack.isEmpty();
    }

    public static boolean stack_08_2(String input) {
        Stack<Character> stack = new Stack<>();

        if (input.isEmpty()) return true;
        if (input.charAt(0) == ')' || input.charAt(input.length()-1) == '(') return false;

        int countToClose = 0;
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                countToClose ++;
                stack.push(ch);
            } else {
                if (--countToClose < 0) {
                    return false;
                }
                stack.pop();
            }
        }

        return (countToClose == 0);
    }

    public static boolean stack_08_solution(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] inputArray = input.toCharArray();
        for (char ch : inputArray) {
            if (ch == '(') stack.push(ch);
            else {
//                if (stack.isEmpty()) return false;
//                else stack.pop();
                if (stack.isEmpty() || stack.pop() == ch) return false;
            }
        }
        return stack.isEmpty();
    }

    /*
        10진수를 입력받아 2진수로 변환하시오

        [제약조건]
        decimal은 1이상 10억 미만의 자연수
     */
    public static String stack_09(int input) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // while (input > 0) 이렇게하면 마지막에 push 안해도됨
        while(input != 0 && input != 1) {
            stack.push(input % 2);
            input /= 2;
        }
        stack.push(input);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}