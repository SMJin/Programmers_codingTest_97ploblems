import java.util.ArrayDeque;

public class rotationBracket_10 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
    }

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

//        System.out.println(Arrays.toString(brackets));

        // 회전을 배열을 직접하지 않고 시작 idx, 끝내는 idx 로 대체할 변수 설정
        int startIdx = 0;
        if (isMatch(startIdx, s)) resultCnt ++;

        for (int i=0; i< s.length()-1; i++) {
            if (isMatch((++startIdx) % s.length(), s)) resultCnt ++;
        }

        // 위치 회전하기
        return resultCnt;
    }

    private static boolean isMatch(int startIdx, String s) {
        // Stack 생성
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int currentIdx = startIdx;
        // Stack 에 넣어가면서 짝이 맞는지 확인
        for (int i=0; i< s.length(); i++) {
//            System.out.print("currentIdx : " + currentIdx + " ");
            Character curCh = s.charAt(currentIdx);

            if (!stack.isEmpty() && isMatch(stack.peek(), curCh)) {
                stack.pop();
            } else {
                stack.push(curCh);
            }

//            System.out.println(stack);

            currentIdx ++;
            currentIdx %= s.length();
        }

//        System.out.println(stack);
        return stack.isEmpty();
    }

    private static boolean isMatch(Character popStack, Character ch) {
        if (popStack == '(' && ch == ')') return true;
        if (popStack == '[' && ch == ']') return true;
        if (popStack == '{' && ch == '}') return true;

        return false;
    }
}
