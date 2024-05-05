import java.util.ArrayDeque;

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

        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int m : moves) {
            for (int j=0; j< board.length; j++) {
                if (board[j][m-1] != 0) {
                    if (!result.isEmpty() && result.peek() == board[j][m-1]) {
                        result.pop();
                        answer += 2;
                    }
                    else {
                        result.push(board[j][m-1]);
                    }
                    board[j][m-1] = 0;

                    break;
                }
            }
        }

        return answer;
    }
}
