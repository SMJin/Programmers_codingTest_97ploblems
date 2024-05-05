import java.util.ArrayDeque;
import java.util.HashMap;

public class CraneClawGame_13 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;

        HashMap<Integer, ArrayDeque<Integer>> stackBoard = new HashMap<>();

        int n = board.length;
        for (int i=0; i<n; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int j=n-1; j>=0; j--) {
                if (board[j][i] != 0) stack.push(board[j][i]);
            }
            stackBoard.put(i+1, stack);
        }
//        System.out.println(stackBoard);

        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int m : moves) {
            if (!stackBoard.get(m).isEmpty()) {
                int picked = stackBoard.get(m).pop();
                if (!result.isEmpty() && result.peek() == picked) {
                    result.pop();
                    answer += 2;
                } else {
                    result.push(picked);
                }
            }
        }

        return answer;
    }
}
