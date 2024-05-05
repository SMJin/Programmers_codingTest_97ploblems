import java.util.Arrays;
import java.util.Stack;

public class rotationBracket_10 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
    }


    private static String[] brackets = null;
    /*
    다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

    - `()`, `[]`, `{}` 는 모두 올바른 괄호 문자열입니다.
    - 만약 A가 올바른 괄호 문자열이라면, `(A)`, `[A]`, `{A}` 도 올바른 괄호 문자열입니다.
      예를 들어 `[]` 가 올바른 괄호 문자열이므로, `([])` 도 올바른 괄호 문자열입니다.
    - 만약 A, B가 올바른 괄호 문자열이라면, AB도 올바른 괄호 문자열입니다.
      예를 들어 `{}`와 `([])`가 올바른 괄호 문자열이므로, `{}([])` 도 올바른 괄호 문자열입니다.

    대괄호, 중괄호 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
    이 s를 왼쪽으로 x(0 <= x < (s의 길이)) 칸만큼 회전했을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 반환하시오.

    [제약 조건]
    - s의 길이는 1 이상 1,000 이하입니다.
     */
    private static int solution(String s) {
        // s를 저장할 배열 및 result count 저장할 변수 생성
        int resultCnt = 0;
        brackets = s.split("");

//        System.out.println(Arrays.toString(brackets));

        // 회전을 배열을 직접하지 않고 시작 idx, 끝내는 idx 로 대체할 변수 설정
        int startIdx = 0;
        if (isMatch(startIdx)) resultCnt ++;

        for (int i=0; i< brackets.length-1; i++) {
            if (isMatch((++startIdx)% brackets.length)) resultCnt ++;
        }

        // 위치 회전하기
        return resultCnt;
    }

    private static boolean isMatch(int startIdx) {
        // Stack 생성
        Stack<String> stack = new Stack<>();

        int currentIdx = startIdx;
        // Stack 에 넣어가면서 짝이 맞는지 확인
        for (int i=0; i<brackets.length; i++) {
//            System.out.print("currentIdx : " + currentIdx + " ");

            if (!stack.isEmpty() && isMatch(stack.peek(), brackets[currentIdx])) {
                stack.pop();
            } else {
                stack.push(brackets[currentIdx]);
            }

//            System.out.println(stack);

            currentIdx ++;
            currentIdx %= brackets.length;
        }

//        System.out.println(stack);
        return stack.isEmpty();
    }

    private static boolean isMatch(String popStack, String str) {
        if (popStack.equals("(") && str.equals(")")) return true;
        if (popStack.equals("[") && str.equals("]")) return true;
        if (popStack.equals("{") && str.equals("}")) return true;

        return false;
    }
}
