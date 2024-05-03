import java.util.Arrays;

public class LCS_67 {

    public static void main(String[] args) {
//        String str1 = "ABCBDAB";
//        String str2 = "BDCAB";
//        System.out.println(solution(str1, str2));

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(solution(str1, str2));
    }

    private static int solution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i=1; i< result.length; i++) {
            for (int j=1; j< result[i].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result[m][n];
    }
}
