import java.util.Arrays;

public class MockExam_04 {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }

    private static final int[] studentA = {1, 2, 3, 4, 5};
    private static final int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    /*
    수포자는 수학을 포기한 사람을 줄인 표현이다.
    수포자 삼임방은 모의고사에 수학 문제를 전부 찍으려 한다.
    수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍는다.

    - 1번 수포자가 찍는 방식 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    - 2번 수포자가 찍는 방식 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    - 3번 수포자가 찍는 방식 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지 정답이 순서대로 저장된 배열 answers 가 주어졌을 때
    가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하시오.

    [제약 조건]
    - 시험은 최대 10,000 문제로 구성되어 있다.
    - 문제의 정답은 1, 2, 3, 4, 5 중 하나이다.
    - 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬하라.
     */
    private static int[] solution(int[] answers) {
        int a = 0, b = 0, c = 0;
        int cntA = 0, cntB = 0, cntC = 0;

        for (int answer : answers) {
            if (studentA[a++] == answer) cntA ++;
            if (a == studentA.length) a = 0;

            if (studentB[b++] == answer) cntB ++;
            if (b == studentB.length) b = 0;

            if (studentC[c++] == answer) cntC ++;
            if (c == studentC.length) c = 0;
        }

        if (cntA == cntB && cntA == cntC) return new int[] {1, 2, 3};

        if (cntA > cntB) {
            if (cntA > cntC) return new int[] {1};
            if (cntA == cntC) return new int[] {1, 3};
            return new int[] {3};
        }

        if (cntB > cntA) {
            if (cntB > cntC) return new int[] {2};
            if (cntB == cntC) return new int[] {2, 3};
            return new int[] {3};
        }

        return null;
    }
}
