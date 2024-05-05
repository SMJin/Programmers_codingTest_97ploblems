import java.util.ArrayDeque;

public class PairOff_11 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    /*
    알파벳 소문자로 구성된 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
    짝을 찾은 다음에는 그 둘을 제거한 뒤 앞뒤로 문자열을 이어 붙입니다.
    이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
    문자열 S가 주어졌을 때 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성하세요.
    성공적으로 수행할 수 있으면 1을, 아니면 0을 반환해주면 됩니다.
    예를 들어 문자열 S 가 baabaa 라면
    - baabaa -> bbaa -> aa
    순서로 모두 제거할 수 있으므로 1을 반환합니다.

    [제약 조건]
    - 문자열의 길이 : 1,000,000 이하의 자연수
    - 문자열은 모두 소문자로 이루어져 있습니다.
     */
    private static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
