import java.util.ArrayList;
import java.util.Arrays;

public class MockExam_04 {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
    }

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

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i=0; i<answers.length; i++) {
            for (int j=0; j< patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) scores[j] ++;
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
