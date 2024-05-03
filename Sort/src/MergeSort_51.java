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
        int size = arr1.length + arr2.length;
        int[] result = new int[size];
        int idx = 0;

        // 각 배열을 가리켜야 한다. 그 로직은?
        int idx1 = 0;
        int idx2 = 0;

        int cur1 = arr1[idx1];
        int cur2 = arr2[idx2];

        while(idx1 != arr1.length && idx2 != arr2.length) {

            if (cur1 <= cur2) {
                result[idx++] = cur1;
                idx1++;
                if (idx1 < arr1.length) cur1 = arr1[idx1];
            } else {
                result[idx++] = cur2;
                idx2++;
                if (idx2 < arr2.length) cur2 = arr2[idx2];
            }

        }

        while (idx1 < arr1.length) {
            result[idx++] = arr1[idx1];
            idx1++;
        }
        while (idx2 < arr2.length) {
            result[idx++] = arr2[idx2];
            idx2++;
        }

        return result;
    }
}
