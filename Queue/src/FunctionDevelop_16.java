import java.util.ArrayDeque;
import java.util.Arrays;

public class FunctionDevelop_16 {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    /*
    프로그래머스팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100% 일 때 서비스에 반영할 수 있습니다.
    또 각 기능의 개발 속도는 모두 다르므로 뒤의 기능이 앞의 기능보다 먼저 개발될 수도 있습니다.
    이때, 뒤의 기능은 앞의 기능이 배포될때 함께 배포되어야 합니다.
    배포 순서대로 작업 징도가 적힌 정수 배열 progresses 와 각 작업의 개발 속도가 적힌 정수 배열 speeds 가 주어질 때
    각 배포마다 몇 개의 기능이 배포되는지를 반환하시오.

    [제약 조건]
    - 작업 개수(progresses, speeds 의 배열 길이)는 100개 이하입니다.
    - 작업 진도는 100 미만의 자연수입니다.
    - 작업 속도는 100 이하의 자연수입니다.
    - 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
      예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     */
    private static int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> que = new ArrayDeque<>(); // 정답 queue

        int totalCnt = 0;
        int startIdx = 0;

        while (totalCnt < progresses.length) {
            if (progresses[startIdx] >= 100) {
                int complete = 0;
                for (int i=startIdx; i<progresses.length; i++) {
                    if (progresses[i] < 100) {
                        startIdx = i;
                        break;
                    }
                    complete ++;
                }
                totalCnt += complete;
                que.add(complete);
            }

            for (int i=startIdx; i< progresses.length; i++) {
                if (progresses[i] < 100) progresses[i] += speeds[i];
            }
        }

        return que.stream().mapToInt(Integer::intValue).toArray();
    }
}
