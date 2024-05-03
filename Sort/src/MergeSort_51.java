import java.util.Arrays;

public class MergeSort_51 {
    public static void main (String[] args) {
//        int[] arr1 = {1, 3, 5};
//        int[] arr2 = {2, 4, 6};
//        System.out.println(Arrays.toString(solution(arr1, arr2)));

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {4, 5, 6};
        System.out.println(Arrays.toString(solution(arr1, arr2)));

    }

    /*
        arr1과 arr2는 각각 길이가 1 이상 100,000 이하입니다.
        arr1과 arr2는 각각 오름차순으로 정렬되어 있습니다.

        이미 정렬이 완료되어 있는 두 배열을 받아 병합 정렬 하시오.
     */
    private static int[] solution(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0;

        while(i < arr1.length && j < arr2.length) {
            result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
