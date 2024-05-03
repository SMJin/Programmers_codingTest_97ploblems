import java.util.Arrays;

public class Transpose_60 {
    public static void main(String[] args) {

//        int[][] matrix1 = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[][] matrix2 = {
//                {9, 8, 7},
//                {6, 5, 4},
//                {3, 2, 1}
//        };
//        System.out.println(Arrays.deepToString(solution(matrix1, matrix2)));

        int[][] matrix1 = {
                {2, 4, 6},
                {1, 3, 5},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {9, 1, 2},
                {4, 5, 6},
                {7, 3, 8}
        };
        System.out.println(Arrays.deepToString(solution(matrix1, matrix2)));
    }

    /*
    matrix1과 matrix2는 정수값으로 이루어진 3x3행렬입니다.
    이 두 행렬을 곱한 결과의 전치 행렬을 반환하시오.

    matrix1, matrix2는 각각 3x3크기의 정수 행렬입니다.
     */
    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        return trans(multiple(matrix1, matrix2));
    }

    private static int[][] trans(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;
        int[][] result = new int[x][y];

        for (int i=0; i< x; i++) {
            for (int j=0; j< y; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    private static int[][] multiple(int[][] matrix1, int[][] matrix2) {
        int x = matrix1[0].length;
        int y = matrix2.length;
        int[][] result = new int[x][y];

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                for (int k=0; k<x; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
