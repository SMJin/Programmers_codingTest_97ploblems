import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FailRate_06 {
    public static void main(String[] args) {
//        int N = 5;
//        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    /*
    2019 KAKAO BLIND RECRUITMENT

    슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌습니다.
    그녀가 만든 프렌즈 오천성이 대성공을 거뒀지만 최근 신규 사용자 수가 급감했기 때문입니다.
    원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였습니다.
    이 문제를 어떻게 할까 고민한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했습니다.
    역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만 실패율을 구하는 부분에서 위기에 빠지고 말았습니다.
    오렐리를 위해 실패율을 구하는 코드를 완성하세요.

    - 실패율 정의 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어의 수

    전체 스테이지 개수가 N, 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages 가 주어집니다.
    이때 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 반환하시오.

    [제약 조건]
    - 스테이지 개수 N은 1 이상 500 이하의 자연수입니다.
    - stages 의 길이는 1 이상 200,000 이하입니다.
    - stages 에는 1 이상 N+1 이하의 자연수가 있습니다.
        - 각 자연수는 사용자가 현재 도전 중인 스테이지 번호를 나타냅니다.
        - 단, N+1 은 마지막 스테이지, 즉 N까지 클리어한 사용자를 나타냅니다.
    - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오면 됩니다.
    - 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의합니다.
     */
    private static int[] solution(int N, int[] stages) {
        int ppAmt = stages.length;

        int[] numberOfStage = new int[N+1];
        for (int stage : stages) {
            if (stage < N+1) numberOfStage[stage] ++;
        }

        System.out.println(Arrays.toString(numberOfStage));

        ArrayList<FailRate> failRates = new ArrayList<>();
        for (int i=1; i<numberOfStage.length; i++) {
            failRates.add(new FailRate(i,numberOfStage[i]*1.0 / ppAmt));
            ppAmt -= numberOfStage[i];
        }

//        int[] result = new int[N];

        return failRates.stream()
                .sorted(Comparator.comparing(FailRate::getRate).reversed())
                .map(FailRate::getStgNum)
                .mapToInt(Double::intValue)
                .toArray();
    }

    public static class FailRate {
        public FailRate(int stgNum, double rate) {
            this.stgNum = stgNum;
            this.rate = rate;
        }

        private int stgNum;
        private double rate;

        public double getStgNum() {
            return this.stgNum;
        }

        public double getRate() {
            return this.rate;
        }

        public String toString() {
            return "[stgNum = " + stgNum +
                    ", rate = " + rate + "]";
        }
    }
}
