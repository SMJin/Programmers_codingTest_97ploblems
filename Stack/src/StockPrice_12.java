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
        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i<n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}
