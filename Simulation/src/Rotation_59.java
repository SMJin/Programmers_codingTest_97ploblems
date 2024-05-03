import java.util.Arrays;

public class Rotation_59 {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//        int n = 1;
//        System.out.println(Arrays.deepToString(solution(arr, n)));

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n = 2;
        System.out.println(Arrays.deepToString(solution(arr, n)));
    }

    /*
    2차원 배열 arr을 시계 방향으로 90도 * n번 회전하는 solution() 함수를 작성하시오.

    회전 횟수 n은 자연수이며 1~4입니다.
    2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않습니다.
     */

    private static int[][] solution(int[][] arr, int n) {

        for (int i=0; i<n; i++) {
            arr = rotation(arr);
        }

        return arr;
    }

    private static int[][] rotation(int[][] arr) {
        int size = arr.length;
        int[][] result = new int[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                result[i][j] = arr[(size-1)-j][i];
            }
        }

        return result;
    }
}
