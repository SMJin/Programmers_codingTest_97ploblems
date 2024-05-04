import java.util.Arrays;

public class multipleMatrix_05 {
    public static void main(String[] args) {
//        int[][] arr1 = {
//                {1, 4},
//                {3, 2},
//                {4, 1}
//        };
//        int[][] arr2 = {
//                {3, 3},
//                {3, 3}
//        };
        int[][] arr1 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4},
        };
        int[][] arr2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1},

        };
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    /*
    2차원 행렬 arr1과 arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하시오.

    [제약 조건]
    - 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
    - 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수
    - 곱할 수 있는 배열만 주어진다.
     */
    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int n = arr2[0].length;
        int[][] result = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k< arr2.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}
