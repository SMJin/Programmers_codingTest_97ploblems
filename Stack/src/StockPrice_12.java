import java.util.ArrayDeque;
import java.util.Arrays;

public class StockPrice_12 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    /*
    초 단위로 기록된 주식 가격이 담긴 배열 prices 가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지 반환하시오.

    [제약 조건]
    - prices 의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    - prices 의 길이는 2 이상 100,000 이하 입니다.
     */
    private static int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        // Stack 생성
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        stack.push(idx);

        while (++idx != prices.length) {
            // 만약 stack 의 최상위 값이 더 작다면 push
            if (!stack.isEmpty()) {
                if (prices[stack.peek()] < prices[idx]) {
                    stack.push(idx);
                } else {
                    while (!stack.isEmpty() && prices[stack.peek()] > prices[idx]) {
                        int popIdx = stack.pop();
                        result[popIdx] = idx - popIdx;
                    }
                    stack.push(idx);
                }
            }
        }


        while (!stack.isEmpty()) {
            int popIdx = stack.pop();
            result[popIdx] = prices.length-1 - popIdx;
        }

        return result;
    }
}
